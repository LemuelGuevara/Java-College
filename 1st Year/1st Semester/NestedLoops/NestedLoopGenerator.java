/*
* This program calculates the average voltage of generators
* */

package NestedLoops;
import java.util.*;

public class NestedLoopGenerator
{
    public static void main(String[] args)
    {
        // Variables
        Scanner in = new Scanner(System.in);

        int generatorNum;
        double voltage, voltageSum = 0, voltageAverage;

        // Inputs
        System.out.println("Enter number of generators: ");
        generatorNum = in.nextInt();

        // Outer loop (generators)
        for (int i = 1; i <= generatorNum; i++)
        {
            System.out.println("---Generator: " + i + "---");

            // Inner loop (voltages)
            for (int j = 1; j <= generatorNum; j++)
            {
                System.out.print("Voltage " + j + ": ");
                voltage = in.nextDouble();
                voltageSum += voltage;
            }
            // Average of all voltage sum
            voltageAverage = voltageSum / generatorNum;

            // Resets sum to 0
            voltageSum = 0;

            // Outputs the voltage of each generator
            System.out.println("Voltage Average: " + voltageAverage);
        }
    }
}
