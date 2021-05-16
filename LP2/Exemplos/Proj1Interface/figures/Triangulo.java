package figures;

import java.awt.*;

public class Triangulo extends Figure {
    

    public Triangulo (int x, int y, int w, int h, Color fundo, Color borda) {
        super(x, y, w, h, fundo, borda);
    }
    
    public void print () {
        System.out.format("Triangulo: w/h (%d,%d) e x/y (%d,%d).\n",
            this.width, this.height, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(borda);
        g2d.drawPolygon(new int[]{this.x,(this.x+25),(this.x + 50)},new int[]{this.y,(this.y-50),this.y}, 3);
        g2d.setColor(fundo);
        g2d.fillPolygon(new int[]{this.x,(this.x+25),(this.x + 50)},new int[]{this.y,(this.y-50),this.y}, 3);
    }
}
