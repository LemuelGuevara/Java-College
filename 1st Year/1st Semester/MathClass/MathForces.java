/*
* This program will ask the user to enter magnitude and direction (in degrees) of 2 forces. Then it will compute and display
* the magnitude of the resultant and its direction (in degrees)
* */

package MathClass;
import java.util.*;
import static java.lang.Math.*;

public class MathForces
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

        double resultantForce, magnitude1, magnitude2, resultantDirection, xSum, ySum, direction1, direction2 ;

        // Program description prompt
        System.out.println("This program will ask a user to input the magnitude and direction (in degrees between 0 and 360) of 2 forces. Then\n" +
                "the program will compute and display the magnitude of the resultant and its direction (in degrees).\n");

        // Get inputs
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

        // Computation of components of the first and second forces by using the component method
        // Sum of the x-components of the first force and then converts given degrees into radians
        xSum = magnitude1 * cos(toRadians(direction1)) + magnitude2 * cos(toRadians(direction2));
        // Sum of the y-components of the first force
        ySum = magnitude1 * sin(toRadians(direction1)) + magnitude2 * sin(toRadians(direction2));

        // Resultant force
        resultantForce = hypot(xSum, ySum); // Pythagoras theorem

        // Resultant direction
        resultantDirection = toDegrees(atan(ySum / xSum)); // Converts to degrees the inverse tangent of ySum/xSum

        // Outputs of resultant force and direction
        System.out.println("Resultant force: " + roundOff(resultantForce));
        System.out.println("Direction: " + roundOff(resultantDirection));
    }
}
