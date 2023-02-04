package ForLoops;

import java.util.*;

import static java.lang.Math.*;

public class ForProjectile
{
    public static void main(String[] args)
    {
        // Initialization and declaration of variables
        Scanner in = new Scanner(System.in);

        double initialVelocity, theta, time, x = 1, y = 1, ctr = 0;

        // Program description prompt
        System.out.println("This program displays the x and y projectile with an interval" +
                "of 0 to 5 seconds\n");

        // Inputs
        System.out.println("Enter initial velocity (v): ");
        initialVelocity = in.nextDouble();
        System.out.println("Enter time (t): ");
        time = in.nextDouble();
        System.out.println("Enter theta (angle): ");
        theta = in.nextDouble();
        theta = toRadians(theta);

        System.out.println("X-projectile" + "\t\t" + "Y-projectile");

        // Computation of x and y
        x = initialVelocity * time * cos(theta);
        y = initialVelocity * time * sin(theta);

        // For loop
        for (int i = 0; i <= 5; i++)
        {
            System.out.printf("%8.2f", x);
            System.out.printf("%20.2f%n", y);

            x += 0.5;
            y += 0.5;
        }
    }
}
