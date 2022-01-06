import java.awt.*;

public class PointMystery {
    public static void main(String[] args) {
        Point p1 = new Point(5, 2);
        Point p2 = new Point(-3, 6);
        
        silly(p1);
        silly(p2);
        Point p3 = p1;
        silly(p3);

        System.out.println("(" + p1.x + ", " + p1.y + ")");  // Statement 1
        System.out.println("(" + p2.x + ", " + p2.y + ")");  // Statement 2
        System.out.println("(" + p3.x + ", " + p3.y + ")");  // Statement 3
    }
    
    public static void silly(Point p) {
        int temp = p.x;
        p.x = p.y;
        p.y = temp;
    }
}