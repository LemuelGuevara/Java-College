package WhilePowerTwo;

import java.util.*;
import static java.lang.Math.*;


public class WhilePowerTwo
{
    public static void main(String[] args)
    {
        // Initialization and declaration of variables
        Scanner in = new Scanner(System.in);

        double n;
        int powerTwo = 1;

        System.out.println("Enter N integer: ");
        n = in.nextDouble();

        // While loop
        while (powerTwo <= n)
        {
            powerTwo *= 2;
        }

        // If greatest power of 2 is greater than n integer, then
        // n integer is divided by 2
        if (powerTwo > n)
            powerTwo /= 2;

        System.out.println(powerTwo);
    }
}
