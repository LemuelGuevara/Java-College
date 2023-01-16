/*
* This program asks for the user to enter sides b and c, and angle A (in degrees) of a given
* triangle. Then will compute sideA, angles B & C, area of the triangle, and length of medians.
* */

package MathObliqueTriangle;
import java.util.*;
import static java.lang.Math.*;

public class MathObliqueTriangle
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

        double sideA, sideB, sideC, sideSum, area, angleA, angleB, angleC, medianM, medianN, medianP;

        // Description about the program
        System.out.println("This program asks for the user to enter sides b and c, and angle A (in degrees) of a given triangle.\n" +
                "Then will compute side a, angles B & C, area of the triangle, and length of medians.\n");

        // Inputs
        System.out.println("Enter side b of triangle: ");
        sideB = in.nextInt();
        System.out.println("Enter side c of triangle: ");
        sideC = in.nextInt();
        System.out.println("Enter angle A of triangle: ");
        angleA = in.nextDouble();
        angleA = toRadians(angleA); // Converts given double to radians

        // Computation of sideA
        // Solved using law of cosines
        sideA = sqrt((pow(sideB, 2) + pow(sideC, 2)) - (2 * sideB * sideC) * cos(angleA));

        // Computation of angleB & angleC using inverse cosine (acos). Converted to degrees as initial values are in radian
        // Formula used is law of cosines
        angleB = toDegrees(acos((pow(sideC, 2) + pow(sideA, 2) - pow(sideB, 2)) / (2 * sideC * sideA)));
        angleC = toDegrees(acos((pow(sideA, 2) + pow(sideB, 2) - pow(sideC, 2)) / (2 * sideA * sideB)));

        // Area of triangle
        sideSum = (sideA + sideB + sideC) / 2.0; // Compute for sum of all sides first then divide by 2
        area = sqrt(sideSum * ((sideSum - sideA) * (sideSum - sideB) * (sideSum - sideC)));

        // Length of medians
        medianM = (1 / 2.0) * sqrt(2 * (pow(sideA, 2)) + 2 * (pow(sideC, 2)) - pow(sideB, 2));
        medianN = (1 / 2.0) * sqrt(2 * (pow(sideB, 2)) + 2 * (pow(sideC, 2)) - pow(sideA, 2));
        medianP = (1 / 2.0) * sqrt(2 * (pow(sideA, 2)) + 2 * (pow(sideB, 2)) - pow(sideC, 2));

        /*Outputs*/

        // Side a
        System.out.println("Side a: " + roundOff(sideA));

        // Angles
        System.out.println("Angle C: " + roundOff(angleC));
        System.out.println("Angle B: " + roundOff(angleB));

        // Area of triangle
        System.out.println("Area of triangle: " + roundOff(area) + "\n");

        // Length of medians
        System.out.println("Length of medians: \n");
        System.out.println("Median M: " + roundOff(medianM));
        System.out.println("Median N : " + roundOff(medianN));
        System.out.println("Median P : " + roundOff(medianP));
    }
}
