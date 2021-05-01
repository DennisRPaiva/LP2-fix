package figures;

import java.awt.Graphics;

public abstract class Figure {
    int x, y;
    int width, height;

    public Figure (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
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
    public abstract void paint (Graphics g);
}
