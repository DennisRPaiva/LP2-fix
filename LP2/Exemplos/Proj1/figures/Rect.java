package figures;

import java.awt.*;

public class Rect extends Figure {
    

    public Rect (int x, int y, int w, int h, Color fundo, Color borda) {
        super(x, y, w, h, fundo, borda);
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.width, this.height, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawRect(this.x,this.y, this.width,this.height);
        g2d.setColor(borda);
        g2d.drawRect(this.x,this.y,this.width,this.height);
		g2d.setColor(fundo);
		g2d.fillRect(x+1,y+1, this.width-1,this.height-1);
    }
}
