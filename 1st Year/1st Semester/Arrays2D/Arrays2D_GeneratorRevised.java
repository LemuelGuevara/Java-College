/*
* Modified generator program by using 2D arrays
* */

package Arrays2D;

import java.util.*;

public class Arrays2D_GeneratorRevised
{
    static Scanner in = new Scanner(System.in);

    // Gets array size
    static int getArraySize()
    {
        int size;

        System.out.print("\nEnter number of generators: ");
        size = in.nextInt();

        return size;
    }

    // Gets average of 3 voltages
    static void getAverage(double[][] array)
    {
        double sum = 0, average;

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                sum += array[i][j];
                average = sum / 3;

                // Puts the average at the last column
                array[i][array[i].length - 1] = average;
            }
        }
    }

    // Prints the header
    static void printHeader(double[][] array)
    {
        // Prints results
        System.out.println();
        System.out.print("---Generator---");
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < 1; j++)
            {
                System.out.print("    \t" + "Voltage " + (i + 1) + "");
            }
        }
        System.out.print("    \t" + "Average");

    }

    public static void main(String[] args)
    {
        // Variables
        int size = getArraySize();
        int voltageSize = 3;

        double[][] generators = new double[size][4];

        // Get voltages
        for (int i = 0; i < size; i++)
        {
            System.out.println("---Generator: " + (i + 1) + "---");
            for (int j = 0; j < voltageSize; j++)
            {
                System.out.print("Voltage " + (j + 1) + " : ");
                generators[i][j] = in.nextDouble();
            }
        }

        // Gets average of voltages
        getAverage(generators);

        // Prints the header
        printHeader(generators);

        // Prints the elements
        for (int i = 0; i < generators.length; i++)
        {
            System.out.println();
            System.out.print("Generator " + (i + 1) + " ");
            for (int j = 0; j < generators[i].length; j++)
            {
                System.out.print("    \t" + generators[i][j] + "\t");
            }
        }
        System.out.println();
    }
}
