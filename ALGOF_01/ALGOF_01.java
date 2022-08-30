package ALGOF_01;
/**
 * This program waits for the input of the temperature given by the user
 * Inputs: temperature
 * Outputs:
 */
import java.util.*;

public class ALGOF_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int hotCount = 0, plseCount = 0, coldCount = 0;
        int sen = -999;

        // Input for the temperature
        while (true) {
            // Input for the temperature
            System.out.println("Enter temperature: ");
            int temp = input.nextInt();

            // Condition wherein if temp is -999, program will end
            if (temp == sen)
            {
                break;
            }
            else if (temp > 85)
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
            // Output of temperature days
            String days = String.format("\nThere are %d hotdays, %d pleasant days, and %d cold days", hotCount, plseCount, coldCount);
            System.out.println(days);
        }
    }
}
