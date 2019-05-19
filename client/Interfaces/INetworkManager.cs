using GameOfELTE.Network;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfELTE.Interfaces
{
    public interface INetworkManager
    {
        void Connect(string address, int port);

        void SendMessage(Message msg);

        Message ReceiveMessage(string command);

        void BindCommand(string command, Action<Message> method);

        void UnbindCommand(string command);
    }
}
