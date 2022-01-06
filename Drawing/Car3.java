// Name: Whitaker Brand
// TA: Isaac
// Course: CSE142
// Quarter: 17au
// This is an example usage of DrawingPanel to draw a Car.
// 
// Draws multiple cars of various shapes and sizes.
//
// <too-much-info-comment>
// This class uses a parameterized method to print out
// cars of different sizes at different locations. It 
// also uses a forloop to print out multiple cars.
// </too-much-info-comment>
import java.awt.*;

public class Car3 { 
   public static void main(String[] args) {      
      DrawingPanel drawPanel = new DrawingPanel(1600, 1000); // width, height
      drawPanel.setBackground(Color.LIGHT_GRAY);
      Graphics pen = drawPanel.getGraphics();

      // here, size is passed as the original size: 10.
      drawCar(pen, 10, 100, 10);
      
      for (int i = 1; i <= 4; i++) {
         // print out smaller cars (size 5), 
         // with y increasing with the forloop counter i
         drawCar(pen, 300, 100 + (i * 200), 5);      
      }
      
      // tiny car: red stripe has height 1px
      drawCar(pen, 0, 0, 1);
      
      // really big car:
      drawCar(pen, 600, 100, 40);
   }
   
   // Uses the given Graphics object to draw a car at the location given
   // by x and y of the given size. x and y represent the top-left point
   // of the car. The size here represents a scaling factor. The original
   // car is size 10: smaller values than 10 will yield smaller cars.
   public static void drawCar(Graphics g, int x, int y, int size) {
      // assure that the color is black, and draw the body and tires
      g.setColor(Color.BLACK);
      g.fillRect(x, y, 20 * size, 10 * size);
      g.fillOval(x + size, y + 7 * size, 6 * size, 6 * size);
      g.fillOval(x + 13 * size, y + 7 * size, 6 * size, 6 * size);
      
      g.setColor(Color.BLUE);
      g.fillRect(x + 13 * size, y + 2 * size, 7 * size, 4 * size);

      g.setColor(Color.RED);
      g.fillRect(x, y + 4 * size, 10 * size, size);
   }
   
   // <too-much-info-comment>
   // A note on the size variable:
   // It's not a class constant. In space needle, we wanted a class
   //     constant because we only drew 1 space needle per execution.
   //     Now, we want to print multiple cars of different sizes, so
   //     the value of size changes in this program, and thus, isn't
   //     constant.
   
   // And another -- how did we get 10 for size?
   // To some extent, this is arbitrary. I can pick any number to 
   //     represent the 'size' of the original figure we drew.
   //     The reason to choose 10 was because it was the smallest 
   //     unit used in the drawing, and also because it divided 
   //     nicely into the other dimensions. EG -- 10px was the 
   //     height of the red stripe. So, internally, we know that 
   //     'size' means 'height of stripe', but that's not really 
   //     important. We just need _a_ number to use as a reference 
   //     point to translate 'car size' to 'pixels', and use that  
   //     number to scale the size of the shapes and the offsets 
   //     between them.
   
   // That is, we just need to pick any number of 'pixels' represent
   //     the 'car size unit'. Then we can make expressions to change
   //     the offsets and width/height of the various shapes. 10 just
   //     happens to be a convenient number.  
   //</too-much-info-comment>
}