/*
* This squares the first 25 elements of the array and multiplies the last
* 25 elements to 3
* */

package Arrays1D;

import java.util.Arrays;

import static java.lang.Math.*;

public class Array1DSquare
{
    public static void main(String[] args)
    {
        // Variables
        double[] alpha = new double[50];
        int size = alpha.length;

        // Loads the array
        for (int i = 0; i < size; i++)
        {
            if (i < 25)
                alpha[i] = pow(i, 2);
            else
                alpha[i] = i * 3;
        }

        // Displays elements
        for (int i = 0; i < size; i++)
        {
            if (i % 10 == 9)
                System.out.println(alpha[i]);
            else
                System.out.print(alpha[i] + " \t");
        }
    }
}
