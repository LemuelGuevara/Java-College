/*
* This program calculates and displays the values of y (y = xz/(x - z)
* */

package NestedLoops;

import java.util.*;

public class NestedLoopValueY
{

    // Function for displaying undefined function message
    static String undefinedFunction(int x, int z)
    {
        String message;
        if (x == z)
            message = "(Undefined Function)";
        else
            message = "";

        return message;
    }

    public static void main(String[] args)
    {
        // Variables
        Scanner in = new Scanner(System.in);

        double y;
        int x, z;

        // Outer loop
        for (x = 1; x <= 5; x++)
        {
            System.out.println();
            // Inner loop
            for (z = 2; z <= 6; z++)
            {
                y = (double) x * z / (x - z);

                // Outputs
                System.out.print("x: " + x + " ");
                System.out.print("z: " + z + " ");
                System.out.print("y: " + y + " " + undefinedFunction(x, z) +  "\n");

                // Prints new line if z is 6
                if (z == 6)
                    System.out.println();
            }
        }
    }
}
