package OOP;

import static java.lang.Math.*;

class Point
{
    private final double xCoordinate, yCoordinate;

    Point(double xCoordinate, double yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate()
    {
        return xCoordinate;
    }

    public double getYCoordinate()
    {
        return yCoordinate;
    }

    public void printCoordinates()
    {
        System.out.println("(" + getXCoordinate() + "," + getYCoordinate() + ")");
    }
}

class Circle extends Point
{
    private final double radius;
    private final String circleCenter = "(" + getXCoordinate() + "," + getYCoordinate() + ")";

    Circle(double xCoordinate, double yCoordinate, double radius)
    {
        super(xCoordinate, yCoordinate);
        this.radius = radius;
    }

    public void printRadius()
    {
        System.out.println(radius);
    }

    // Function for rounding off values to 3 significant figures
    private double roundOff(double value)
    {
        return round(value*1000.0) / 1000.0;
    }

    public double calculateArea()
    {
        double circleArea;

        circleArea = PI * pow(radius, 2);

        return roundOff(circleArea);
    }

    public double calculateCircumference()
    {
        double circumference;

        circumference = 2 * PI * radius;

        return roundOff(circumference);
    }

    public void printAreaCircumference()
    {
        System.out.println("Area of Circle: " + calculateArea());
        System.out.println("Circumference of Circle: " + calculateCircumference());
    }
}

class Cylinder
{

}

public class OOPInheritanceCircle
{
    public static void main(String[] args)
    {
        // This constructor will take in an xCoordinate, yCoordinate, and a radius
        // It also inherits from the parent class Point
        Circle circle = new Circle(2, 3, 10);
        circle.calculateArea();
        circle.calculateCircumference();

        circle.printCoordinates();

        circle.printRadius();
        circle.printAreaCircumference();
    }
}
