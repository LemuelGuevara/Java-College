/*
* Name: Guevara, Lemuel John D.
* Section: 1CSD
*
* This java program will solve the values of x, y, and z given a, b, and t,
* where t is an angle in degrees. Use the given formulas. Make sure to display
* the computed values.
* */

package MP2;
import java.util.*;
import static java.lang.Math.*;

public class MP2
{
    // Function for rounding off values to 3 significant figures
    public static double roundOff(double value)
    {
        return round(value*1000.0) / 1000.0;
    }

    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        /*
        * (a), (b), (t (degrees)) is given by the user,
        * (x), (y), (z) are values that need to be solved,
        * pi = is the constant pi's value
        * */

        double a, b, t, x, y, z, pi = 3.1416;

        // Program description prompt
        System.out.println("This java program will solve the values of x, y, and z given a, b, and t,\n" +
                "where t is an angle in degrees. Use the given formulas. Make sure to display\n" +
                "the computed values.\n");

        // Inputs
        System.out.println("Enter value (a): ");
        a = in.nextDouble();
        System.out.println("Enter value (b): ");
        b = in.nextDouble();
        System.out.println("Enter value (t) degrees: ");
        t = in.nextDouble();
        t = toRadians(t); // Converts the given degree into radians

        // Computation for x value
        x = (10 * pi) / (a + b) * (1.0 / pow(cos(t), 3)) + 3 * log10(abs(pow(a, 2) - pow(b, 2)));
        // Converted to degrees before doing inverse tangent
        // Computation for y value
        y = ((-1.0) + toDegrees(atan((a + 2.0) / b))) / (1 + exp(a * b)) + (5 * b + pow(a, 2)) / pow(a + (4 * pow(b, 2)), 1.0 / 4.0);
        // Computation for z value
        z = 3.0 / 4.0 * sqrt(abs(x + log10(pow(y, 2)) + x * (1.0 / pow(sin(t), 3))));

        // Outputs
        System.out.println("Value of (x): " + roundOff(x));
        System.out.println("Value of (y): " + roundOff(y));
        System.out.println("value of (z): " + roundOff(z));
    }
}
