/*
 * Name: Guevara, Lemuel John D.
 * Section: 1CSD
 * */

package MachineProblems;

import static java.lang.Math.*;
import java.util.*;

interface Area
{
    // Used to get the area of the given shape
    double getArea();
}

interface Volume
{
    // Used to get the volume of the given shape
    double getVolume();
}

abstract class Shape
{
    // Returns the name of the shape
    abstract String getName(String name);
}

class Circle extends Shape implements Area
{
    protected double radius;

    // Takes in a radius
    Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getArea()
    {
        return 3.1416 * pow(radius, 2);
    }

    @Override
    String getName(String name)
    {
        return "\nSHAPE: " + name;
    }
}

class Square extends Shape implements Area
{
    protected double side;

    // Takes in a side
    Square(double side)
    {
        this.side = side;
    }

    @Override
    public double getArea()
    {
        return pow(side, 2);
    }

    @Override
    String getName(String name)
    {
        return "\nSHAPE: " + name;
    }
}

class Cylinder extends Circle implements Volume
{
    private double height;

    // Takes in a radius and height
    Cylinder(double radius, double height)
    {
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume()
    {
        return 3.1416 * pow(radius, 2) * height;
    }
}

class Sphere extends Circle implements Volume
{
    // Takes in a radius
    Sphere(double radius)
    {
        super(radius);
    }

    @Override
    public double getVolume()
    {
        return (4.0 / 3.0) * 3.1416 * pow(radius, 3);
    }
}

class Cube extends Square implements Volume
{
    // Takes in a side
    Cube(double side)
    {
        super(side);
    }

    @Override
    public double getVolume()
    {
        return pow(side, 3);
    }
}

class Glome extends Sphere implements Volume
{

    // Takes in a radius
    Glome(double radius)
    {
        super(radius);
    }

    @Override
    public double getVolume()
    {
        return 0.5 * pow(3.1416, 2) * pow(radius, 4);
    }
}

public class MP1Java2
{
    static Scanner in = new Scanner(System.in);

    // Shows the shape choices
    public static void showChoices()
    {
        System.out.println("\n2-Dimensional Shapes:");
        System.out.println("> Square\n> Circle");
        System.out.println("\n3-Dimensional Shapes:");
        System.out.println("> Cube\n> Sphere\n> Cylinder");
        System.out.println("\n4-Dimensional Shapes:");
        System.out.println("> Glome");

        System.out.println("\nChoices:");
        System.out.println("A - 2-Dimensional Shapes\nB - 3-Dimensional Shapes\nC - 4-Dimensional Shapes");
    }

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

    // Prompts the user to input the radius
    public static double getRadius()
    {
        System.out.print("Enter radius: ");

        return validInput();
    }

    // Prompts the user to input the height
    public static double getHeight()
    {
        System.out.print("Enter height: ");

        return validInput();
    }

    // Prompts the user to input the side
    public static double getSide()
    {
        System.out.print("Enter side: ");

        return validInput();
    }

    // This method is used to evaluate the shape choice of the user then perform the functions of the
    // given shape class
    public static void evaluateChoice(int choice)
    {
        double radius, side, height;

        // Switch statement for getting the shape dimension® and the outputs of it
        switch (choice)
        {
            case 'A':

                radius = getRadius();
                side = getSide();

                Circle circle = new Circle(radius);
                System.out.println(circle.getName(circle.getClass().getSimpleName()));
                System.out.printf("CIRCLE AREA: %.2f%n", circle.getArea());

                Square square = new Square(side);
                System.out.println(square.getName(square.getClass().getSimpleName()));
                System.out.printf("SQUARE AREA: %.2f%n", square.getArea());

                break;
            case 'B':
                radius = getRadius();
                height = getHeight();
                side = getSide();

                Cylinder cylinder = new Cylinder(radius, height);
                System.out.println(cylinder.getName(cylinder.getClass().getSimpleName()));
                System.out.printf("CYLINDER VOLUME: %.2f%n", cylinder.getVolume());

                Sphere sphere = new Sphere(radius);
                System.out.println(sphere.getName(sphere.getClass().getSimpleName()));
                System.out.printf("SPHERE VOLUME: %.2f%n", sphere.getVolume());

                Cube cube = new Cube(side);
                System.out.println(cube.getName(cube.getClass().getSimpleName()));
                System.out.printf("CUBE VOLUME: %.2f%n", cube.getVolume());

                break;
            case 'C':
                radius = getRadius();

                Glome glome = new Glome(radius);
                System.out.println(glome.getName(glome.getClass().getSimpleName()));
                System.out.printf("GLOME VOLUME: %.2f%n", glome.getVolume());

                break;
        }
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
        System.out.println("\nThis program computes the area or " +
                "volume according to the dimension of the shape given by the user.");

        char userChoice, dimensionChoice;

        do
        {
            showChoices(); // Shows the choices
            System.out.print("\nChoose dimension: ");
            dimensionChoice = in.next().charAt(0); // Choice is an int
            dimensionChoice = Character.toUpperCase(dimensionChoice);

            // Evaluates then outputs the results of the chosen shape by the user
            evaluateChoice(dimensionChoice);

            // Asks the user if they still want to continue the program
            System.out.println("\nPress Y to continue and press any other key to stop.");
            userChoice = in.next().charAt(0);
            userChoice = Character.toUpperCase(userChoice);

        } while (isContinuous(userChoice));
    }
}
