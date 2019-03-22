using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfELTE.Interfaces
{
    public interface IGUIService
    {
        /// <summary>
        /// Beállítja egy játékos pozícióját a megadott értékre
        /// </summary>
        /// <param name="player">A játékos azonosítója</param>
        /// <param name="field">Az új pozíció</param>
        void SetPlayerPosition(int player, int field);

        /// <summary>
        /// Kiír egy üzenetet a chat-be
        /// </summary>
        /// <param name="player">Az üzenő játékos</param>
        /// <param name="msg">Az üzenet</param>
        void PrintMessage(Game.Player player, string msg);

        /// <summary>
        /// Megjeleníti a képernyőn az adott szerencsekártyát
        /// </summary>
        /// <param name="card"></param>
        void ShowLuckyCard(Game.LuckyCard card);

        /// <summary>
        /// Megjeleníti a képernyőn a tárgyfelvétel ablakot
        /// </summary>
        void ShowSubjectRegistrationWindow();

        /// <summary>
        /// Megjeleníti a képernyőn a tudás választó ablakot
        /// </summary>
        void ShowKnowledgeChoosingWindow();

        /// Megjeleníti a kpernyőn az eredménytáblát
        void ShowScoreBoard(List<int> scoreboard);

        //Egy tárgy elvesztésének megjelenítése
        void ShowUnregisterSubject();

        //Túlóra megjelenítése a képernyőn
        void ShowOvertimeWork();

        //Megjeleníti a Mateking választási lehetőségét a képernyőn
        void ShowMatekingChoice();

        //Munka vagy tanulás választó megjelenítése 
        void ShowWorkOrStudy();

        //Megajánlott jegy megjelenítése
        void ShowOfferedMark();

        //Elvesztett tudás megjelenítése
        void ShowLosingKnowledge();

        //Tárgyfelvételi kérvény megjelenítése
        void ShowCourseRequest();

        /// <summary>
        /// Frissíti a pénz kijelzését a képernyőn
        /// </summary>
        /// <param name="money"></param>
        void UpdateMoney(int money);

        /// <summary>
        /// Aktiválja a GUI-t
        /// </summary>
        void Activate();
        void ShowLearnSubject();

        /// <summary>
        /// Deaktiválja a GUI-t
        /// </summary>
        void Deactivate();
    }
}
