/*
* This program constructs a jagged array where its rows and columns increases
* */

package ArraysJagged;

public class ArraysJagged_MP
{
    // Loads the jagged array
    static int[][] loadJaggedArray()
    {
        final int rows = 5;
        int[][] jaggedArray = new int[rows][];
        int n = 0;

        for (int i = 0; i < jaggedArray.length; i++)
            jaggedArray[i] = new int[i + 1];

        for (int i = 0; i < jaggedArray.length; i++)
        {
            for (int j = 0; j < jaggedArray[i].length; j++)
                jaggedArray[i][j] = n++ + 1;
        }

        return jaggedArray;
    }

    // Prints the array
    static void printArray(int[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[][] jaggedArray;

        // Initialization
        jaggedArray = loadJaggedArray();

        // Output
        System.out.println();
        printArray(jaggedArray);

    }
}
