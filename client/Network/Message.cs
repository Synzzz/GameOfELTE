using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfELTE.Network
{
    public class Message
    {
        public string Command { get; private set; }

        public string Data { get; private set; }

        public Message(string command, string data)
        {
            Command = command;
            Data = data;
        }

        public Message(string command) : this(command, null)
        {

        }

        public override string ToString()
        {
            StringBuilder builder = new StringBuilder();

            builder.Append(Command);
            builder.Append(";");
            builder.Append(Data);
            builder.AppendLine();

            return builder.ToString();
        }
    }
}
