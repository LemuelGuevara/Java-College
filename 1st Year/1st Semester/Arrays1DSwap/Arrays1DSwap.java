/*
* This program loads an array with N random integers then swaps
* them in a way that the array is reversed then adds the elements of the
* clean array to the swapped array
* */

package Arrays1DSwap;

import java.util.*;

public class Arrays1DSwap
{
    static Scanner in = new Scanner(System.in);

    // Validates n input by the user
    static void validateN(int n)
    {
        if (!(n >= 10 && n <= 50 ))
        {
            System.out.println("Pleas input a value within the range.");
            System.exit(0);
        }
    }

    // Loads array with random elements
    static int[] loadArray(int arraySize)
    {
        int[] array = new int[arraySize];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(10, 30);

        return array;
    }

    // Swaps and adds elements arrayA
    static int[] swapAddElements(int[] array)
    {
        int size = array.length;
        int temp;

        for (int i = 0; i < size / 2; i++)
        {
            temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }

        return array;
    }

    // Adds the elements of arrayA(not swapped) to the swapped array
    static int[] swapAddElements(int[] nonSwappedArray, int[] swappedArray)
    {
        int size = nonSwappedArray.length;
        int[] arrayB = new int[size];

        // Adds elements in arrayA(not swapped) and swappedArray
        for (int i = 0; i < size ; i++)
        {
            for (int j = 0; j < size; j++)
                arrayB[i] = nonSwappedArray[i] + swappedArray[j];
        }

        return arrayB;
    }

    // Prints arrays
    static void display(int[] array)
    {
        for (int element: array)
            System.out.print(element + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        // Variables
        int nValue;
        int[] arrayA;
        int[] swappedArray;

        // Program description
        System.out.println("\nThis program loads an array with N random integers then swaps \n" +
                "them in a way that the array is reversed then adds the elements of the \n" +
                "clean array to the swapped array\n");

        // Inputs
        System.out.print("Enter number of elements (10-30): ");
        nValue = in.nextInt();
        System.out.println();

        // Validates n input by user
        validateN(nValue);

        // Loads array
        arrayA = loadArray(nValue);

        // Outputs
        System.out.print("Elements of A: ");
        display(arrayA);
        swappedArray = swapAddElements(arrayA);

        System.out.print("Elements of A after swapping: ");
        display(swappedArray);

        System.out.print("Elements of B: ");
        display(swapAddElements(arrayA, swappedArray));
    }
}
