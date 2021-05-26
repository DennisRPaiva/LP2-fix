import java.awt.*;

import ivisible.IVisible;
import figures.Figure;

public class Button implements IVisible{
	public int selecionado; 
    public int x,y,width,height;
	private Color corFundo = new Color(96,96,96);
	private Figure fig;
	private int aux;
	
	public Button(int selecionado, Figure fig){
		this.selecionado = selecionado;
		this.fig = fig;
		this.x=20;
		this.y=45;
		this.width=40;
		this.height=40;
	}
	
	public boolean clicked(int x, int y){
        return (this.x<=x && 
        x<=this.x+this.width && 
        this.aux<=y && 
        y<=this.aux+this.height);
	}
	
	public void set(Color corFundo){
		this.corFundo = corFundo;
	}

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		aux = y;
		if(selecionado==0){
			g2d.drawRect(x,aux,width,height);
			g2d.setColor(corFundo);
			g2d.fillRect(x+1,aux+1,width-1,width-1);

			this.fig.set(x+5,aux+5,width-10,height-10);
            
		}else if(selecionado==1){
			aux+=40;
			g2d.drawRect(x,aux,width,height);
			g2d.setColor(corFundo);
			g2d.fillRect(x+1,aux+1,width-1,width-1);

			this.fig.set(x+5,aux+5,width-10,height-10);

		}else if(selecionado==2){
			aux+=80;
			g2d.drawRect(x,aux,width,height);
			g2d.setColor(corFundo);
			g2d.fillRect(x+1,aux+1,width-1,width-1);

			this.fig.set(x+7,aux+7,width-10,height-10);

		}else if(selecionado==3){
			aux+=120;
			g2d.drawRect(x,aux,width,height);
			g2d.setColor(corFundo);
			g2d.fillRect(x+1,aux+1,width-1,width-1);

			this.fig.set(x+7,aux+7,width-10,height-10);
		}

		this.fig.paint(g);
	}
}