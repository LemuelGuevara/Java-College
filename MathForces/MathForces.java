/*
* This program will ask the user to enter magnitude and direction (in degrees) of 2 forces. Then it will compute and display
* the magnitude of the resultant and its direction (in degrees)
* */

package MathForces;
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
        Scanner in = new Scanner(System.in);

        /*
        * r (resultant vector), m1 (1st magnitude), m2 (2nd magnitude), d1 (1st degree), d2 (2nd degree)
        * xSum (sum of x-components), ySum (sum of y components)
        * */

        double r, m1, m2, d, xSum, ySum, d1, d2 ;

        // Program description prompt
        System.out.println("This program prompts the user to enter an hourly pay rate and asks for number of hours\n" +
                "user works in a week. The program then outputs income before and after taxes, the money\n" +
                "the user spends on clothes and accessories, money spent in school supplies, money to buy\n" +
                "savings bonds, and money the parents of the user spend to buy additional saving bonds.\n");

        // Get inputs
        // Magnitude and direction for the first force
        System.out.println("Enter magnitude of first force: ");
        m1 = in.nextDouble();
        System.out.println("Enter direction of first force: ");
        d1 = in.nextDouble();

        // Magnitude and direction of the second force
        System.out.println("Enter magnitude of second force: ");
        m2 = in.nextDouble();
        System.out.println("Enter direction of second force: ");
        d2 = in.nextDouble();

        // Evaluation of degrees
        if (d1 <= 90 | d2 <= 90) // If d1 & d2 <= 90 then d1 or d2 will stay the same
        {
            d1 = d1 + 0;
            d2 = d2 + 0;
        }
        else if (d1 < 360 & d1 > 180 | d2 < 360 & d2 > 180) // If given degree is < 360 & > 180 then 360 - degree
        {
            d1 = 360 - d1;
            d2 = 360 - d2;
        }
        else if (d1 < 180 & d1 > 90 | d2 < 180 & d2 > 90) // If given degree is < 180 & > 90 then 180 - degree
        {
            d1 = 180 - d1;
            d2 = 180 - d2;
        }
        else if (d1 < 270 & d1 > 180 | d2 < 270 & d2 > 180) // If given degree is < 270 & > 180 then 270 - degree
        {
            d1 = 270 - d1;
            d2 = 270 - d2;
        }

        // Computation of components of the first and second forces by using the component method
        // Sum of the x-components of the first force and then converts given degrees into radians
        xSum = m1 * cos(toRadians(d1)) + m2 * cos(toRadians(d2));
        // Sum of the y-components of the first force
        ySum = m1 * sin(toRadians(d1)) + m2 * sin(toRadians(d2));

        // Resultant force
        r = sqrt(pow(xSum, 2) + pow(ySum, 2));
        // Direction
        d = atan(ySum / xSum); // Inverse tangent of ySum/xSum
        d = toDegrees(d); // Converts the inverse tangent of d (in radians) into degrees

        // Outputs of resultant force and direction
        System.out.println("Resultant force: " + roundOff(r));
        System.out.println("Direction: " + roundOff(d));
    }
}
