
import java.util.*;

public class Test2 {
    public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout

    public static void main(String[] args) {
        double[] frequencies = 
            {110.25, 116.25, 123.25, 130.25, 138.25, 146.25, 155.25, 164.25,
             174.25, 184.25, 195.25, 207.25, 220.25, 233.25, 246.25, 261.25,
             277.25, 293.25, 311.25, 329.25, 349.25, 369.25, 391.25, 415.25,
             440.25, 466.25, 493.25, 523.25, 554.25, 587.25, 622.25, 659.25,
             698.25, 739.25, 783.25, 830.25, 880.25};
        
        Guitar g = new Guitar37();
        g.playNote(-22);
        System.out.println("time " + g.time() + " sample = " + g.sample());
     }
}