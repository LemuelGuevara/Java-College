/*
* This program gets the row and column wise sum of an array
* */

package Arrays2D_Total;

import java.util.*;

public class Arrays2D_Total
{
    static Scanner in = new Scanner(System.in);

    // Loads the array with random integers
    static int[][] loadArray(int row, int column)
    {
        int[][] array = new int[row][column];

        Random rand = new Random();

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = rand.nextInt(10, 20);
        }

        return array;
    }

    // Gets the sums of the rows
    static int[] getRowSum(int[][] array, int mRow)
    {
        int[] rowSumArray = new int[mRow];

        int rowSum = 0;

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                rowSum += array[i][j];
                rowSumArray[i] = rowSum;
            }
            rowSum = 0;
        }

        return rowSumArray;
    }

    // Gets the sum of the columns
    static int[] getColumnSum(int[][] array, int nColumn)
    {
        int[] columnSumArray = new int[nColumn];

        for (int i = 0; i < nColumn; i++)
        {
            int columnSum = 0;

            for (int j = 0; j < array.length; j++)
                columnSum += array[j][i];
            columnSumArray[i] = columnSum;
        }

        return columnSumArray;
    }

    // Gets the column sum of the row wise sums
    static int getColumnSum(int[] array)
    {
        int rowColumnSumArray = 0;

        for (int rowSum : array)
            rowColumnSumArray += rowSum;

        return rowColumnSumArray;
    }

    // Prints all the arrays
    static void printArray(int[][] array, int[] rowSum, int[] columnSum)
    {
        // Row sum and the raw array
        System.out.println("               \t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Total");
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("\t");
            // Prints the raw array
            for (int j = 0; j < array[i].length; j++)
                System.out.print("\t\t" + array[i][j] + " \t");

            // Row sums
            System.out.println("\t\t" + rowSum[i]);
        }

        System.out.println();

        // Column sum
        System.out.print("Total");
        for (int i = 0; i < columnSum.length; i++)
            System.out.print("\t" + columnSum[i] + "\t\t");

        // Row column wise sum
        System.out.print("\t" + getColumnSum(rowSum));
        System.out.println();
    }

    public static void main(String[] args)
    {
        // Variables
        int mRow, nColumn;
        int[][] rawArray;
        int[] sumsRowArray, sumsColumnArray;

        // Gets the row and columns size
        System.out.print("Enter row size (m): ");
        mRow = in.nextInt();
        System.out.print("Enter column size (n): ");
        nColumn = in.nextInt();

        // Initializes the array
        rawArray = loadArray(mRow, nColumn);
        // Gets the sums
        sumsRowArray = getRowSum(rawArray, mRow);
        sumsColumnArray = getColumnSum(rawArray, nColumn);

        // Output
        printArray(rawArray,  sumsRowArray, sumsColumnArray);
    }
}
