// Daniel Ty
// 10/15/17
// CSE 142
// TA: Josephine Lee
// Assignment #3 Part A: Doodle
//
// This program will draw a stick figure.

import java.awt.*;

public class Doodle {
   public static void main(String[] args) {
      DrawingPanel p = new DrawingPanel (250, 200);
      p.setBackground(Color.BLACK);
      Graphics g = p.getGraphics();
      
      stickFigure(g);
      hair(g);
            
   }
   
   // Draws cyan stick figure
   public static void stickFigure(Graphics g) {
      g.setColor(Color.CYAN);
      g.fillOval(110, 50, 30, 30);
      g.drawLine(125, 75, 125, 130);
      g.drawLine(125, 130, 135, 170);
      g.drawLine(125, 130, 115, 170);
      g.drawLine(125, 90, 140, 95);
      g.drawLine(142, 95, 148, 80);
      g.drawLine(125, 90, 115, 120);      
   }
   
   // Draws "coral" hair   
   public static void hair(Graphics g) {
      Color coral = new Color(255, 127, 0);
      g.setColor(coral);
      g.fillRect(117, 50, 16, 3);      
   }   

}