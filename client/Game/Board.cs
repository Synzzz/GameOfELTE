using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfELTE.Game
{
    public class Board
    {
        public Board(List<Field> fields)
        {
            Fields = fields.ToArray();

            //TODO Width, Height-et kiszámolni
        }

        private Field[] Fields;

        public int Width { get; private set; }

        public int Height { get; private set; }

        public Field this[int index]
        {
            get { return Fields[index]; }
            set { Fields[index] = value; }
        }
    }
}
