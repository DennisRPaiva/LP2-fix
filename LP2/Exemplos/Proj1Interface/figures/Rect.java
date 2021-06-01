package figures;

import java.awt.*;

public class Rect extends Figure {
    

    public Rect (int x, int y, int w, int h, Color fundo, Color borda, char c) {
        super(x, y, w, h, fundo, borda,c);
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
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
        //g2d.drawRect(this.x,this.y, this.width,this.height);
        g2d.setColor(borda);
        g2d.drawRect(this.x,this.y,this.width,this.height);
		g2d.setColor(fundo);
		g2d.fillRect(x+1,y+1, this.width-1,this.height-1);
    }
}
