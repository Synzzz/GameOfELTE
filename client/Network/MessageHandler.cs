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
            manager.BindCommand("GAME_OVER", ReceiveScoreBoard);
            manager.BindCommand("COLOR", ReceivePlayerColor);
            manager.BindCommand("SHOW_SUBJECT_REGISTRATION_WINDOW", ReceiveSubjectRegistrationWindow);
            manager.BindCommand("SET_MONEY", ReceivePlayerMoney);
            manager.BindCommand("LEARN_SUBJECT", ReceiveLearnSubject);
            manager.BindCommand("WORK_OR_STUDY", ReceiveWorkOrStudy);
            manager.BindCommand("COURSE_REQUEST", ReceiveCourseRequest);
            manager.BindCommand("LOSING_KNOWLEDGE", ReceiveLosingKnowledge);
            manager.BindCommand("OFFERED_MARK", ReceiveOfferedMark);
            manager.BindCommand("MATEKING_CHOICE", ReceiveMatekingChoice);
            manager.BindCommand("OVERTIME_WORK", ReceiveOvertimeWork);
            manager.BindCommand("UNREGISTER_SUBJECT", ReceiveUnregisterSubject); 
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
            GUI.Activate();
        }

        private void ReceiveScoreBoard(Message msg)
        {
            List<int> scoreboard = new List<int>();

            string[] split = msg.Data.Split(',');

            foreach (string s in split)
                scoreboard.Add(int.Parse(s));

            GUI.ShowScoreBoardWindow(scoreboard);
        }

        private void ReceivePlayerColor(Message msg)
        {
            Game.SetPlayerColor((GameOfELTE.Game.PlayerColor)int.Parse(msg.Data));
        }

        private void ReceiveSubjectRegistrationWindow(Message msg)
        {
            GUI.ShowSubjectRegistrationWindow();
        }

        private void ReceiveLearnSubject(Message msg)
        {
            GUI.ShowLearnSubjectWindow();
        }

        private void ReceiveWorkOrStudy(Message msg)
        {
            GUI.ShowWorkOrStudyWindow();
        }

        private void ReceiveCourseRequest(Message msg)
        {
            GUI.ShowCourseRequestWindow();
        }

        private void ReceiveLosingKnowledge(Message msg)
        {
            GUI.ShowLosingKnowledgeWindow();
        }

        private void ReceiveOfferedMark(Message msg)
        {
            GUI.ShowOfferedMarkWindow();
        }

        private void ReceiveMatekingChoice(Message msg)
        {
            GUI.ShowMatekingChoiceWindow();
        }

        private void ReceiveOvertimeWork(Message msg)
        {
            GUI.ShowOvertimeWorkWindow();
        }

        private void ReceiveUnregisterSubject(Message msg)
        {
            GUI.ShowUnregisterSubjectWindow();
        }

        private void ReceivePlayerMoney(Message msg)
        {
            Game.SetMoney(int.Parse(msg.Data));
        }
    }
}
