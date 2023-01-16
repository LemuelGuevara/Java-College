/**
 * This program prompts the  user to input a four-digit positive integer.
 * The program then outputs the digits of the number, one digit per line.
 */

package BASIC_102_11;
import java.util.*;

public class BASIC_102_11
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner input = new Scanner(System.in);

        String n;

        // Program description prompt
        System.out.println("This program prompts the  user to input a four-digit positive integer.\n" +
                "The program then outputs the digits of the number, one digit per line.\n");

        // Inputs
        System.out.println("Enter 4-digit integer:");
        n = input.nextLine();

        // A for loop wherein it would iterate through the max length of the given string or integer
        for (int i = 0; i < n.length(); i++)
        {
            System.out.println(n.charAt(i)); // Prints index of n
        }
    }
}
