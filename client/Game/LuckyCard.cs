using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfELTE.Game
{
    public class LuckyCard
    {
        public LuckyCard(int type, string name, string description)
        {
            Type = type;
            Name = name;
            Description = description;
        }

        public int Type { get; private set; }

        public string Name { get; private set; }

        public string Description { get; private set; }
    }
}
