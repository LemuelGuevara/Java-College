package OOP.InterfaceShape;

import java.util.*;
import static java.lang.Math.*;

interface Shape
{
    double getPerimeter();
    double getArea();
    void getDetails();
}

class Circle implements Shape
{
    private double radius;
    final float PI = 3.14F;

    Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getPerimeter()
    {
        return 2 * PI * radius;
    }

    @Override
    public double getArea()
    {
        return PI * pow(radius, 2);
    }

    @Override
    public void getDetails()
    {
        System.out.println("Circle radius: " + radius);
        System.out.println("Circle perimeter: " + getPerimeter());
        System.out.println("Circle area: " + getArea());
     }
}

class Triangle implements Shape
{
    private double sideA, sideB, sideC;

    Triangle(double sideA, double sideB, double sideC)
    {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public void validateTriangle()
    {
        if (!((sideA + sideB) > sideC && (sideA + sideC) > sideB && (sideB + sideC) > sideA))
        {
            System.out.println("\nThe sum of two side lengths must be greater than third side.");
            System.exit(0);
        }
    }

    @Override
    public double getPerimeter()
    {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea()
    {
        return 0.25 * sqrt((sideA + sideB + sideC) * (-1 * sideA + sideB + sideC) * (sideA - sideB + sideC) * (sideA + sideB - sideC));
    }

    @Override
    public void getDetails()
    {
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);

        System.out.println("Triangle area: " + getArea());
    }
}

class Rectangle implements Shape
{
    private double length, width;

    Rectangle(double length, double width)
    {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getPerimeter()
    {
        return 2 * (length + width);
    }

    @Override
    public double getArea()
    {
        return length * width;
    }

    @Override
    public void getDetails()
    {
        System.out.println("Rectangle length:" + length);
        System.out.println("Rectangle width: " + width);
        System.out.println("Rectangle perimeter: " + getPerimeter());
        System.out.println("Rectangle area: " + getArea());
    }
}

class Square implements Shape
{

    private double side;

    Square(double side)
    {
        this.side = side;
    }

    @Override
    public double getPerimeter()
    {
        return 4 * side;
    }

    @Override
    public double getArea()
    {
        return pow(side, 2);
    }

    @Override
    public void getDetails()
    {
        System.out.println("Square side: " + side);
        System.out.println("Square perimeter: " + getPerimeter());
        System.out.println("Square area: " + getArea());
    }
}

public class InterfaceShape {
    static Scanner in = new Scanner(System.in);

    public static double[] getArrayInputs(String[] array) {
        double[] arrayInput = new double[array.length];

        for (int i = 0; i < arrayInput.length; i++)
            arrayInput[i] = Double.parseDouble(array[i]);

        return arrayInput;
    }

    public static void main(String[] args) {
        String input;
        String[] userInputs;

        double[] integers;

        System.out.println();
        System.out.println("1 input – circle, 2 inputs – square or rectangle, 3 inputs \n" + "– triangle");

        input = in.nextLine();

        userInputs = input.split("\\s");
        integers = getArrayInputs(userInputs);

        if (integers.length > 3)
            System.exit(0);

        if (userInputs.length == 1)
        {
            Circle circle = new Circle(integers[0]);
            circle.getDetails();
        }

        if (userInputs.length == 2)
        {

            if (integers[0] == integers[1])
            {
                Square square = new Square(integers[0]);
                square.getDetails();
            }
            else
            {
                Rectangle rectangle = new Rectangle(integers[0], integers[1]);
                rectangle.getDetails();
            }
        }

        if (userInputs.length == 3)
        {
            double sideA, sideB, sideC;
            sideA = integers[0];
            sideB = integers[1];
            sideC = integers[2];

            Triangle triangle = new Triangle(sideA, sideB, sideC);
            triangle.validateTriangle();
            triangle.getDetails();
        }
    }
}