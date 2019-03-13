using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfELTE.Game
{
    public class Board
    {
        public Board(int width, int height)
        {
            //téglalap kerülete 2(a + b) - a sarkok száma, mert azokat duplán számoltuk = összes mező száma
            Fields = new Field[(width + height) * 2 - 4];

            Width = width;
            Height = height;
        }

        Field[] Fields;

        public int Width { get; private set; }

        public int Height { get; private set; }

        public Field this[int index]
        {
            get { return Fields[index]; }
            set { Fields[index] = value; }
        }
    }
}
