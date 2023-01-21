package Diagnostic_Exam;

import java.util.*;

public class Diagnostic_Exam
{
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    // Returns a valid integer input
    public static int validIntegerInput()
    {
        int validNumber;

        for (validNumber = in.nextInt(); validNumber < 5 || validNumber > 15; validNumber = in.nextInt())
            System.out.print("Invalid integer, range is only from 5 to 15. Please input again.");

        return validNumber;
    }

    // Gets array size
    public static int getArraySize()
    {
        int arraySize;

        for (arraySize = in.nextInt(); arraySize < 1 || arraySize > 50; arraySize = in.nextInt())
            System.out.println("Invalid array size, range is only from 1 to 50. Please input again.");

        return arraySize;
    }

    // Loads random elements in an array
    public static int[] loadArray(int arraySize)
    {
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++)
            array[i] = rand.nextInt(10, 30);

        return array;
    }

    // Prints the array
    public static void printArray(int[] array)
    {
        System.out.println();
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != 0)
            {
                if (i % 10 == 9)
                    System.out.println(array[i]);
                else
                    System.out.print(array[i] + " \t");
            }
        }
    }

    // Finds the difference of elements in arrayA to the integer x then stores it to arrayB
    public static int[] loadArrayB(int[] arrayA, int integerX)
    {
        int[] arrayB = new int[arrayA.length];
        
        // Computes the arrayB
        for (int i = 0; i < arrayA.length; i++)
            arrayB[i] = arrayA[i] - integerX;

        return arrayB;
    }

    // Copies the elements of arrayB if they are greater or equal to integer x
    public static int[] loadArrayC(int[] arrayB, int integerX)
    {
        int[] arrayC = new int[arrayB.length];

        for (int i = arrayB.length - 1; i >= 0; i--)
            if (arrayB[i] >= integerX)
                arrayC[i] = arrayB[i];

        return arrayC;
    }

    // Gets the sum of an array
    public static int getArraySum(int[] array)
    {
        int sum = 0;

        for (int j : array)
            sum += j;

        return sum;
    }

    // Gets the average of an array
    public static double getArrayAverage(int[] array, int arraySum)
    {
        double average;

        average = (double) arraySum / array.length;

        return average;
    }

    // Checks if the program is continuous
    public static boolean isContinuous(char userChoice)
    {
        boolean isContinuity = false;

        if (userChoice == 'Y')
            isContinuity = true;

        return isContinuity;
    }

    public static void main(String[] args)
    {

        int[] arrayA;
        int[] arrayB;
        int[] arrayC;

        int arrayASum, arrayBSum, arrayCSum;
        double arrayAMean, arrayBMean, arrayCMean;

        char userChoice;
        int integerX, arraySize;

        do
        {   // Asks the array size
            System.out.print("\nEnter array size: ");
            arraySize = getArraySize();

            // Asks the integer x
            System.out.print("\nEnter an integer within the range of 5 and 15: ");
            integerX = validIntegerInput();

            // Loads the initial array
            arrayA = loadArray(arraySize);

            // Computes the arrays
            arrayB = loadArrayB(arrayA, integerX);
            arrayC = loadArrayC(arrayB, integerX);

            // Prints the arrays
            System.out.print("Array A:");
            printArray(arrayA);
            System.out.print("\nArray B:");
            printArray(arrayB);
            System.out.print("\nArray C:");
            printArray(arrayC);

            // Gets the sums and averages of every array
            arrayASum = getArraySum(arrayA);
            arrayAMean = getArrayAverage(arrayA, arrayASum);

            arrayBSum = getArraySum(arrayB);
            arrayBMean = getArrayAverage(arrayB, arrayBSum);

            arrayCSum = getArraySum(arrayC);
            arrayCMean = getArrayAverage(arrayC, arrayCSum);

            // Prints the averages and sums of every array
            System.out.println("\nSums and averages of every array:");

            System.out.println("\nArray A:");
            System.out.println("Sum: " + arrayASum + "\n" + "Average: " + arrayAMean);

            System.out.println("\nArray B:");
            System.out.println("Sum: " + arrayBSum + "\n" + "Average: " + arrayBMean);

            System.out.println("\nArray C:");
            System.out.println("Sum: " + arrayCSum + "\n" + "Average: " + arrayCMean);

            // Asks the user if they still want to continue the program
            System.out.println("\nPress Y to continue and press any other key to stop.");
            userChoice = in.next().charAt(0);
            userChoice = Character.toUpperCase(userChoice);

        } while (isContinuous(userChoice));

    }
}
