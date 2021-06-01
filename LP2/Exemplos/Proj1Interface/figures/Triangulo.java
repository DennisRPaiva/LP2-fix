package figures;

import java.awt.*;

public class Triangulo extends Figure {
    

    public Triangulo (int x, int y, int w, int h, Color fundo, Color borda, char c) {
        super(x, y, w, h, fundo, borda,c);
    }
    
    public void print () {
        System.out.format("Triangulo: w/h (%d,%d) e x/y (%d,%d).\n",
            this.width, this.height, this.x, this.y);
    }

    public void set(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(borda);
        g2d.drawPolygon(new int[]{this.x,(this.x+width/2),(this.x + width)},new int[]{(this.y+height),this.y,(this.y+height)}, 3);
        g2d.setColor(fundo);
        g2d.fillPolygon(new int[]{this.x,(this.x+width/2),(this.x + width)},new int[]{(this.y+height),this.y,(this.y+height)}, 3);
    }
}
