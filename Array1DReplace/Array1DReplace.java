/*
* This program replaces elements in array with the input of a user
* */

package Array1DReplace;

import java.util.*;
import static java.lang.Math.*;

public class Array1DReplace
{
    static Scanner in = new Scanner(System.in);

    // Sorts arrays
    static void bubbleSort(int[] array)
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
    }

    public static void main(String[] args)
    {
        // Variables
        int[] dataArr = new int[15];
        int n;
        Random rand = new Random();

        // Load array with random integers ranging 35-50
        for (int i = 0; i < dataArr.length; i++)
            dataArr[i] = rand.nextInt(35, 50);

        // Program description
        System.out.println("\nThis program replaces elements in array with the input of a user");

        // Display initial elements
        bubbleSort(dataArr);
        System.out.println("Elements A: " + Arrays.toString(dataArr) + "\n");

        // Inputs
        System.out.print("Enter n value (ranging 35-50): ");
        n = in.nextInt();

        // Compare array elements to n input
        for (int i = 0; i < dataArr.length; i++)
        {
            if (dataArr[i] < n)
                dataArr[i] = n;
        }

        // New arrays with replaced elements
        bubbleSort(dataArr);
        System.out.println("New elements of A: " + Arrays.toString(dataArr));
    }
}
