/*
* This program transpose the rows and columns of a 4x4 matrix
* with random integers then stores the transposed elements to a new
* array. Which then displays both the original matrix and the transposed
* matrix.
* */

package Arrays2D;

import java.util.*;

public class Arrays2D_Transpose
{
    // Initializes array
    static int[][] loadArray()
    {
       Random rand = new Random();
       final int size = 4;

       int[][] array = new int[size][size];

       for (int i = 0; i < size; i++)
       {
           for (int j = 0; j < size; j++)
               array[i][j] = rand.nextInt(20) + 1;
       }

       return array;
    }

    // Transposes rows and columns in array
    static int[][] transposeElements(int[][] array)
    {
        final int size = array.length;
        int[][] transposedArray = new int[size][size];

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                int origin = 0;
                int firstElement = array[origin][origin];
                int lastElement = array[size - 1][size - 1];

                // Swaps the columns with rows and vice versa
                transposedArray[i][j] = array[j][i];

                // Fixes the problem when transposing the last element
                // with the first element
                transposedArray[origin][origin] = lastElement;
                transposedArray[size - 1][size - 1] = firstElement;
            }
        }

        return transposedArray;
    }

    // Prints arrays
    static void printArray(int[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println();
            for (int j = 0; j < array[i].length; j++)
                System.out.print(" \t" + array[i][j] + " \t");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[][] arrayA, arrayB;

        arrayA = loadArray(); // Loads the array with random integers (1-20)

        // Outputs the arrays
        System.out.print("\n---Matrix A (original matrix)---");
        printArray(arrayA);
        System.out.print("\n---Matrix B (transposed matrix)---");
        // Transposes the elements in the original array
        arrayB = transposeElements(arrayA);
        printArray(arrayB);
    }
}
