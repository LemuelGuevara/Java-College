package Array1DStdDev;

import java.util.*;
import static java.lang.Math.*;

public class Array1DStdDev
{
    static Scanner in = new Scanner(System.in);

    // Gets array size
    static int getArraySize()
    {
        int arraySize;

        System.out.print("\nEnter size of numbers to be input (max - 100, min - 1): ");
        arraySize = in.nextInt();

        if (arraySize <= 0 || arraySize > 100)
        {
            System.out.println("Please input a valid array size.");
            System.exit(0);
        }

        return arraySize;
    }

    // Gets mean
    static double getMean(double[] array)
    {
        double sum = 0, mean;

        for (double x: array)
            sum += x;
        mean = sum / array.length;

        return mean;
    }

    // Gets standard deviation
    static double getStdDev(double[] array)
    {
        double xElement, varSum = 0, variance, stdDev;

        // Variance
        for (double x: array)
        {
            xElement = pow(x - getMean(array), 2);
            varSum += xElement;
        }
        variance = varSum / (array.length - 1);

        // Standard deviation
        stdDev = sqrt(variance);

        return stdDev;
    }

    public static void main(String[] args)
    {
        // Variables
        final int arraySize = getArraySize();
        double[] integerArray = new double[arraySize];

        System.out.print("Enter " + arraySize + " numbers: ");
        for (int i = 0; i < arraySize; i++)
        {
            integerArray[i] = in.nextDouble();
        }

        // Prints the elements of the array
        System.out.println("\n\nElements of the array:");
        for (int i = 0; i < arraySize; i++)
        {
            if (i % 2 == 0)
                System.out.println(integerArray[i]);
            else
                System.out.print(integerArray[i] + " \t");
        }

        // Outputs
        System.out.println("\n");
        System.out.printf("Mean: %.4f%n", getMean(integerArray));
        System.out.printf("Standard Deviation: %.4f%n", getStdDev(integerArray));
    }
}
