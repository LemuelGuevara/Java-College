/*
* This program processes a data file containing a collection of temperatures then categorizes them
* according to their temperatures
* */

package Array1DTemperatures;

import java.util.*;

public class Array1DTemperatures
{
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();
    static int hotCtr = 0, pleasantCtr = 0, coldCtr = 0;

    // Gets the data file size
    static int getDataFileSize()
    {
        int dataSizeInput;

        for (dataSizeInput = in.nextInt(); dataSizeInput < 0 || dataSizeInput > 50; dataSizeInput = in.nextInt())
            System.out.print("Please input a valid data size.");

        return dataSizeInput;
    }

    // Initializes the data file with random integers
    static int[] initDataFile(int dataSize)
    {
        int dataArr[] = new int[dataSize];

        for (int i = 0; i < dataSize; i++)
            dataArr[i] = rand.nextInt(100);

        return dataArr;
    }

    // Evaluates the temperatures in the data file
    static void processDataFile(int[] dataFile)
    {
        final int dataFileSize = dataFile.length;

        int temperature;

        int[] hotDays = new int[dataFileSize];
        int[] pleasantDays = new int[dataFileSize];
        int[] coldDays = new int[dataFileSize];

        for (int i = 0; i < dataFile.length; i++)
        {
            temperature = dataFile[i];

            if (temperature >= 85)
            {
                hotDays[i] = temperature;
                hotCtr++;
            }
            else if (temperature >= 60 & temperature <= 85)
            {
                pleasantDays[i] = temperature;
                pleasantCtr++;
            }
            else if (temperature <= 60)
            {
                coldDays[i] = temperature;
                coldCtr++;
            }
        }

        // Outputs
        System.out.print("Number of hot days: " + hotCtr + " | recorded temperatures: ");
        printData(hotDays);
        System.out.print("Number of pleasant days: " + pleasantCtr + " | recorded temperatures: ");
        printData(pleasantDays);
        System.out.print("Number of cold days: " + coldCtr + " | recorded temperatures: ");
        printData(coldDays);
    }

    // Prints elements in array
    static void printData(int[] dataFile)
    {
        for (int i = 0; i < dataFile.length; i++)
        {
            if (dataFile[i] != 0)
                System.out.print(dataFile[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        // Variables
        Random rand = new Random();

        int[] dataFile;
        int dataFileSize;

        // Inputs
        System.out.println("Enter data size: ");
        dataFileSize = getDataFileSize();

        // Populates array
        dataFile = initDataFile(dataFileSize);

        // Prints all outputs
        System.out.print("DataFile: ");
        printData(dataFile);
        System.out.println();

        processDataFile(dataFile);
    }
}
