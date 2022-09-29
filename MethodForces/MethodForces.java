/*
* This program will ask a user to input the magnitude and direction (in degrees between 0 and 360) of 2 forces. Then
* the program will compute and display the magnitude of the resultant and its direction (in degrees).
* */

package MethodForces;
import java.util.*;
import static java.lang.Math.*;

public class MethodForces
{
    // Computes Rx sum
    static double resultantX(double magnitude1, double magnitude2, double direction1, double direction2)
    {
        return magnitude1 * cos(toRadians(direction1)) + magnitude2 * cos(toRadians(direction2));
    }

    // Computes Ry sum
    static double resultantY(double magnitude1, double magnitude2, double direction1, double direction2)
    {
        return magnitude1 * sin(toRadians(direction1)) + magnitude2 * sin(toRadians(direction2));
    }

    // Computes overall resultant of the force
    static double resultant(double xSum, double ySum)
    {
       return hypot(xSum, ySum);
    }

    // Computes the direction of the resultant
    static double direction(double xSum, double ySum)
    {
        return toDegrees(atan(ySum / xSum));
    }

    // Displays magnitude and direction of the resultant
    static void displayResults(double force, double direction)
    {
        System.out.printf("Resultant force: %.2f%n", force);
        System.out.printf("Resultant direction: %.2f%n", direction);
    }

    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        double resultantForce, magnitude1, magnitude2, resultantDirection, xSum, ySum, direction1, direction2 ;

        // Program description prompt
        System.out.println("This program will ask a user to input the magnitude and direction (in degrees between 0 and 360) of 2 forces. Then\n" +
                "the program will compute and display the magnitude of the resultant and its direction (in degrees).\n");

        // Inputs
        // Magnitude and direction for the first force
        System.out.println("Enter magnitude of first force: ");
        magnitude1 = in.nextDouble();
        System.out.println("Enter direction of first force: ");
        direction1 = in.nextDouble();

        // Magnitude and direction of the second force
        System.out.println("Enter magnitude of second force: ");
        magnitude2 = in.nextDouble();
        System.out.println("Enter direction of second force: ");
        direction2 = in.nextDouble();

        // Evaluation of degrees
        if (direction1 <= 90 | direction2 <= 90) // If d1 & d2 <= 90 then d1 or d2 will stay the same
        {
            direction1 += 0;
            direction2 += 0;
        }
        else if (direction1 < 360 & direction1 > 180 | direction2 < 360 & direction2 > 180) // If given degree is < 360 & > 180 then 360 - degree
        {
            direction1 = 360 - direction1;
            direction2 = 360 - direction2;
        }
        else if (direction1 < 180 & direction1 > 90 | direction2 < 180 & direction2 > 90) // If given degree is < 180 & > 90 then 180 - degree
        {
            direction1 = 180 - direction1;
            direction2 = 180 - direction2;
        }
        else if (direction1 < 270 & direction1 > 180 | direction2 < 270 & direction2 > 180) // If given degree is < 270 & > 180 then 270 - degree
        {
            direction1 = 270 - direction1;
            direction2 = 270 - direction2;
        }

        // Passes the parameters need to solve Rx and Ry
        xSum = resultantX(magnitude1, magnitude2, direction1, direction2);
        ySum = resultantY(magnitude1, magnitude2, direction1, direction2);

        // Resultant force
        resultantForce = resultant(xSum, ySum);

        // Resultant direction
        resultantDirection = direction(xSum, ySum);

        // Display force and direction of the resultant
        displayResults(resultantForce, resultantDirection);
    }
}
