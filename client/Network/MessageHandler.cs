using GameOfELTE.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfELTE.Network
{
    public class MessageHandler : IMessageHandler
    {
        private INetworkManager Manager;
        private IGameService Game;
        private IGUIService GUI;

        public MessageHandler(INetworkManager manager, IGameService game, IGUIService gui)
        {
            Manager = manager;
            Game = game;
            GUI = gui;

            manager.BindCommand("RANDOM_NUMBERS", ReceiveRandomNumbers);
            manager.BindCommand("RESPONSE", ReceiveResponse);
            manager.BindCommand("ACTIVATED", ReceiveActivated);
        }

        private void ReceiveRandomNumbers(Message msg)
        {
            List<int> randomNumbers = new List<int>();

            string[] split = msg.Data.Split(',');

            foreach (string s in split)
                randomNumbers.Add(int.Parse(s));

            Game.SetRandomNumbers(randomNumbers);
        }

        private void ReceiveResponse(Message msg)
        {
            //TODO talán kezdeni vele valamit, talán nem
        }

        private void ReceiveActivated(Message msg)
        {
            //TODO
        }
    }
}
