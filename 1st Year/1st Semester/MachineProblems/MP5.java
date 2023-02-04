/*
* Name: Guevara, Lemuel John D.
* Section: 1CSD
* */

package MachineProblems;

import java.util.*;

public class MP5
{

    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    // Loads the array with random integers
    static int[][] loadArray(int row, int column)
    {
        int[][] array = new int[row][column];

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = rand.nextInt(1, 25);
        }

        return array;
    }

    // Flattens matrix
    static int[] flattenMatrix(int[][] matrix)
    {
        int[] flattenedMatrix = new int[matrix.length * matrix[0].length];
        int index = 0;

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
                flattenedMatrix[index++] = matrix[i][j];
        }

        return flattenedMatrix;
    }

    // Sorts a 1D array
    static int[] sortArray(int[] array)
    {
        boolean sorted = false;

        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i] > array[i + 1])
                {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        return array;
    }

    static int[][] loadSortedMatrix(int[][] array, int mRow, int nColumn)
    {
        int[] sortedFlattenedMatrix = sortArray(flattenMatrix(array));
        int[][] sortedConvertedMatrix = new int[mRow][nColumn];

        int index = 0;
        for (int i = 0; i < sortedConvertedMatrix.length; i++)
        {
            for (int j = 0; j < sortedConvertedMatrix[i].length; j++)
                sortedConvertedMatrix[i][j] = sortedFlattenedMatrix[index++];
        }

        return sortedConvertedMatrix;
    }

    static int[] initJaggedArray(int[][] array)
    {
        int range1 = 0, range2 = 0, range3 = 0, range4 = 0, range5 = 0;
        int[] ranges = new int[5];

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                int element = array[i][j];

                if (element <= 5)
                    ranges[0] = ++range1;
                else if (element <= 10)
                    ranges[1] = ++range2;
                else if (element <= 15)
                    ranges[2] = ++range3;
                else if (element <= 20)
                    ranges[3] = ++range4;
                else
                    ranges[4] = ++range5;
            }
        }

        return ranges;
    }

   // Loads the jagged array
    static int[][] loadJaggedArray(int[][] array)
    {
        int[][] jaggedArray = new int[5][];
        int[] ranges = initJaggedArray(array);
        int[] sortedFlattenedMatrix = sortArray(flattenMatrix(array));
        int convertedIndex = 0;

        for (int i = 0; i < jaggedArray.length; i++)
        {
            jaggedArray[i] = new int[ranges[i]];
            for (int j = 0; j < ranges[i]; j++)
                jaggedArray[i][j] = sortedFlattenedMatrix[convertedIndex++];
        }

        return jaggedArray;
    }

    static int count(int[] array)
    {
        int count = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != 0)
                count++;
        }

        return count;
    }

    static int[][] findRepeatingMax(int[][] array)
    {
        int[] integerArray = sortArray(flattenMatrix(array));
        int[] frequencyArray = new int[integerArray.length];
        int[][] maxRepeat = new int[frequencyArray.length][2];
        int counted = -1;
        int maxRepeatCounter = 0;

        // Counts the frequency in the integer array
        for (int i = 0; i < integerArray.length; i++)
        {
            int count = 1;
            for(int j = i + 1; j < integerArray.length; j++)
            {
                if (integerArray[i] == integerArray[j])
                {
                    count++;
                    frequencyArray[j] = counted;
                }
            }

            if (frequencyArray[i] != counted)
                frequencyArray[i] = count;
        }

        // Takes the frequency and integer array into a 2D array
        for (int i = 0; i < frequencyArray.length; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                if (frequencyArray[i] != counted)
                {
                    maxRepeat[i][0] = integerArray[i];
                    maxRepeat[i][1] = frequencyArray[i];
                }
            }
        }

        return maxRepeat;
    }

    // Prints all the arrays
    static void printArray(int[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("\t");
            // Prints the raw array
            for (int j = 0; j < array[i].length; j++)
                System.out.print("\t" + array[i][j] + "\t");
        }
    }

    static void printJaggedArray(int[][] jaggedArray)
    {
        for (int i = 0; i < jaggedArray.length; i++)
        {
            System.out.println("\t");
            // Prints the raw array
            for (int j = 0; j < jaggedArray[i].length; j++)
                System.out.print("\t" + jaggedArray[i][j] + "\t");
        }
    }

    public static void main(String[] args)
    {
        int mRow, nColumn;
        int[][] rawArray, sortedArray, jaggedArray, frequencyMax;

        // Gets the row and columns size
        System.out.print("Enter row size (m): ");
        mRow = in.nextInt();
        System.out.print("Enter column size (n): ");
        nColumn = in.nextInt();

        // Outputs
        rawArray = loadArray(mRow, nColumn);
        System.out.println(" \n\t" + "---Raw 2D Array---");
        printArray(rawArray);

        System.out.println();
        sortedArray = loadSortedMatrix(rawArray, mRow, nColumn);
        System.out.println(" \n\t" + "---Sorted 2D Array---");
        printArray(sortedArray);

        System.out.println();
        System.out.println(" \n\t" + "---Jagged Array---");
        jaggedArray = loadJaggedArray(sortedArray);
        System.out.println();
        printJaggedArray(jaggedArray);

        frequencyMax = findRepeatingMax(sortedArray);

        printJaggedArray(frequencyMax);
    }
}
