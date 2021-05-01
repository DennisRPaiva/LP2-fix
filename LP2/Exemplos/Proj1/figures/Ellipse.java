package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {

    public Ellipse (int x, int y, int w, int h, Color fundo, Color borda) {
        super(x, y, w, h, fundo, borda);
    }

    public void print () {

        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.width, this.height, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.draw(new Ellipse2D.Double(this.x,this.y, this.width, height)); --- esta bugando na hora de pintar!!! n sei pq, mudei a logica.
        g2d.setColor(borda);
        g2d.drawOval(this.x,this.y,this.width,this.height);
		g2d.setColor(fundo);
		g2d.fillOval(x+1,y+1, this.width-1,this.height-1);
    }
}
