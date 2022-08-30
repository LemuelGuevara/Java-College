
/* This program accepts numbers but the loop breaks when number 0 is entered. As it accepts numbers, it calculates both
geometric and harmonic means of the given numbers */

package ALGOF_03;
import java.util.*;
import java.lang.Math;

public class ALGOF_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Initialization of input

        /* x is the input of the user, sum is the sum of the harmonic values of x, geoMean is the mean
        of the geometrical mean, geoProduct is the product of x values, harmoValue is 1 / value of x.
        and harmoMean is harmonica mean of x values */

        // Initialization of variables
        double x, n = 0, sum = 0, geoMean = 1, geoProduct = 1, harmoValue,  harmoMean = 1;

        // Asks for the user input of
        System.out.println("Enter number: ");
        x = input.nextInt();

        // While loop wherein it always true but loop will break once number 0 is typed
        while (x != 0)
        {
            n++; // Counter of given numbers wherein every typed number will be counted

            geoProduct = geoProduct * x; // The product of geoProduct multiplied by the values of x
            geoMean = ((Math.pow(geoProduct, 1.0 / n)) * 100) / 100.0; // Geometric mean multiplied and divided by 100 to round off

            harmoValue = ((1 / x) * 100) / 100.0; // Quotient of 1 / x value then multiplied and divided by 100 to round off digits
            sum = ((sum + harmoValue) * 100) / 100.0 ; // Sum of harmonic values multiplied and divided by 100 in order to round off
            harmoMean = ((n / sum) * 100) / 100.0; // Quotient of n / sum multiplied by 100 then divided by 100 for rounding off

            // Asks for another input from the user wherein if number 0 is pressed, loop will break
            System.out.println("Enter another number to proceed or enter 0 to exit: ");
            x = input.nextInt(); // Another input of the user

        }
        // Output of the geometrical and harmonic mean
        System.out.println("Number of typed numbers: " + n);
        System.out.println("Geometric mean is: " + geoMean + "\n" + "Harmonic mean is: " + harmoMean);
    }
}
