/*
* This program will ask the user to enter the side(s) of a regular polygon, the
* number of sides(n) and its apothem(r). The program will then compute and display the
* perimeter(P) and area(A) of the polygon.
* */

package Methods;
import java.util.*;
import static java.lang.Math.*;

public class MethodPolygon
{
    // Method for solving the perimeter
    static double perimeter(double s, double n) {
        return s * n;
    }

    // Method for solving the area
    static double area(double r, double p) {
        return r * p / 2.0;
    }

    // Method for displaying the perimeter and rea
    static void display(double P, double A) {
        System.out.printf("Perimeter: %.2f%n", P);
        System.out.printf("Area: %.2f%n", A);
    }

    public static void main(String[] args)
    {
        // Declarations and initialization of variables
        Scanner in = new Scanner(System.in);

        double side, nSide, apothem, area, perimeter;

        // Program description prompt
        System.out.println("This program will ask the user to enter the side(s) of a regular polygon, the\n" +
                "number of sides(n) and its apothem(r). The program will then compute and display the\n" +
                "perimeter(P) and area(A) of the polygon.\n");

        // Inputs
        System.out.println("Enter value of side: ");
        side = in.nextDouble();
        System.out.println("Enter number of sides: ");
        nSide = in.nextDouble();
        System.out.println("Enter apothem: ");
        apothem = in.nextDouble();

        // Passing in the inputs for parameter and area
        perimeter = perimeter(side, nSide);
        area = area(apothem, perimeter);

        // Displays area and perimeter
        display(perimeter, area);
    }
}
