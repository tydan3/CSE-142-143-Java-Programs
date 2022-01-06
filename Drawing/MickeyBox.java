import java.awt.*;

public class MickeyBox {
   public static void main(String[] args) {
      DrawingPanel drawPanel = new DrawingPanel (220,150);
      drawPanel.setBackground(Color.YELLOW);
      Graphics g = drawPanel.getGraphics();
   
      drawMouse(g);
      g.drawLine(70, 85, 150, 85);

   
   }
   
   //draws a square with circles in its top corners
   public static void drawMouse(Graphics g) {
      g.setColor(Color.BLUE);
      g.fillOval(50, 25, 40, 40);
      g.fillOval(130, 25, 40, 40);
      
      g.setColor(Color.RED);
      g.fillRect(70, 45, 80, 80);
      
      g.setColor(Color.BLACK);
         }
   
}
