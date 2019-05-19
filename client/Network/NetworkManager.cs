using GameOfELTE.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace GameOfELTE.Network
{
    public class NetworkManager : INetworkManager
    {
        private TcpClient Client;
        private NetworkStream Stream;
        private Thread ReceiveThread;
        private Dictionary<string, SynchronizedMessage> SynchronizedMessageWaiters = new Dictionary<string, SynchronizedMessage>();
        private Dictionary<string, Action<Message>> CommandBindings = new Dictionary<string, Action<Message>>();
        private List<Message> CachedMessages = new List<Message>();

        private class SynchronizedMessage
        {
            public Message Message { get; set; }

            public ManualResetEvent Event { get; private set; } = new ManualResetEvent(false);
        }

        public void Connect(string address, int port)
        {
            Client = new TcpClient();

            IAsyncResult result = Client.BeginConnect(address, port, null, null);

            bool success = result.AsyncWaitHandle.WaitOne(1000, true);

            if (success && Client.Connected)
            {
                Client.EndConnect(result);
                Stream = Client.GetStream();

                if (ReceiveThread == null)
                {
                    ReceiveThread = new Thread(() => ReceiveMessagesFromServer());
                    ReceiveThread.Start();
                }
            }
            else
            {
                throw new Exception("Nem sikerült kapcsolódni a szerverhez.");
            }
        }

        private void ReceiveMessagesFromServer()
        {
            while(true)
            {
                byte[] data = new byte[65536];
                int n = Stream.Read(data, 0, data.Length);

                string[] split = Encoding.UTF8.GetString(data, 0, n).Split(';');

                Message msg = new Message(split[0], split[1]);

                if (CommandBindings.ContainsKey(msg.Command))
                    CommandBindings[msg.Command](msg);
                else if (SynchronizedMessageWaiters.ContainsKey(msg.Command))
                {
                    SynchronizedMessageWaiters[msg.Command].Message = msg;
                    SynchronizedMessageWaiters[msg.Command].Event.Set();
                    SynchronizedMessageWaiters.Remove(msg.Command);
                }
                else
                    CachedMessages.Add(msg);
            }
        }

        public void SendMessage(Message msg)
        {
            byte[] data = Encoding.UTF8.GetBytes(msg.ToString());
            Stream.Write(data, 0, data.Length);
            Stream.Flush();
        }

        public Message ReceiveMessage(string command)
        {
            Message msg = CachedMessages.FirstOrDefault(x => x.Command.Equals(command));

            if(msg == null)
            {
                SynchronizedMessage synchronizedMessage;

                if (SynchronizedMessageWaiters.ContainsKey(command))
                    synchronizedMessage = SynchronizedMessageWaiters[command];
                else
                {
                    synchronizedMessage = new SynchronizedMessage();
                    SynchronizedMessageWaiters.Add(command, synchronizedMessage);
                }

                synchronizedMessage.Event.WaitOne();
                msg = synchronizedMessage.Message;
            }
            else
            {
                CachedMessages.Remove(msg);
            }

            return msg;
        }

        public void BindCommand(string command, Action<Message> method)
        {
            CommandBindings.Add(command, method);
        }

        public void UnbindCommand(string command)
        {
            CommandBindings.Remove(command);
        }
    }
}
