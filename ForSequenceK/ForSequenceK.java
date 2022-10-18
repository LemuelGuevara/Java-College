/*
* This program finds the K integer value of a sequence and prints all its terms
* */

package ForSequenceK;

import java.util.*;

public class ForSequenceK
{
    public static void main(String[] args) {
        // Initialization and declaration of variables
        Scanner in = new Scanner(System.in);

        int x, k = 0;
        long aN;

        // Program description prompt
        System.out.println("This program finds the K integer value of a sequence and prints all its terms\n");

        // Inputs
        System.out.println("Enter x:");
        x = in.nextInt();

        aN = x;

        int i;
        for (i = 0; i < x; i++)
        {
            // Checks if aN(x) is divisible by 2
            if (aN % 2 == 0)
            {
                aN /= 2;
                System.out.print(aN + " ");
            }
            // If not divisible by the 2
            else
            {
                aN = (3 * aN) + 1;
                System.out.print(aN + " ");
            }
            // Counts n terms
            k++;

            // If aN is 1 then the loop will break
            if (aN == 1)
            {
                break;
            }
        }
        // Displays K
        System.out.println("\nK is: " + k);
    }
}
