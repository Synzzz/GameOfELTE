using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace GameOfELTE.Game
{
    public class Field
    {
        public Field(int type, string name, string description)
        {
            Type = type;
            Name = name;
            Description = description;
        }

        public int Type { get; private set; }

        public string Name { get; private set; }

        public string Description { get; private set; }

        public Image Texture { get; private set; }

        public PointF Location { get; set; }

        public void Draw(Graphics g)
        {

        }
    }
}
