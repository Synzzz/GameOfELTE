using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfELTE.Game
{
    public class LuckyCard
    {
        public LuckyCard(string name, string description, bool isCollectible)
        {
            Name = name;
            Description = description;
            IsCollectible = isCollectible;
        }
        
        public string Name { get; private set; }

        public string Description { get; private set; }

        public bool IsCollectible { get; private set; }
    }
}
