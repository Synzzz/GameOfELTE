using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;

namespace GameOfELTE.GUI
{
    public class Renderer
    {
        private Control RenderTarget;
        private Graphics Graphics;
        private BufferedGraphics BufferedGraphics;
        private BufferedGraphicsContext BufferedGraphicsContext;

        public RenderFrame Frame { get; set; }

        public Renderer(Control renderTarget)
        {
            RenderTarget = renderTarget;

            Graphics = renderTarget.CreateGraphics();
            BufferedGraphicsContext = BufferedGraphicsManager.Current;

            InitializeGraphics();
        }

        private void InitializeGraphics()
        {
            BufferedGraphicsContext.MaximumBuffer = RenderTarget.ClientSize;
            BufferedGraphics = BufferedGraphicsContext.Allocate(Graphics, new Rectangle(Point.Empty, BufferedGraphicsContext.MaximumBuffer));
        }

        public void Render()
        {
            Frame.Render(BufferedGraphics.Graphics);
            BufferedGraphics.Render(Graphics);
        }
    }
}
