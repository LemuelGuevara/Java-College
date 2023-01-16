/*
* This program accepts the lengths of 2 sides of a right triangle, a and b, respectively. Then the program will compute
* displays the hypotenuse and area of the triangle.
* */

package MethodRTriangle;
import java.util.*;
import static java.lang.Math.*;

public class MethodRTriangle
{

    // Validates inputs are greater than 0
    static void validateInput(double input1, double input2)
    {
        if (!(input1 > 0 && input2 > 0))
        {
            System.out.println("Please input a value greater than 0.");
            System.exit(0);
        }
    }

    // Computes and returns the hypotenuse
    static double hypotenuse(double sideA, double sideB)
    {
        return hypot(sideA, sideB);
    }

    // Computes and returns the area of the triangle
    static double area(double sideA, double sideB)
    {
        return (sideA + sideB) * 2.0;
    }

    // Displays the hypotenuse and area
    static void display(double hypo, double area)
    {
        System.out.printf("Hypotenuse: %.2f%n", hypo);
        System.out.printf("Area: %.2f%n", area);
    }

    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        double sideA, sideB, hypotenuseTriangle, areaTriangle;

        // Program description prompt
        System.out.println("This programs prompts to enter the 2 sides of a right triangle (a and b). The program then solves\n" +
                "the hypotenuse c and area of the triangle.\n");

        // Inputs
        System.out.println("Enter side (a): ");
        sideA = in.nextDouble();
        System.out.println("Enter side (b): ");
        sideB = in.nextDouble();

        // Validates input
        validateInput(sideA, sideB);

        // Passing parameters defined methods
        // Hypotenuse
        hypotenuseTriangle = hypotenuse(sideA, sideB);
        // Area
        areaTriangle = area(sideA, sideB);

        // Displays the hypotenuse and area of the triangle
        display(hypotenuseTriangle, areaTriangle);
    }
}
