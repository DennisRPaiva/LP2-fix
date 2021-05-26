import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPolyPanel extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    int xValues[] = {120, 180, 240 }; 
    int yValues[] = { 110, 30, 110 }; 
    Polygon polygon1 = new Polygon( xValues, yValues, 3 );
    g.drawPolygon( polygon1 );

    /*
    Polygon p = new Polygon();
    for (int i = 0; i < 5; i++)
      p.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 5)),
          (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));

    g.drawPolygon(p);
    */
  }
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("DrawPoly");
    frame.setSize(350, 250);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    Container contentPane = frame.getContentPane();
    contentPane.add(new DrawPolyPanel());

    frame.show();
  }
}