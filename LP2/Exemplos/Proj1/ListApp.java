import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Rect foco = new Rect(0,0,0,0,new Color(0,0,0,0),new Color(0,0,0,0));

    Random rand = new Random();
    Figure focus = null;
    //Point2D start;

    ListFrame () {
        this.addWindowListener ( new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        /*
        this.addMouseListener( new MouseAdapter() {

                public void mouseClicked(MouseEvent mouseLocation){   
                    start = new Point2D.Double(mouseLocation.getX(), mouseLocation.getY());
                }   
            }
        );
        */

        this.addMouseListener(new MouseAdapter(){
			
			public void mousePressed(MouseEvent evt){
				focus = null;
				for(Figure fig: figs){
					if((fig.x <= evt.getX() && fig.x + fig.width >= evt.getX()) && (fig.y <= evt.getY() && fig.y + fig.height >= evt.getY())){
						focus = fig;
						figs.remove(focus);
						figs.add(focus);
					}else{
						foco.corBorda(new Color(0,0,0,0));
						focus = null;
					}
					repaint();
				}
			}
		});

        this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent event){
				for(Figure fig: figs){
					if(focus == fig){
						focus.x = event.getX()-focus.width/2;
						focus.y = event.getY()-focus.height/2;
						foco.x = focus.x-1;
						foco.y = focus.y-1;
						repaint();
					}
				}
			}
		});

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    Point mouse = getMousePosition();
                    int x = mouse.x;
                    int y = mouse.y;
                    int width = 40;
                    int height = 40;
                    if (evt.getKeyChar() == 'r') {
                        //Rect r = new Rect(x,y, w,h);
                        //int posx = (int) start.getX();
                        //int posy = (int) start.getY();
                        Rect r = new Rect(x, y, width, height, Color.black,new Color(0,0,0,0));
                        figs.add(r);
                        repaint();
                    }
                    //vermelho
                    else if (evt.getKeyChar() == '1') {
                        for(Figure fig: figs){
							if(focus == fig){
                                fig.corFundo(new Color(255,0,0));
								repaint();
							}
						}
                    }

                    //azul
                    else if (evt.getKeyChar() == '2') {
                        for(Figure fig: figs){
							if(focus == fig){
                                fig.corFundo(new Color(0,255,0));
								repaint();
							}
						}
                    }

                    //verde
                    else if (evt.getKeyChar() == '3') {
                        for(Figure fig: figs){
							if(focus == fig){
                                fig.corFundo(new Color(0,0,255));
								repaint();
							}
						}
                    }

                    //lilás
                    else if (evt.getKeyChar() == '4') {
                        for(Figure fig: figs){
							if(focus == fig){
                                fig.corFundo(new Color(163, 104, 232));
								repaint();
							}
						}
                    }

                    //amarelo
                    else if (evt.getKeyChar() == '5') {
                        for(Figure fig: figs){
							if(focus == fig){
                                fig.corFundo(new Color(255,255,0));
								repaint();
							}
						}
                    }

                    //borda vermelha
                    else if (evt.getKeyChar() == 'q') {
                        for(Figure fig: figs){
							if(focus == fig){
                                fig.corBorda(new Color(255,0,0));
								repaint();
							}
						}
                    }

                    //borda azul
                    else if (evt.getKeyChar() == 'w') {
                        for(Figure fig: figs){
							if(focus == fig){
                                fig.corBorda(new Color(0,255,0));
								repaint();
							}
						}
                    }

                    //borda verde
                    else if (evt.getKeyChar() == 'a') {
                        for(Figure fig: figs){
							if(focus == fig){
                                fig.corBorda(new Color(0,0,255));
								repaint();
							}
						}
                    }
                    
                    else if (evt.getKeyChar() == 'e') {
                        //Ellipse e = new Ellipse(posx,posy, 35,35);
                        //int posx = (int) start.getX();
                        //int posy = (int) start.getY();
                        Ellipse e = new Ellipse(x, y, width, height, Color.black,new Color(0,0,0,0));
                        figs.add(e);
                    }
                    
                    else if (evt.getKeyChar() == 't') {
                        //Triangulo t = new Triangulo(posx,posy, 50, 50);
                        //int posx = (int) start.getX();
                        //int posy = (int) start.getY();
                        
                        // por algum motivo só tem "hitbox" na primeira linha feita (a de baixo)
                        Triangulo t = new Triangulo(x, y, width, height, Color.black,new Color(0,0,0,0));
                        figs.add(t);
                    }
                    
                    else if (evt.getKeyChar() == 'p') {
                        //int posx = (int) start.getX();
                        //int posy = (int) start.getY();
                        //Pentaguno p = new Pentaguno(posx,posy, 30, 30);

                        // por algum motivo só tem "hitbox" na primeira linha feita (esquerda para baixo)
                        Pentaguno p = new Pentaguno(x, y, width, height, Color.black,new Color(0,0,0,0));
                        figs.add(p);
                    }

                    else if (evt.getKeyChar() == '+') {
                        //aumenta a figura
						for(Figure fig: figs){
							if(focus == fig){
								fig.reSize(1,1);
								foco.reSize(1,1);
								repaint();
							}
						}
                    }

                    else if (evt.getKeyChar() == '-') {
                        //diminui a figura
						for(Figure fig: figs){
							if(focus == fig){
								fig.reSize(-1,-1);
								foco.reSize(-1,-1);
								repaint();
							}
						}
                    }
                   

                    //remove
                    else if(evt.getKeyCode() == '0'){
                        for(Figure fig: figs){
							if(focus == fig){
								figs.remove(fig);
								foco.corFundo(new Color(0,0,0,0));
								repaint();
							}
						}
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
