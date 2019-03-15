using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;

namespace GameOfELTE.Interfaces
{
    public interface IGameService
    {
        /// <summary>
        /// Csatlakozik az endpoint által meghatározott IP-címen és porton egy szerverhez
        /// </summary>
        void Connect(string address, int port);

        /// <summary>
        /// Elküd egy szöveges üzenetet a többi játékosnak
        /// </summary>
        void SendMessage(string msg);

        /// <summary>
        /// Elküldi a szervernek a játékos pozícióját
        /// </summary>
        /// <param name="field">a játékos pozíciója</param>
        void SendPosition(int field);

        /// <summary>
        /// Elküldi a szervernek a felhúzott/felhasznált szerencsekártyát
        /// </summary>
        void SendLuckyCard(Game.LuckyCard luckyCard);

        /// <summary>
        /// Visszaad egy random számot a szerver által legenerált sorozatból
        /// </summary>
        int GetRandomNumber();

        /// <summary>
        /// Lekérdezi a játékban elérhető összes szerencsekártyát
        /// </summary>
        List<Game.LuckyCard> GetLuckyCards();

        /// <summary>
        /// Lekérdezi a pályát
        /// </summary>
        Game.Board GetBoard();

        /// <summary>
        /// Felhúz egy szerencsekártyát
        /// </summary>
        void PickLuckyCard();

        /// <summary>
        /// Beállítja a randomszámok listáját
        /// </summary>
        /// <param name="numbers"></param>
        void SetRandomNumbers(List<int> numbers);

        void SetMoney(int money);
    }
}
