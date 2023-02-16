package OOP.PolymorphismQuadrilateral;

import static java.lang.Math.*;

class Point
{
    private double xCoordinate, yCoordinate;

    Point(){}

    Point(double xCoordinate, double yCoordinate)
    {
        this.xCoordinate = getCoordinate(xCoordinate);
        this.yCoordinate = getCoordinate(yCoordinate);
    }

    // Gets the coordinate of either x or y coordinate
    // Only accessible within in this class
    private double getCoordinate(double coordinate)
    {
        return coordinate;
    }

    // Gets the xCoordinate for outer classes
    public double getXCoordinate(Point point)
    {
        return point.xCoordinate;
    }

    // Gets the yCoordinate for outer classes
    public double getYCoordinate(Point point)
    {
        return point.yCoordinate;
    }

    public String toString()
    {
        return "(" + xCoordinate + "," + yCoordinate + ")";
    }
}

class Quadrilateral extends Point
{
    protected Point point1, point2, point3, point4;

    Quadrilateral(Point point1, Point point2, Point point3, Point point4)
    {
        this.point1 = getPoint(point1);
        this.point2 = getPoint(point2);
        this.point3 = getPoint(point3);
        this.point4 = getPoint(point4);
    }

    private Point getPoint(Point point)
    {
        return point;
    }

    public double getArea()
    {
        double x1 = getXCoordinate(point1), x2 = getXCoordinate(point2), x3 = getXCoordinate(point3),
                x4 = getXCoordinate(point4);
        double y1 = getYCoordinate(point1), y2 = getYCoordinate(point2), y3 = getYCoordinate(point3),
                y4 = getYCoordinate(point4);
        double area;

        area = abs(0.5 * (((x1 * y2) + (x2 * y3) + (x3 * y4) + (x4 * y1))
                - ((x2 * y1) + (x3 * y2) + (x4 * y3) + (x1 * y4))));

        return area;
    }

    public String getCoordinatesAsAstring()
    {
        return point1 + ", " + point2
                + ", " + point3 + ", " + point4;
    }

    @Override
    public String toString() {
        return "Coordinates of the quadrilateral: " + getCoordinatesAsAstring() + "\n" + "Area: " + getArea();
    }
}

class Trapezoid extends Quadrilateral
{
    private final double height;

    Trapezoid(Point point1, Point point2, Point point3, Point point4)
    {
        super(point1, point2, point3, point4);
        this.height = getHeight();
    }

    public double getSumOfTwoSides()
    {
        double sumOfTwoSides, base1, base2;

        base1 = getXCoordinate(point4) - getXCoordinate(point1);
        base2 = getXCoordinate(point3) - getXCoordinate(point2);

        sumOfTwoSides = base1 + base2;

        return sumOfTwoSides;
    }

    public double getHeight()
    {
        return getYCoordinate(point3) - getYCoordinate(point1);
    }

    @Override
    public double getArea()
    {
        return 0.5 * getSumOfTwoSides() * height;
    }

    @Override
    public String toString()
    {
        return "Coordinates of the trapezoid: " + getCoordinatesAsAstring() + "\nHeight: " + height + "\n" + "Area: " + getArea();
    }
}

class Parallelogram extends Trapezoid
{

    Parallelogram(Point point1, Point point2, Point point3, Point point4)
    {
        super(point1, point2, point3, point4);
    }

    public double getWidth()
    {
        return getHeight();
    }

    @Override
    public double getArea()
    {
        return (getXCoordinate(point4) - getXCoordinate(point1)) * getHeight();
    }

    @Override
    public String toString()
    {
        return "Coordinates of the parallelogram: " + getCoordinatesAsAstring()  + "\nWidth: " + getWidth() + "\nHeight: "
                                                    + getHeight() + "\nArea: " + getArea();
    }
}

class Rectangle extends Parallelogram
{

    Rectangle(Point point1, Point point2, Point point3, Point point4)
    {
        super(point1, point2, point3, point4);
    }

    @Override
    public String toString()
    {
        return "Coordinates of Rectangle: " + getCoordinatesAsAstring() + "\nLength: " + (getXCoordinate(point4)
                                            - getXCoordinate(point1)) + "\nWidth: " + getWidth();
    }
}

class Square extends Rectangle
{

    Square(Point point1, Point point2, Point point3, Point point4)
    {
        super(point1, point2, point3, point4);
    }

    @Override
    public String toString()
    {
        return "Coordinates of Square: " + getCoordinatesAsAstring() + "\nSide: " + getWidth() + "\nArea: " + pow(getWidth(), 2);
    }
}

public class PolymorphismQuadrilateral
{
    public static void main(String[] args)
    {
        Quadrilateral quad;

        System.out.println();

        quad = new Quadrilateral(new Point(7, 4), new Point(6, 9),
                                    new Point(3, 7), new Point(4, 2));
        System.out.println(quad);
        quad = new Trapezoid(new Point(1, 1), new Point(3, 7),
                                    new Point(10, 7), new Point(13, 1));
        System.out.println(quad);
        quad = new Parallelogram(new Point(2, 4), new Point(5, 10),
                                    new Point(1, 10), new Point(8, 4));
        System.out.println(quad);
        quad = new Rectangle(new Point(-3, 4), new Point(-3, 10),
                                    new Point(5, 10), new Point(5, 4));
        System.out.println(quad);
        quad = new Square(new Point(6, 2), new Point(6, 6),
                                    new Point(10, 6), new Point(10, 2));
        System.out.println(quad);
    }
}
