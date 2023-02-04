/*
* This program counts and prints the number of days with their corresponding category of temperature
* */

package Sentinel;

import java.util.Scanner;

public class SentinelDailyTemperature
{
    public static void main(String[] args)
    {
        // Initialization and declaration of variables
        Scanner in = new Scanner(System.in);

        int temp, hotCount = 0, plseCount = 0, coldCount = 0;

        // Sentinel controlled loop
        do
        {
            // Input for the temperature
            System.out.println("Enter temperature (type -999 to stop program): ");
            temp = in.nextInt();

            if (temp >= 85)
            {
                System.out.println(temp + " is a hot day");
                hotCount++;
            }
            else if (temp >= 60 & temp <= 85)
            {
                System.out.println(temp + " is a pleasant day");
                plseCount++;
            }
            else if (temp <= 60)
            {
                System.out.println(temp + " is a cold day");
                coldCount++;
            }
        } while (temp != -999);

        // Output of temperature days
        String days = String.format("\nThere are %d hotday/s, %d pleasant day/s, and %d cold day/s", hotCount, plseCount, coldCount);
        System.out.println(days);
    }
}
