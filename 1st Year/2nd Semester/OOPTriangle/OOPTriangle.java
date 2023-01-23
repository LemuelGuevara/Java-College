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
    public String getTriangleType()
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

    public double getTriangleArea()
    {
        double triangleArea;

        triangleArea = 0.25 * sqrt((getSideA() + getSideB() + getSideC()) * ((-1) * getSideA() + getSideB() + getSideC())
                * (getSideA() - getSideB() + getSideC()) * (getSideA() + getSideB() - getSideC()));

        return triangleArea;
    }

    public double getTrianglePerimeter()
    {
        double trianglePerimeter;

        trianglePerimeter = getSideA() + getSideB() + getSideC();

        return trianglePerimeter;
    }

    public void displayOutputs()
    {
        System.out.println("\nType of triangle: " + getTriangleType());
        System.out.printf("Area of triangle: %.2f%n", getTriangleArea());
        System.out.printf("Perimeter of triangle: %.2f%n", getTrianglePerimeter());
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

            // Solves the area and perimeter of the given triangle
            tri.displayOutputs();

            // Asks the user if they still want to continue the program
            System.out.print("\nPress Y to continue and press any other key to stop: ");
            userChoice = in.next().charAt(0);
            userChoice = Character.toUpperCase(userChoice);

        } while (isContinuous(userChoice));
    }
}
