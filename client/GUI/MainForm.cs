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
    using Network;
    using Interfaces;

    public partial class MainForm : Form
    {
        private IGameService Game;

        public MainForm()
        {
            InitializeComponent();

            Game = new GameService(new NetworkManager(), new GUI(this));

            string[] fieldTexts = { "Tárgyfelvétel/Start", "Kurzus", "Kurzs", "Kurzus", "Kitúrtak", "Kurzus", "Kurzus", "Kurzus", "Tárgyfelvétel kérvény", "Munka/Tanulás", "Rossz időpont", "Munka/Tanulás", "Kártya", "Munka/Tanulás", "Szórakozás", "Munka/Tanulás", "4. hiányzás", "Munka/Tanulás", "Elengedés", "Munka/Tanulás", "Kártya", "Munka/Tanulás", "Szórakozás", "Munka/Tanulás", "Felsőbbéves jegyzete", "Vizsga", "Vizsga", "Vizsga", "Vizsga", "Lehetetlen vizsga", "Vizsga", "Vizsga" };

            int j = 0;
            for(int i = 0; i < 9; i++)
            {
                fields[j] = new Label();
                fields[j].Size = new Size(100, 100);
                fields[j].Location = new Point(50 + 100 * i, 50);
                fields[j].TextAlign = ContentAlignment.MiddleCenter;
                fields[j].Text = fieldTexts[j];
                fields[j].Parent = this;
                fields[j].BorderStyle = BorderStyle.Fixed3D;

                j++;
            }

            for (int i = 0; i < 7; i++)
            {
                fields[j] = new Label();
                fields[j].Size = new Size(100, 100);
                fields[j].Location = new Point(850, 150 + 100 * i);
                fields[j].TextAlign = ContentAlignment.MiddleCenter;
                fields[j].Text = fieldTexts[j];
                fields[j].Parent = this;
                fields[j].BorderStyle = BorderStyle.Fixed3D;

                j++;
            }

            for (int i = 0; i < 9; i++)
            {
                fields[j] = new Label();
                fields[j].Size = new Size(100, 100);
                fields[j].Location = new Point(850 - 100 * i, 850);
                fields[j].TextAlign = ContentAlignment.MiddleCenter;
                fields[j].Text = fieldTexts[j];
                fields[j].Parent = this;
                fields[j].BorderStyle = BorderStyle.Fixed3D;

                j++;
            }

            for (int i = 0; i < 7; i++)
            {
                fields[j] = new Label();
                fields[j].Size = new Size(100, 100);
                fields[j].Location = new Point(50, 750 - 100 * i);
                fields[j].TextAlign = ContentAlignment.MiddleCenter;
                fields[j].Text = fieldTexts[j];
                fields[j].Parent = this;
                fields[j].BorderStyle = BorderStyle.Fixed3D;

                j++;
            }
        }

        Label[] fields = new Label[32];

        private void gameSearch_Click(object sender, EventArgs e)
        {
            //using (GameSearchDialog dialog = new GameSearchDialog(Game))
            //{
            //    if (dialog.ShowDialog() == DialogResult.Yes)
            //    {

            //    }
            //}
        }
    }
}
