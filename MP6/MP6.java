/*
* Name: Guevara, Lemuel John D.
* Section: 1CSD
*
*
* */

package MP6;

import java.util.*;
import static java.lang.Math.*;

class LineCoeff
{
    private final double coefficientA, coefficientB, coefficientC;

    // Constructor that takes in 3 coefficients
    public LineCoeff(double coefficientA, double coefficientB, double coefficientC)
    {
        this.coefficientA = coefficientA;
        this.coefficientB = coefficientB;
        this.coefficientC = coefficientC;
    }

    /* GETTERS */
    public double getCoeffA()
    {
        if (coefficientA < 0)
            return coefficientA * 1;

        return coefficientA;
    }

    public double getCoeffB()
    {
        if (coefficientB < 0)
            return coefficientB * 1;

        return coefficientB;
    }

    public double getCoeffC()
    {
        if (coefficientC < 0)
            return coefficientC * 1;

        return coefficientC;
    }
}

class LineType
{
    private final LineCoeff line1, line2;
    private double xIntersection, yIntersection;
    private boolean isHorizontalLine, isVerticalLine;

    // Constructor that takes in the instances of LineCoeff
    public LineType(LineCoeff line1, LineCoeff line2)
    {
        this.line1 = line1;
        this.line2 = line2;

        if (line1.getCoeffA() != 0 || line2.getCoeffA() != 0)
            isHorizontalLine = true;
        if (line1.getCoeffB() != 0 || line2.getCoeffB() != 0)
            isVerticalLine = true;
    }

    /* GETTERS */

    public String getOperatorSign(double integer)
    {
        String operatorSign;

        if (integer < 0)
            operatorSign = " + ";
        else
            operatorSign = " - ";

        return operatorSign;
    }

    // Returns a value string of line 1
    public String getLine1()
    {
        return line1.getCoeffA() + "x" + getOperatorSign(line1.getCoeffB()) + abs(line1.getCoeffB()) + "y " + "= " + line1.getCoeffC();
    }

    // Returns a value string of line 2
    public String getLine2()
    {
        return line2.getCoeffA() + "x" + getOperatorSign(line2.getCoeffB()) + abs(line2.getCoeffB()) + "y " + "= " + line2.getCoeffC();
    }

    // Gets the slope of line 1
    public double getSlopeLine1()
    {
        double slope1;
        slope1 = computeSlope(line1.getCoeffA(), line1.getCoeffB());

        return slope1;
    }

    // Gets the slope of line 2
    public double getSlopeLine2()
    {
        double slope2;
        slope2 = computeSlope(line2.getCoeffA(), line2.getCoeffB());

        return slope2;
    }

    // Returns x intersect
    public double getXIntersection()
    {
        return xIntersection;
    }

    // Returns y intersect
    public double getYIntersection()
    {
        return yIntersection;
    }

    // Displays equation
    public void display()
    {
        System.out.println(getLine1() + "\n" + getLine2());
    }

    /* COMPUTES */
    public double computeSlope(double coefficientA, double coefficientB)
    {
        double slope;
        slope = (coefficientA * -1) / coefficientB;

        return slope;
    }

    // Solves the intersection of the system of equations
    public void intersection()
    {
        double determinant, determinantX, determinantY;

        determinant = (line1.getCoeffA() * line2.getCoeffB()) - (line1.getCoeffB() * line2.getCoeffA());
        determinantX = (line1.getCoeffC() * line2.getCoeffB()) - (line1.getCoeffB() * line2.getCoeffC());
        determinantY = (line1.getCoeffA() * line2.getCoeffC()) - (line1.getCoeffC() * line2.getCoeffA());

        xIntersection = determinantX / determinant;
        yIntersection = determinantY / determinant;
    }

    /* BOOLEANS */

    // Value is true if they have the same slope or both are vertical lines
    public boolean isParallel()
    {
        boolean isParallelLines = false;

        if (getSlopeLine1() == getSlopeLine2() && isVerticalLine)
        {
            isParallelLines = true;
            System.out.println("The lines are parallel!");
        }

        return isParallelLines;
    }

    // Value is true if either one of the lines is horizontal and the other is vertical or the product of their slopes is –1
    public boolean isPerpendicular()
    {
        boolean isPerpendicularLines = false;
        double slopeProduct;

        slopeProduct = getSlopeLine1() * getSlopeLine2();

        if ((isHorizontalLine && isVerticalLine) && slopeProduct == -1)
        {
            isPerpendicularLines = true;
            System.out.println("The lines are perpendicular!");
        }

        return isPerpendicularLines;
    }

    // Value is true if string value of line 1 and line 2 is exactly the same
    public boolean isEqual()
    {
        boolean isEqualLines = false;

        if (Objects.equals(getLine1(), getLine2()))
        {
            isEqualLines = true;
            System.out.println("The lines are equal!");
        }

        return isEqualLines;
    }
}

public class MP6
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

    public static void main(String[] args)
    {
        double coefficientLine1A, coefficientLine1B, coefficientLine1C;
        double coefficientLine2A, coefficientLine2B, coefficientLine2C;

        // Program description
        System.out.println("The equation of a line in standard form is ax + by = c");

        // Gets the coefficients
        System.out.println("\nEnter the coefficients (a, b, c) of equation 1: ");
        coefficientLine1A = validInput();
        coefficientLine1B = validInput();
        coefficientLine1C = validInput();

        System.out.println("Enter the coefficients (a, b, c) of equation 2: ");
        coefficientLine2A = validInput();
        coefficientLine2B = validInput();
        coefficientLine2C = validInput();

        System.out.println("\n---THE SYSTEM OF EQUATIONS---");

        /* LINE EQUATION 1 */
        LineCoeff line1 = new LineCoeff(coefficientLine1A, coefficientLine1B, coefficientLine1C);

        /* LINE EQUATION 2 */
        LineCoeff line2 = new LineCoeff(coefficientLine2A, coefficientLine2B, coefficientLine2C);

        // Systems of Equation
        LineType systemsEquation = new LineType(line1, line2);
        // Displays system of equations
        systemsEquation.display();

        System.out.println("\n---SLOPE VALUES---");

        // Displays slopes of line 1 and line 2
        System.out.printf("The slope of line 1 is %.2f%n", systemsEquation.getSlopeLine1());
        System.out.printf("The slope of line 2 is %.2f%n", systemsEquation.getSlopeLine2());

        System.out.println("\n---EVALUATION OF EQUATIONS---");

        // Displays booleans
        if (!systemsEquation.isEqual())
            System.out.println("The lines are not equal!");
        if (!systemsEquation.isParallel())
            System.out.println("The lines are not parallel!");
        if (!systemsEquation.isPerpendicular())
            System.out.println("The lines are not perpendicular!");

        System.out.println("\n---THE SOLUTION OF THE SYSTEM OF EQUATIONS---");

        // Displays the solution of the system of equations
        systemsEquation.intersection();
        System.out.println("x = " + systemsEquation.getXIntersection() + "\n" + "y = " + systemsEquation.getYIntersection());
    }
}
