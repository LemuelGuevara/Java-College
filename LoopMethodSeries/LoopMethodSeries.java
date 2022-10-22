/*
* This program series of methods with for loops and while loops
* */

package LoopMethodSeries;

import java.util.*;
import static java.lang.Math.*;

public class LoopMethodSeries {
    static Scanner in = new Scanner(System.in);

    // Checks if input value is greater than 0
    static void validateInput(double input)
    {
        if (!(input > 0))
        {
            System.out.println("Please input a value greater than 0");
            System.exit(0);
        }
    }

    // Rounds off value
    static double roundOff(double value) {
        return round(value * 10000.0) / 10000.0;
    }

    // Shows choices if wanted
    static void showChoices()
    {
        System.out.println("\nA - Arithmetic Series" + "\nB - Geometric Series" + "\nC - Harmonic Mean" + "\nD - Geometric Mean" +
                "\nE - Taylor Polynomial of Degree n" + "\nF - Largest Prime" + "\nG - Quit the Program\n");
    }

    // Arithmetic series method
    static void getArithmeticSeries()
    {
        double a, d, term, sum = 0;
        int n;

        System.out.println("\n---Arithmetic Series---\n");

        // Inputs
        System.out.println("Input first term (a): ");
        a = in.nextDouble();
        System.out.println("Input common difference (d): ");
        d = in.nextDouble();
        System.out.println("Input number of terms (n): ");
        n = in.nextInt();

        // Validates input
        validateInput(a);
        validateInput(d);
        validateInput(n);

        // Prints the 1st term
        System.out.print("Series: ");

        // For loop
        for (int i = 1; i <= n; i++)
        {
            term = a + (i - 1) * d;
            sum += term;
            System.out.print(term + " ");
        }
        // Sum of all terms
        System.out.println("\nSum: " + sum + "\n");
    }

    // Geometric series method
    static void getGeometricSeries() {
        double a, r, n, sum = 0, term;

        System.out.println("\n---Geometric Series---\n");

        // Inputs
        System.out.println("Input first term (a): ");
        a = in.nextDouble();
        System.out.println("Input common ratio (r): ");
        r = in.nextDouble();
        System.out.println("Input number of terms (n): ");
        n = in.nextDouble();

        // Validates inputs
        validateInput(a);
        validateInput(r);
        validateInput(n);

        // Prints the 1st term
        System.out.print("Series: ");
        // For loop
        for (int i = 1; i <= n; i++)
        {
            term = a * pow(r, i - 1);
            System.out.print(term + " ");
            sum += term;
        }
        // Sum of all terms
        System.out.println("\nSum: " + sum + "\n");
    }

    // Harmonic mean method
    static void getHarmonicMean() {
        double x, n = 0, harmoSum = 0, harmoMean = 0;

        System.out.println("\n---Harmonic Mean---\n");

        // Inputs
        System.out.println("Enter number: ");
        x = in.nextDouble();

        // Validate input
        validateInput(x);

        // Sentinel controlled loop
        while (x != 0)
        {
            n++; // Counts all terms

            // Formula for harmonic mean
            harmoSum += roundOff(1 / x);
            harmoMean = roundOff(n / harmoSum);

            x = in.nextDouble(); // Another input of the user
        }

        // Output of the geometrical and harmonic mean
        System.out.println("Number of typed numbers: " + n);
        System.out.println("Harmonic mean: " + harmoMean + "\n");
    }

    // Geometric mean method
    static void getGeometricMean() {
        double x, n = 0, geoProduct = 1, geoMean = 0;

        System.out.println("\n---Geometric Mean---\n");

        // Inputs
        System.out.println("Enter number (type 0 to exit program): ");
        x = in.nextDouble();

        // Validate input
        validateInput(x);

        while (x != 0)
        {
            n++; // Counts all terms

            // Formula for the geometric mean
            geoProduct *= x;
            geoMean = roundOff(pow(geoProduct, 1.0 / n));

            x = in.nextDouble(); // Another input of the user
        }

        // Output of the geometrical and harmonic mean
        System.out.println("\nNumber of typed numbers: " + n);
        System.out.println("Geometric mean: " + geoMean + "\n");
    }

    // Taylor polynomial method
    static void getTaylorPoly() {
        double x, n, term, factorial = 1, power, taylorPoly = 0;
        int ctr = 1;

        System.out.println("\n---Taylor Polynomial Degree of n---\n");

        // Inputs
        System.out.println("Enter degree (n): ");
        n = in.nextDouble();
        System.out.println("Enter x value (x): ");
        x = in.nextDouble();

        // Validates inputs
        validateInput(n);
        validateInput(x);

        System.out.println("Term " + ctr + " : " + ctr);

        // For loop
        for (ctr = 1; ctr <= n; ctr++) {
            // Gets power
            power = pow(x, ctr);
            // Factorial
            factorial *= ctr;

            // Terms
            term = power / factorial;

            System.out.println("Term " + (ctr + 1) + " : " + roundOff(term));
            // Sum of all terms
            taylorPoly += term;
        }
        // Sum of taylor polynomial is added by 1
        System.out.println("\nTaylor Polynomial: " + roundOff(taylorPoly + 1) + "\n");
    }

    // Large prime number method
    static void getLargestPrime()
    {
        // Variables
        int n, divisibleCtr = 0;

        System.out.println("\n---Prime number---\n");

        // Inputs
        System.out.println("Enter integer: ");
        n = in.nextInt();

        validateInput(n);

        if (n == 1)
        {
            System.out.println("1 is not a prime number.");
            System.exit(0);
        }

        // For loop
        for (int i = 1; i <= n; i++)
        {
            if (n % i == 0)
            {
                // Counts all the divisible numbers
                divisibleCtr++;
            }
        }

        // Not prime if divisible numbers are greater than 2
        if (divisibleCtr > 2)
            System.out.println(n + " is not a prime number\n");
        else
            System.out.println(n + " is a prime number\n");
    }

    public static void main(String[] args) {
        char choice;

        System.out.println("\nA - Arithmetic Series" + "\nB - Geometric Series" + "\nC - Harmonic Mean" + "\nD - Geometric Mean" +
                "\nE - Taylor Polynomial of Degree n" + "\nF - Largest Prime" + "\nG - Quit the Program\n");

        do
        {
            System.out.println("Input choice from the above (type 's' to show choices): ");
            choice = in.next().charAt(0);
            choice = Character.toUpperCase(choice);

            switch (choice)
            {
                case 'A': getArithmeticSeries();
                    break;
                case 'B': getGeometricSeries();
                    break;
                case 'C': getHarmonicMean();
                    break;
                case 'D': getGeometricMean();
                    break;
                case 'E': getTaylorPoly();
                    break;
                case 'F': getLargestPrime();
                    break;
                case 'S': showChoices();
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
                    System.exit(0);
            }
        } while (choice != 'G');
    }
}