/*
* This program will as the user to input the coefficients of (A, B, C) of equation line 1 (L1) & line 2 (L2). Then will
* compute and output angle formed between L1 and L2.
* */

package MathAnglePhi;
import java.util.*;
import static java.lang.Math.*;

public class MathAnglePhi
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

        double a1, a2, b1, b2, c1, c2, m1, m2, angle;

        // Program description prompt
        System.out.println("This program will as the user to input the coefficients of (A, B, C) of equation line 1 (L1) & line 2 (L2). Then will\n" +
                "compute and output angle formed between L1 and L2.\n");

        // Get inputs
        System.out.println("This program will ask for the coefficients of Line 1 and Line 2 which are A, B, & C");
        // Coefficients for Line 1
        System.out.println("Enter coefficient a1 (x): ");
        a1 = in.nextInt();
        System.out.println("Enter coefficient b1 (y): ");
        b1 = in.nextInt();
        System.out.println("Enter coefficient c1 (n): ");
        c1 = in.nextInt();

        // Coefficients for Line 2
        System.out.println("Enter coefficient a2 (x): ");
        a2 = in.nextInt();
        System.out.println("Enter coefficient b2 (y): ");
        b2 = in.nextInt();
        System.out.println("Enter coefficient c2 (n): ");
        c2 = in.nextInt();

        // Line 1 slope
        m1 = a2 * b1;

        // Line 2 slope
        m2 = a1 * b2;

        // Angle formed between line1 and line2
        angle = atan((m2 - m1) / (a1 * a2 + b1 * b2));

        // Output
        System.out.println("Angle formed between line 1 and line 2: " + toDegrees(angle));
    }
}
