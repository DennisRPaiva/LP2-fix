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
    ArrayList<Button> butao = new ArrayList<Button>();

    Rect foco = new Rect(0,0,0,0,new Color(0,0,0,0),new Color(0,0,0,0));
    Random rand = new Random();

    Figure focus = new Rect(0,0,0,0,new Color(0,0,0,0),new Color(0,0,0));
    Button focus_butao = new Button(-1,new Rect(0,0,0,0,new Color(0,0,0),new Color(0,0,0)));

    //Point2D start;
    ListFrame () {
        this.addWindowListener ( new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        butao.add(new Button(0,new Rect(0,0,0,0,new Color(0,0,0),new Color(0,0,0))));
		butao.add(new Button(1,new Ellipse(0,0,0,0,new Color(0,0,0),new Color(0,0,0))));
		//butao.add(new Button(2,new Triangulo(0,0,0,0,Color.black,new Color(0,0,0))));
        butao.add(new Button(2,new Rect(0,0,0,0,Color.black,new Color(0,0,0))));
		//butao.add(new Button(3,new Pentaguno(0,0,0,0,new Color(0,0,0,0),new Color(0,0,0))));
        butao.add(new Button(3,new Ellipse(0,0,0,0,Color.black,new Color(0,0,0))));
        
        
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

        this.addMouseListener(new MouseAdapter(){
            public void mousePressed (MouseEvent evt) {
				Figure aux = new Ellipse(0,0,0,0,new Color(0,0,0,0),new Color(0,0,0,0));
				foco.corBorda(new Color(0,0,0,0));
                
				focus = aux;
                int x = evt.getX();
                int y = evt.getY();

                if (focus_butao.selecionado != -1){
                    int width = 50;
					int height = 50;
                    if(focus_butao.selecionado == 0){
                        figs.add(new Rect(x,y, width,height,Color.black,new Color(0,0,0,0)));
                    }else if(focus_butao.selecionado == 1){
                        figs.add(new Ellipse(x,y, width,height,Color.black,new Color(0,0,0,0)));
                    }else if(focus_butao.selecionado == 2){
                        figs.add(new Triangulo(x,y, width,height,Color.black,new Color(0,0,0,0)));
                    }else if(focus_butao.selecionado == 3){
                        figs.add(new Pentaguno(x,y, width,height,Color.black,new Color(0,0,0,0)));
                    }
                }
                for (Figure fig: figs) {
                    if (fig.clicked(x,y)) {
                        focus = fig;
                        foco.set(focus.x-1,focus.y-1,focus.width+2,focus.height+2);
                        foco.corBorda(Color.red);						
					}
				}
				figs.remove(focus);
				figs.add(focus);
				repaint();
            }

            public void mouseClicked(MouseEvent evt){
                int x = evt.getX();
                int y = evt.getY();
                Button aux_button = new Button(-1,new Ellipse(0,0,0,0,Color.black,Color.black));
                focus_butao = aux_button;
                for(Button but: butao){
                    if(but.clicked(x, y)){
                        focus_butao = but;
                        but.set(Color.gray);
                    }else {
                        but.set(Color.lightGray);
                    }
                }
                repaint();
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

        this.setTitle("Lista de Figuras");
        //this.setSize(500, 500);
        //this.setLocationRelativeTo(null);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(false);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Button but: this.butao) {
            but.paint(g);
        }
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
        this.foco.paint(g);
    }
}
