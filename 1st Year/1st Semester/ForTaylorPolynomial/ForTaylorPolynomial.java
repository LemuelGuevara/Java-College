package ForTaylorPolynomial;

import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class ForTaylorPolynomial
{
    public static void main(String[] args)
    {
        // Initialization and declaration of variables
        Scanner in = new Scanner(System.in);

        double x, n, term, factorial = 1, power, taylorPoly = 0;
        int ctr = 1;

        System.out.println("Enter degree (n)");
        n = in.nextDouble();
        System.out.println("Enter x value (x)");
        x = in.nextDouble();

        // Factorial formula:
        // factorial *= i;
        System.out.println("Term " + ctr + " : " + ctr);
        // For loop
        for (ctr = 1 ;ctr <= n; ctr++) {
            // Gets power
            power = pow(x, ctr);
            // Factorial
            factorial *= ctr;

            // Terms
            term = power / factorial;

            System.out.println("Term " + (ctr + 1) + " : " + round(term * 100.0) / 100.0);

            // Sum of all terms (taylor polynomial)
            taylorPoly += term;
        }
        // The sum of the taylor polynomial is added by 1
        System.out.println("\nTaylor Polynomial: " + round((taylorPoly + 1) * 100.0) / 100.0);
    }
}
