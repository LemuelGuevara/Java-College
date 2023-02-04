package LoopMethods;

import java.util.*;
import static java.lang.Math.*;

public class LoopMethodFunction
{
    static Scanner in = new Scanner(System.in);

    static void validateInputs(int a, int b, double i)
    {
        if (!(a < b))
        {
            System.out.println("Value of 'a' is larger than 'b', please enter a lower value.");
            System.exit(0);
        }
        if (!(i < (double) (b - a)/2))
        {
            System.out.println("Increment value 'i' is invalid, please enter a valid value.");
            System.exit(0);
        }
    }

    static void solveValues(int a, int b, double increment, double degrees)
    {
        int x;
        double i, y, z;

        for (i = increment; i < b - 2; i++)
        {
            x = (int) (a + i);

            // Formula for y value
            y = (int) (3 * pow(x, 5) - 2 * pow(x, 3) + x);
            // Formula for z value wherein x is b (lower range) + incremented i
            z = y * (sin(degrees)) + 0.6 * pow(x, 2);

        System.out.println("x = " + x + "\ty = \t" + y + "\tz = " + z);
        }
    }

    public static void main(String[] args)
    {
        int a, b;
        double i, t;

        System.out.println("Enter lower range (a): ");
        a = in.nextInt();
        System.out.println("Enter upper range (b): ");
        b = in.nextInt();
        System.out.println("Enter degrees (t): ");
        t = in.nextDouble();
        t = toRadians(t);
        System.out.println("Enter increment value (i): ");
        i = in.nextDouble();

//        validateInputs(a, b, i);

        solveValues(a, b, i, t);
    }
}
