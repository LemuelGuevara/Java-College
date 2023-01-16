/*
* This program prompts the user to enter values of x, y, and z wherein z is degrees. The program
* then computes and displays the values of s and c.
* */

package MathProb1;
import java.util.*;
import static java.lang.Math.*;

public class MathProb1
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

        int s, x, y;
        double c, d, z;

        // Program description prompt
        System.out.println("This program prompts the user to enter values of x, y, and z wherein z is degrees. The program\n" +
                "then computes and displays the values of s and c.\n");

        // Inputs
        System.out.println("Enter value of x: ");
        x = in.nextInt();
        System.out.println("Enter value of y: ");
        y = in.nextInt();
        System.out.println("Enter value of z (degrees): " );
        z = in.nextDouble();
        z = toRadians(z);

        // Computation of s and c
        s = (int) ((exp(x) + 3 * y) / (2 * x - y) + sin(z)); // Cast to an integer
        c = x * pow(1 + (y / 3.0), x); //

        // Output of s and c
        System.out.println("Value of s: " + roundOff(s) + "\n" + "Value of c: " + roundOff(c));
    }
}
