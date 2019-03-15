﻿using System;
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
    }
}
