/*
 * This program asks an angle from the user and outputs a table of x, y, and z values wherein in x is between a and b
 * with an increment of i
*/

package ALGOF_02;
import java.lang.Math;
import java.util.*;

public class ALGOF_02
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Initialization of variables
        int a, b, x, i = 0;
        double y, z, t;

        // Input for the a and b values
        System.out.println("Enter value of a for upper range: ");
        a = input.nextInt();
        System.out.println("Enter value of b for lower range");
        b = input.nextInt();

        // Input for the angle
        System.out.println("Enter degree(t): ");
        t = input.nextDouble();
        t = Math.toRadians(t);

        // While loop wherein i in the range of (higher range - lower range) - 1
        while (i < ((a - b) - 1))
        {
           i++; // Increments by 1
           x = b + i; // sum of b (lower range) and i that is incremented

           // Formula for y value
           y = 3.0 * (Math.ceil(Math.pow(x, 5))) - 2.0 * (Math.ceil(Math.pow(x, 3))) + x;
           // Formula for z value wherein x is b (lower range) + incremented i
           z = (y * (Math.sin(t))) + (0.6 * (Math.pow(x, 2)));

           // Outputs the values of x, y, and z
           System.out.println("x = " + x + "\ty = " + y + "\tz = " + z);
       }
    }
}