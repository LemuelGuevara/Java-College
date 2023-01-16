/*
* This program prints the pascal's triangle using a jagged array
* */

package ArraysJagged_PascalsTriangle;

import java.util.*;

public class ArraysJagged_PascalsTriangle
{
    static Scanner in = new Scanner(System.in);

    // Loads the jagged array
    static int[][] loadJaggedArray(int rows)
    {
        int[][] jaggedArray = new int[rows][];

        for (int i = 0; i < rows; i++)
            jaggedArray[i] = new int[i + 2];

        jaggedArray[0][0] = 1;

        for (int i = 1; i < rows; i++)
        {
            jaggedArray[i][0] = 1;
            for (int j = 1; j <= i; j++)
                jaggedArray[i][j] = jaggedArray[i - 1][j - 1] + jaggedArray[i - 1][j];
        }

        return jaggedArray;
    }

    // Prints the array
    static void printArray(int[][] array)
    {
       for (int i = 0; i < array.length; i++)
       {
           for (int j = 0; j < array.length - i; j++)
               System.out.print(" ");
           for (int k = 0; k <= i; k++)
               System.out.print(array[i][k] + " ");
           System.out.println();
       }
    }

    public static void main(String[] args)
    {
        int[][] jaggedArray;
        int rows;

        System.out.print("\nInput number of rows:");
        rows = in.nextInt();

        // Initialization
        jaggedArray = loadJaggedArray(rows);

        // Output
        System.out.println();
        printArray(jaggedArray);
    }
}
