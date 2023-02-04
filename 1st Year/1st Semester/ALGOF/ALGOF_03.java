
/* This program accepts numbers but the loop breaks when number 0 is entered. As it accepts numbers, it calculates both
geometric and harmonic means of the given numbers */

package ALGOF;
import java.util.*;
import java.lang.Math;

public class ALGOF_03
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // Initialization of input

        /* x is the input of the user, sum is the sum of the harmonic values of x, geoMean is the mean
        of the geometrical mean, geoProduct is the product of x values, harmoValue is 1 / value of x.
        and harmoMean is harmonica mean of x values */

        // Initialization of variables
        double x, n = 0, geoProduct = 1, geoMean = 1, harmoSum = 0, harmoMean = 1;

        // Asks for the user input of
        System.out.println("Enter number: ");
        x = input.nextInt();

        // While loop wherein it always true but loop will break once number 0 is typed
        while (x != 0)
        {
//            // Formula for the geometric mean
//            geoProduct = geoProduct * x;
//            geoMean = ((Math.pow(geoProduct, 1.0 / n)) * 100) / 100.0;

            // Formulas for harmonic mean
            harmoSum = ((harmoSum + (1 / x)) * 100) / 100.0 ;
            harmoMean = ((n / harmoSum) * 100) / 100.0;

            n++; // Counter of given numbers wherein every typed number will be counted

            // Asks for another input from the user wherein if number 0 is pressed, loop will break
            System.out.println("Enter another number to proceed or enter 0 to exit: ");
            x = input.nextInt(); // Another input of the user
        }
        // Output of the geometrical and harmonic mean
        System.out.println("Number of typed numbers: " + n);
        System.out.println("Geometric mean is: " + geoMean + "\n" + "Harmonic mean is: " + harmoMean);
    }
}
