using GameOfELTE.Game;
using GameOfELTE.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace GameOfELTE.Network
{
    public class GameService : IGameService
    {
        private INetworkManager Manager;
        private IGUIService GUI;
        private List<int> RandomNumbers;
        private Random Random = new Random();
        private List<LuckyCard> LuckyCards = new List<LuckyCard>();
        private Player Player;

        public GameService(INetworkManager manager, IGUIService gui)
        {
            Manager = manager;
            GUI = gui;
        }

        public void Connect(string address, int port)
        {
            Manager.Connect(address, port);
        }

        public Board GetBoard()
        {
            Manager.SendMessage(new Message("GET_BOARD"));

            Message msg = Manager.ReceiveMessage("BOARD");

            //TODO létrehozni a boardot az msg.Data-ból és visszaadni

            return null;
        }

        public List<LuckyCard> GetLuckyCards()
        {
            Manager.SendMessage(new Message("GET_LUCKY_CARDS"));

            Message msg = Manager.ReceiveMessage("LUCKY_CARDS");

            //TODO létrehozni a listát az msg.Data-ból és visszaadni

            return null;
        }

        public int GetRandomNumber()
        {
            int i = Random.Next(RandomNumbers.Count);
            int n = RandomNumbers[i];
            RandomNumbers.RemoveAt(i);

            return n;
        }

        public void PickLuckyCard()
        {
            throw new NotImplementedException();
        }

        public void SendLuckyCard(LuckyCard luckyCard)
        {
            throw new NotImplementedException();
        }

        public void SendMessage(string msg)
        {
            Manager.SendMessage(new Message("MSG", msg));
        }

        public void SendPosition(int field)
        {
            throw new NotImplementedException();
        }

        public void SetMoney(int money)
        {
            Player.Money = money;

            GUI.UpdateMoney(money);
        }

        public void SetRandomNumbers(List<int> numbers)
        {
            RandomNumbers = numbers;
        }
    }
}
