/* This program accepts numbers but the loop breaks when number 0 is entered. As it accepts numbers, it calculates both
geometric and harmonic means of the given numbers */

package Sentinel;

import java.util.Scanner;
import static java.lang.Math.*;

public class SentinelGeometricHarmonic
{
    public static void main(String[] args)
    {
        // Initialization and declaration of variables
        Scanner in = new Scanner(System.in);

        /* x is the input of the user, sum is the sum of the harmonic values of x, geoMean is the mean
        of the geometrical mean, geoProduct is the product of x values, harmoValue is 1 / value of x.
        and harmoMean is harmonica mean of x values */

        double x, n = 0, geoProduct = 1, geoMean, harmoSum = 0, harmoMean;

        // Inputs
        System.out.println("Enter number: ");
        x = in.nextDouble();

        // Sentinel controlled loop
        do
        {
            // Formula for the geometric mean
            geoProduct = geoProduct * x;
            geoMean = ((pow(geoProduct, 1.0 / n)) * 100) / 100.0;

            // Formulas for harmonic mean
            harmoSum = ((harmoSum + (1 / x)) * 100) / 100.0 ;
            harmoMean = ((n / harmoSum) * 100) / 100.0;

            n++; // Counter of given numbers wherein every typed number will be counted

            // Asks for another input from the user wherein if number 0 is pressed, loop will break
            System.out.println("Enter another number to proceed or enter -0 to exit: ");
            x = in.nextDouble(); // Another input of the user

        } while (x != 0);

        // Output of the geometrical and harmonic mean
        System.out.println("Number of typed numbers: " + n);
        System.out.printf("Geometric mean: %.2f%n", geoMean);
        System.out.printf("Harmonic mean: %.2f%n", harmoMean);
    }
}
