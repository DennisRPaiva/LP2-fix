package figures;

import java.awt.*;
import ivisible.IVisible;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable{
    protected int x, y; // era publico, foi mudado para protected pois ele deve dar visibilidade a suas classes filhas, mas não à implementação toda.
    protected int width, height;

    protected Color fundo, borda;
    protected char c;

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

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getW(){
        return this.width;
    }

    public int getH(){
        return this.height;
    }

    public void setW(int w){
        this.width = width;
    }

    public void setH(int h){
        this.height = height;
    }

    public Color getBorda(){
        return this.borda;
    }

    public Color getFundo(){
        return this.fundo;
    }

    public void setBorda(){
        this.borda = borda;
    }

    public void setFundo(){
        this.fundo = fundo;
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