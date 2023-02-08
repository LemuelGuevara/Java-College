package OOP;

import static java.lang.Math.*;

class Point
{
    private double xCoordinate, yCoordinate;

    Point(double xCoordinate, double yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Point()
    {

    }

    double getXCoordinate()
    {
        return xCoordinate;
    }

    double getYCoordinate()
    {
        return yCoordinate;
    }

    public void printCoordinates()
    {
        System.out.println("X-Coordinate: " + getXCoordinate());
        System.out.println("Y-Coordinate: " + getYCoordinate());
    }
}

class Circle extends Point
{
    private final double radius;
    private final int xCoordinate = (int) getXCoordinate(), yCoordinate = (int) getYCoordinate();
    private final String circleCenter = getCircleCenter();
    private final String xCoordSign = getOperatorSign(xCoordinate), yCoordSign = getOperatorSign(yCoordinate);

    Circle(double xCoordinate, double yCoordinate, double radius)
    {
        super(xCoordinate, yCoordinate);
        this.radius = radius;
    }

    Circle(double radius)
    {
        super();
        this.radius = radius;
    }

    /* UTILITY METHODS */

    // Function for rounding off values to 3 significant figures
    double roundOff(double value)
    {
        return round(value * 1000.0) / 1000.0;
    }

    private String getOperatorSign(double integer)
    {
        String operatorSign;

        if (integer > 0)
            operatorSign = " + ";
        else
            operatorSign = " - ";

        return operatorSign;
    }

    /* GETTERS */

    public double getRadius()
    {
        return radius;
    }

    /* COMPUTING METHODS */

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

    public String getStandardForm()
    {
        String xCoordExpression, yCoordExpression, standardForm;

        xCoordExpression = "(" + "x" + xCoordSign + abs(xCoordinate) + ")" + "\u00b2";
        yCoordExpression = "(" + "x" + yCoordSign + abs(yCoordinate) + ")" + "\u00b2";

        standardForm = xCoordExpression + " + " + yCoordExpression + " = " + (int) radius;

        return standardForm;
    }

    public String getGeneralForm()
    {
        String generalForm;
        int dXcoord, eYCoord, constantSum;

        constantSum = (int) (pow(xCoordinate, 2) + pow(yCoordinate, 2) - radius);

        dXcoord = xCoordinate * 2;
        eYCoord = yCoordinate * 2;

        generalForm = "x\u00b2" + " + " + "y\u00b2" + getOperatorSign(dXcoord) + abs(dXcoord) + "x" +
                getOperatorSign(eYCoord) + abs(eYCoord) + "y" + getOperatorSign(constantSum) + abs(constantSum) + " = 0";

        return generalForm;
    }

    public String getCircleCenter()
    {
        String circleCenter;

        circleCenter = "(" + (xCoordinate * -1) + "," + (yCoordinate * -1) + ")";

        return circleCenter;
    }

    /* OUTPUT METHODS */

    public void printCircleAttributes()
    {
        System.out.println("Area of Circle: " + calculateArea());
        System.out.println("Circumference of Circle: " + calculateCircumference());
        System.out.println("Radius of Circle: " + radius);
        System.out.println("Center of Circle: " + circleCenter);
        System.out.println("Standard Form: " + getStandardForm());
        System.out.println("General Form: " + getGeneralForm());
    }
}

class Cylinder extends Circle
{
    private final double height, radius = getRadius();
    private final Circle circle;

    // Constructor for Cylinder
    Cylinder(Circle circle, double radius, double height)
    {
        super(radius);
        this.height = height;
        this.circle = circle;
    }

    // Gets the volume of the cylinder
    public double getVolume()
    {
        double volume;

        volume = height * PI * pow(radius, 2);

        return roundOff(volume);
    }

    // Gets the surface area of the cylinder
    public double getSurfaceArea()
    {
        double surfaceArea, baseArea, lateralArea;

        baseArea = 2 * PI * pow(radius, 2);
        lateralArea = calculateCircumference() * height;
        surfaceArea = baseArea + lateralArea;

        return roundOff(surfaceArea);
    }

    // Prints the outputs of the cylinder
    public void printCylinderAttributes()
    {
        System.out.println("Volume of Cylinder: " + getVolume());
        System.out.println("Surface Area of Cylinder: " + getSurfaceArea());
        System.out.println("Center of Cylinder: " + circle.getCircleCenter());
    }
}

public class OOPInheritanceCircle
{
    public static void main(String[] args)
    {
        double radius = 5, xCoordinate = 1, yCoordinate = -1, height = 10;

        Circle circle = new Circle(xCoordinate, yCoordinate, radius);
        Cylinder cylinder = new Cylinder(circle, radius, height);

        System.out.println("\n---Point Attributes---");
        circle.printCoordinates();

        System.out.println("\n---Circle Attributes---");
        circle.printCircleAttributes();

        System.out.println("\n---Cylinder Attributes---");
        cylinder.printCylinderAttributes();
    }
}
