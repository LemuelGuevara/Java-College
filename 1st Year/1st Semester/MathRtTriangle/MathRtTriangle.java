/**
 * This programs prompts to enter the 2 sides of a right triangle (a and b). The program then solves
 * the hypotenuse c, six trigonometric functions of a and b, and angles of a and b in degrees.
 */

package MathRtTriangle;
import java.util.*;
import static  java.lang.Math.*;

public class MathRtTriangle
{
    // Function for rounding off values to 4 significant figures
    public static double roundOff(double value)
    {
        return round(value*10000.0) / 10000.0;
    }

    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        double a, b, c, sinA, cosA, tanA, cscA, secA, cotA;

        // Program description prompt
        System.out.println("This programs prompts to enter the 2 sides of a right triangle (a and b). The program then solves\n" +
                "the hypotenuse c, six trigonometric functions of a and b, and angles of a and b in degrees.\n");

        // Inputs
        System.out.println("Enter side a: ");
        a = in.nextDouble();
        System.out.println("Enter side b: ");
        b = in.nextDouble();

        // Hypotenuse c
        c = hypot(a, b); // Using built in math class method

        // Trigonometric functions
        a = toRadians(a);
        sinA = sin(a);
        cosA = cos(a);
        tanA = tan(a);
        cscA = 1 / sinA;
        secA = 1 / cosA;
        cotA = 1 / tanA;

        // Sides a and b conversion to degrees (separate from trigo functions)
        a = toDegrees(a); // Converted to degrees because side a is in radians

        // Divided by 360 to get angle value
        a /= 360;
        b /= 360;

        // Outputs
        // Hypotenuse C
        System.out.println("Hypotenuse C: " + roundOff(c));

        // Sides a and b in degrees
        System.out.println("Angle A: " + roundOff(a) + "\n" + "Angle B: " + roundOff(b));

        // Trigonometric functions
        System.out.println("\nTrigonometric functions: ");
        System.out.println("SinA: " + roundOff(sinA) + "\n" + "cosA: " + roundOff(cosA));
        System.out.println("TanA: " + roundOff(tanA) + "\n" + "CscA: " + roundOff(cscA));
        System.out.println("SecA: " + roundOff(secA) + "\n" + "CotA: " + roundOff(cotA));
    }
}
