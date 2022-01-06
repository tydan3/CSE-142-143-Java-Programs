import java.awt.*;

public class Car1 {
   public static void main(String[] args) {
      DrawingPanel drawPanel = new DrawingPanel(700,1000); // width, height
      Graphics pen = drawPanel.getGraphics();
      
      //pen.drawLine(0, 0, 100, 100);
      drawCar(pen, 300, 300, 5);
      //for (int i = 1; i <= 4; i++) {
      //   drawCar(pen, 250, i * 200);
      //}
   }
   
   public static void drawCar(Graphics g, int x, int y, int size) {
      g.setColor(Color.BLACK);
      g.fillRect(x, y, 200, 100);
      g.fillOval(x + 5, y + 70, 6 * size, 6 * size);
      g.fillOval(x + 135, y + 70, 6 * size, 6 * size);
      
      g.setColor(Color.BLUE);
      g.fillRect(x + 130, y + 20, 7 * size, 4 * size);
      
      g.setColor(Color.RED);
      g.fillRect(x, y + 40, 10 * size, size);
      
   }
}      