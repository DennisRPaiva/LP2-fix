package figures;

import java.awt.*;
import ivisible.IVisible;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable{
    public int x, y;
    public int width, height;

    public Color fundo, borda;
    public char c;

    public Figure (int x, int y, int w, int h, Color borda, Color fundo, char c) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.fundo = fundo;
        this.borda = borda;
        this.c = c;
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

    public abstract void set (int x, int y, int width, int height);

    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.width && this.y<=y && y<=this.y+this.height);
    }
}