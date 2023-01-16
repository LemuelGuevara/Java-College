package Arrays2D_Frequency;

import java.util.*;

public class Arrays2D_Frequency
{
    static Scanner in = new Scanner(System.in);

    static int[] loadArray(int size)
    {
        int[] array = new int[size];

        Random rand = new Random();

        for (int i = 0; i < size; i++)
            array[i] = rand.nextInt(1, 20);

        return array;
    }

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

    static int[][] getFrequency(int[] numberArray)
    {
        int[] frequencyArray = new int[numberArray.length];
        int[][] results;
        int counted = -1;

        for (int i = 0; i < numberArray.length; i++)
        {
            int count = 1;
            for(int j = i + 1; j < numberArray.length; j++)
            {
                if (numberArray[i] == numberArray[j])
                {
                    count++;
                    frequencyArray[j] = counted;
                }
            }

            if (frequencyArray[i] != counted)
            {
                frequencyArray[i] = count;
            }
        }

        results = new int[frequencyArray.length][frequencyArray.length];
        int k = 0, l = 0;

        for (int i = 0; i < frequencyArray.length; i++)
        {
            for (int j = 0; j < frequencyArray.length; j++)
            {
                if (frequencyArray[i] != counted)
                {
                    ++k;
                    ++l;

                    int maxRepeatRow, maxRepeatColumn;
                    maxRepeatRow =

                    results[i][0] = numberArray[i];
                    results[i][j] = frequencyArray[i];
                }
            }
        }

        return results;
    }

    static void printArray(int[][] array)
    {

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                System.out.print(array[i][j] + " \t");
//                if (array[i][j] != 0)
            }
            System.out.print(i);
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int arraySize;
        int[] numberArray, sortedArray;
        int[][] results;

        System.out.print("Enter size of array: ");
        arraySize = in.nextInt();

        numberArray = loadArray(arraySize);
        System.out.println();

        sortedArray = sortArray(numberArray);
        results = getFrequency(sortedArray);


        printArray(results);
    }
}
