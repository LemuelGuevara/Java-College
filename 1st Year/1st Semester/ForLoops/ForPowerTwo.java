package ForLoops;

import java.util.Scanner;

public class ForPowerTwo
{
    public static void main(String[] args)
    {
        // Initialization and declaration of variables
        Scanner in = new Scanner(System.in);

        double n;
        int powerTwo;

        System.out.println("Enter N integer: ");
        n = in.nextDouble();

        // For loop
        for (powerTwo = 1; powerTwo <= n; powerTwo++)
        {
            powerTwo *= 2;
        }

        // If greatest power of 2 is greater than n integer, then
        // n integer is divided by 2
        if (powerTwo> n)
        {
            powerTwo = (powerTwo / 2) + 1;
        }

        System.out.println("\nThe greatest power of 2: " + powerTwo);
    }
}
