using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace GameOfELTE.Game
{
    public enum PlayerColor { White, Black, Red, Green, Blue, Yellow }

    public class Player
    {
        public string Name { get; set; }

        public PlayerColor PlayerColor { get; set; }

        public int Money { get; set; }

        public Player()
        { }

        public Color RGBColor
        {
            get
            {
                switch(PlayerColor)
                {
                    case PlayerColor.White: return Color.White;
                    case PlayerColor.Black: return Color.Black;
                    case PlayerColor.Red: return Color.Red;
                    case PlayerColor.Green: return Color.Green;
                    case PlayerColor.Blue: return Color.Blue;
                    case PlayerColor.Yellow: return Color.Yellow;
                    default: return Color.Empty;
                }
            }
        }
    }
}
