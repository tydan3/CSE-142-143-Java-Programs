// Daniel Ty
// 10/16/17
// CSE 142
// TA: Josephine Lee
// Assignment #3 Part B: Circles
//
// This program will draw a specific figure of grids of concentric circles.

import java.awt.*;

public class Circles {
   public static void main(String[] args) {
      DrawingPanel pen = new DrawingPanel(500, 350);
      pen.setBackground(Color.CYAN);
      Graphics g = pen.getGraphics();
      
      //circles(g, x position, y position, size of subfigure, circles per subfigure);      
      circles(g, 0, 0, 100, 10);
      circles(g, 130, 25, 100, 10);
      circles(g, 260, 0, 60, 6);
      circles(g, 360, 50, 80, 4);
      
      //grids(g, x position, y position, size of subfigure, circles per subfigure, rows/columns (e.g. 3 = 3 x 3));
      grids(g, 10, 170, 48, 4, 3);
      grids(g, 180, 200, 24, 2, 5);
      grids(g, 330, 170, 72, 9, 2);
   
   }
   
   //Draws a circle containing consecutively smaller circles
   public static void circles(Graphics g, int x, int y, int size, int subcircles) {
      g.setColor(Color.YELLOW);
      g.fillOval(x, y, size, size);
      g.setColor(Color.BLACK);
      for (int i = 1; i <= subcircles; i++) {
         int radius = size / 2;
         int gapLocation = (radius / subcircles) * i;
         int gapSize = (size / subcircles) * i;
         g.drawOval(x + radius - gapLocation, y + radius - gapLocation, gapSize, gapSize);
      }      
   }
   
   //Draws a grid of circles containing consecutively smaller circles 
   public static void grids(Graphics g, int x, int y, int size, int subcircles, int grid) {
      g.setColor(Color.GREEN);
      int sideLength = size * grid;
      g.fillRect(x, y, sideLength, sideLength);
      g.setColor(Color.BLACK);
      g.drawRect(x, y, sideLength, sideLength);
      for (int column = 1; column <= grid; column++) {
         for (int row = 1; row <= grid; row++) {
            circles(g, x - size + (size * column), y - size + (size * row), size, subcircles);
         }
      g.drawLine(x, y, x + sideLength, y + sideLength);
      g.drawLine(x + sideLength, y, x, y + sideLength);
      }
   }
   
}