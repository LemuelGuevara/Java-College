/*
* This program finds the true bearing of the given integer prompt by the user
* */

package ConditionalBearing;
import java.util.*;

public class ConditionalBearing
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        int tB;
        String trueBearingPrompt;

        trueBearingPrompt = "True Bearing is: ";

        // Input for the true bearing
        System.out.println("Enter true bearing:");
        tB = in.nextInt();

        // Conditions
        if (tB <= 90)
        {
            System.out.println(trueBearingPrompt + "N " + tB + " E");
        }
        if (tB < 360 && tB > 180)
        {
            System.out.println(trueBearingPrompt + "N " + (360-tB) + " W");
        }
        if (tB < 180 && tB > 90)
        {
            System.out.println(trueBearingPrompt + "S " + (180-tB) + " E");
        }
        if (tB < 270 && tB > 180)
        {
            System.out.println(trueBearingPrompt + "S " + (tB-180) + " W");
        }
    }
}
