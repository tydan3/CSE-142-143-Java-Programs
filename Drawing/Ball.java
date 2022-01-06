// Name: Whitaker Brand
// TA: Rachel
// Section: XX
// CSE142
//
// This program draws a ball moving at 20px/sec in the
// x direction, and 10px/sec in the y direction
import java.awt.*;
import java.util.*;

public class Ball {
   public static final int SIZE = 30;
   public static final int HALF = SIZE / 2;

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.print("Please enter the displacement: ");
      double displacement = console.nextDouble();
      
      System.out.print("Please enter the angle: ");
      double angle = console.nextAngle();
      
      System.out.println("You typed" + displacement);
          
      DrawingPanel panel = new DrawingPanel(1000, 1000);
      panel.setBackground(Color.CYAN);
      Graphics pen = panel.getGraphics();
      
      // draw the initial ball:
      pen.fillOval(500 - HALF, 500 - HALF, SIZE, SIZE);
      
      // Goal:
      // Define initial velocity and angle (in degrees), and use it to calculate
      // x and y velocity.
      // double velocity = 12.345;       //            90deg: up
      // double angle = 60;              // 180deg: left         0deg: right 
      //                                 //           270deg: down
      // TODO(whitab): Use Math.cos, Math.sin, and Math.toRadians(angle)
      // to calculate x component and y component of the velocity.
      
      double radians = Math.toRadians(angle);
      
      double xDisplacement = displacement * Math.cos(radians); // px/sec
      double yDisplacement = displacement * Math.sin(radians) * -1;  // px/sec
      
      // <implementation detail :: This is good information, but bad code commenting.>
      // Store x and y as doubles because their position can be a real nubmber.
      // When we draw it, we do have to round to the nearest pixel, which is the reason
      // for the cast to (int).
      // </implementation detail>
      double x = 500.0;
      double y = 500.0;
      
      for (int i = 1; i <= 100; i++) {
         // pause for 1 second (velocity is px/second)
         panel.sleep(1000);


         // change the x location of the ball
         // change the y location of the ball
         x = x + xDisplacement;
         y = y + yDisplacement;
         
         // draw the ball again at new location
         // <implementation detail :: This is good information, but bad code commenting.>
         //   use casting to force java to treat the double 'x - HALF' as an int. This
         //   truncates the double into an int, effectively discarding anything after
         //   the decimal sign: (int) 12.88 evaluates to 12 
         // </implementation detail>
         pen.fillOval((int) x - HALF, (int) y - HALF, SIZE, SIZE);
                  
      }      
   }
}

// <implementation detail :: This is good information, but bad code commenting.>
//   Note that the units of the x/yVelocity variables is DEFINED by the length of
//   time that we are sleeping. That is to say, the sleep time changes how often 
//   we draw the draw, and therefore, how often we are doing the math to move it
//   to a new location.
// 
//   The units of velocity are actually px/??, where the ?? gets filled in when
//   we pick a sleep time. sleep(1000) -> px/second
// </implementation detail>