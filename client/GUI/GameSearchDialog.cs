using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GameOfELTE.GUI
{
    using Interfaces;

    public partial class GameSearchDialog : Form
    {
        IGameService GameService;
        int playerCount = 0;
        int maxPlayerCount;

        public GameSearchDialog(IGameService gameService)
        {
            InitializeComponent();

            GameService = gameService;
            GameService.NetworkManager.BindCommand("REMOTE_CONNECTED", RemoteClientConnected);
        }

        private void search_Click(object sender, EventArgs e)
        {
            if (!int.TryParse(this.port.Text, out int port))
            {
                MessageBox.Show("Hibás portszám", "Hiba", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            try
            {
                GameService.Connect(ip.Text, port);
                maxPlayerCount = GameService.GetMaxPlayerCount();
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message, "Hiba", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void RemoteClientConnected(Network.Message msg)
        {
            playerCount++;

            Invoke((MethodInvoker)delegate 
            {
                info.Text = playerCount + " db játékos kész";

                if (playerCount == maxPlayerCount)
                {
                    GameService.NetworkManager.UnbindCommand("REMOTE_CONNECTED");
                    DialogResult = DialogResult.Yes;
                }
            });
        }
    }
}
