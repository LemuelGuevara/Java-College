/**
 * This program will prompt the user to input a numerical value then will get the value of
 * a 3x3 determinant using Cramer's Rule
 */

package MathClass;
import java.util.*;
import static java.lang.Math.*;

public class MathCramersRule
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

        // Variables a1 to c1 are the elements in the 3x3 matrix
        double a, a1, a2, a3, b, b1, b2, b3, c, c1, c2, c3, determinantValue;

        // Description of program
        System.out.println("This program will prompt the user to input a numerical value then will get the value of\n" +
                "a 3x3 determinant using Cramer's Rule\n");

        // Get inputs
        // Elements (b)
        System.out.println("Enter Elements (a)\n");
        System.out.println("Enter a1: ");
        a1 = in.nextDouble();
        System.out.println("Enter a2: ");
        a2 = in.nextDouble();
        System.out.println("Enter a3: ");
        a3 = in.nextDouble();

        // Elements (b)
        System.out.println("Enter Elements (b)\n");
        System.out.println("Enter b1: ");
        b1 = in.nextDouble();
        System.out.println("Enter b2: ");
        b2 = in.nextDouble();
        System.out.println("Enter b3: ");
        b3 = in.nextDouble();

        // Elements (c)
        System.out.println("Enter Elements (c)\n");
        System.out.println("Enter c1: ");
        c1 = in.nextDouble();
        System.out.println("Enter c2: ");
        c2 = in.nextDouble();
        System.out.println("Enter c3: ");
        c3 = in.nextDouble();

        // Computation of 2x2 matrices (a to c)
        a = a1 * ((b2 * c3) - (c2 * b3)); // First determinant (a)
        b = b1 * ((a2 * c3 ) - (a3 * c2)); // Second Determinant (b)
//        c = c1 * ((a2 * b3) - (a3 * b2));  // Third Determinant (c)

        // 3x3 determinant value
        // Subtract 2x2 matrix (a) to (b) then add (c)
        determinantValue = a - b;

        // Outputs
        System.out.println("3x3 determinant value: " + roundOff(determinantValue));
    }
}
