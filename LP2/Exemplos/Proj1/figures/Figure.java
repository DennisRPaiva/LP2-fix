package figures;

import java.awt.*;

public abstract class Figure {
    public int x, y;
    public int width, height;

    public Color fundo, borda;

    public Figure (int x, int y, int w, int h, Color borda, Color fundo) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.fundo = fundo;
        this.borda = borda;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getW(){
        return this.width;
    }

    public int getH(){
        return this.height;
    }

    public void corFundo(Color fundo){
		this.fundo= fundo;
	}
	
	public void corBorda(Color borda){
		this.borda=borda;
	}

    public void drag (int posx, int posy) {
        this.x += posx;
        this.y += posy;
    }
	
	public void reSize(int tamWidth, int tamHeight){
		this.width += tamWidth;
		this.height += tamHeight;
	}


    public abstract void paint (Graphics g);
}
