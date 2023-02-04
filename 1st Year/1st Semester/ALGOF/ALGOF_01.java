package ALGOF;
/**
 * This program waits for the input of the temperature given by the user
 * Inputs: temperature
 * Outputs:
 */
import java.util.*;

public class ALGOF_01
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int temp, hotCount = 0, plseCount = 0, coldCount = 0;

        // Input for the temperature
        System.out.println("Enter temperature: ");
        temp = input.nextInt();

        while (temp != -999)
        {
            if (temp > 85)
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
            // Asks for another input of temperature
            System.out.println("Enter another temperature or type -999 to exit: ");
            temp = input.nextInt();
        }
        // Output of temperature days
        String days = String.format("\nThere are %d hotdays, %d pleasant days, and %d cold days", hotCount, plseCount, coldCount);
        System.out.println(days);
    }
}
