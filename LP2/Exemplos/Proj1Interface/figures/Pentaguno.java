package figures;

import java.awt.*;

public class Pentaguno extends Figure {
    

    public Pentaguno (int x, int y, int w, int h, Color fundo, Color borda, char c) {
        super(x, y, w, h, fundo, borda,c);
    }
    public void print () {
        System.out.format("Pentaguno: w/h (%d,%d) e x/y (%d,%d).\n",
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
        g2d.drawPolygon(new int[]{this.x,(this.x+width/4),(this.x+width*3/4),(this.x + width),(this.x + width/2)} 
        ,new int[]{this.y,(this.y+width/2),(this.y+width/2),this.y,(this.y-width/2)}, 5);
        g2d.setColor(fundo);
        g2d.fillPolygon(new int[]{this.x,(this.x+width/4),(this.x + width*3/4),(this.x + width),(this.x + width/2)} 
        ,new int[]{this.y,(this.y+width/2),(this.y+width/2),this.y,(this.y-width/2)}, 5);
    }
}
