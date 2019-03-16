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
        public Field(string name, string description)
        {
            Name = name;
            Description = description;
        }

        public string Name { get; private set; }

        public string Description { get; private set; }

        public Image Texture { get; private set; }

        public PointF Location { get; set; }

        public void Draw(Graphics g)
        {

        }
    }
}
