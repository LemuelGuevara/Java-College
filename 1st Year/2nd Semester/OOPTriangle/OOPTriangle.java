package OOPTriangle;

import java.util.*;
import static java.lang.Math.*;

class Triangle {
    private double sideA, sideB, sideC;

    /* GETTERS AND SETTERS */

    public double getSideA()
    {
        return sideA;
    }

    public void setSideA(double sideAInput)
    {
        this.sideA = sideAInput;
    }

    public double getSideB()
    {
        return sideB;
    }

    public void setSideB(double sideBInput)
    {
        this.sideB = sideBInput;
    }

    public double getSideC()
    {
        return sideC;
    }

    public void setSideC(double sideCInput)
    {
        this.sideC = sideCInput;
    }

    /* METHODS */

    // Gets and returns the triangle type
    public String checkTriangleType()
    {
        String triangleType = "";

        if (getSideA() == getSideB() && getSideB() == getSideC() && getSideA() == getSideC())
            triangleType = "Equilateral";
        else if (getSideA() == getSideB() || getSideB() == getSideC() || getSideA() == getSideC())
            triangleType = "Isosceles";
        else if (getSideA() != getSideB() && getSideB() != getSideC() && getSideA() != getSideC())
            triangleType = "Scalene";

        return triangleType.toUpperCase();
    }

    // Computes the area and perimeter of given triangle
    public void computeTriangleAreaPerimeter(String triangleType)
    {
        double triangleArea = 0, trianglePerimeter = 0, semiPerimeterScalene;

        // Gets the semi-perimeter for a scalene triangle
        semiPerimeterScalene = (getSideA() + getSideB() + getSideC()) / 2;

        if (triangleType.equals("EQUILATERAL"))
        {
            triangleArea = (pow(getSideA(), 2) * sqrt(3)) / 4;
            trianglePerimeter = sqrt((triangleArea * 4) / sqrt(3));
        }
        else if (triangleType.equals("ISOSCELES"))
        {
            triangleArea = 0.25 * sqrt((getSideA() + getSideB() + getSideC()) * ((-1) * getSideA() + getSideB() + getSideC())
                    * (getSideA() - getSideB() + getSideC()) * (getSideA() + getSideB() - getSideC()));
            trianglePerimeter = 2 * getSideA() + getSideB();
        }
        else if (triangleType.equals("SCALENE"))
        {
            triangleArea = sqrt(semiPerimeterScalene * (semiPerimeterScalene - getSideA()) * (semiPerimeterScalene - getSideB()) *
                    (semiPerimeterScalene - getSideC()));
            trianglePerimeter = getSideA() + getSideB() + getSideC();
        }

        System.out.printf("Area of triangle: %.2f%n" ,triangleArea);
        System.out.printf("Perimeter of triangle: %.2f%n" ,trianglePerimeter);
    }
}

public class OOPTriangle
{
    static Scanner in = new Scanner(System.in);

    // Takes in nonzero input
    public static double validInput()
    {
        double validNumber;
        validNumber = in.nextDouble();

        if (validNumber == 0)
        {
            System.out.println("Please input a nonzero value.");
            System.exit(0);
        }

        return validNumber;
    }

    // Checks if the program is continuous
    public static boolean isContinuous(char userChoice)
    {
        boolean isContinuity = false;

        if (userChoice == 'Y')
            isContinuity = true;

        return isContinuity;
    }

    public static void main(String[] args)
    {
        Triangle tri = new Triangle();

        char userChoice;
        String triangleType;

        do
        {
            // Gets the sides from the user
            System.out.println("Enter the following sides of the triangle: ");

            System.out.print("Side A: ");
            tri.setSideA(validInput());

            System.out.print("Side B: ");
            tri.setSideB(validInput());

            System.out.print("Side C: ");
            tri.setSideC(validInput());

            // Validates that the sum of two side lengths must be greater than the third side
            if (!((tri.getSideA() + tri.getSideB()) > tri.getSideC() && (tri.getSideA() + tri.getSideC()) > tri.getSideB()
                    && (tri.getSideB() + tri.getSideC() > tri.getSideA())))
            {
                System.out.println("\nThe sum of two side lengths must be greater than third side.");
                System.exit(0);
            }

            // Checks the triangle type
            triangleType = tri.checkTriangleType();
            System.out.println("Type of triangle: " + triangleType);

            // Solves the area and perimeter of the given triangle
            tri.computeTriangleAreaPerimeter(triangleType);

            // Asks the user if they still want to continue the program
            System.out.print("\nPress Y to continue and press any other key to stop: ");
            userChoice = in.next().charAt(0);
            userChoice = Character.toUpperCase(userChoice);

        } while (isContinuous(userChoice));
    }
}
