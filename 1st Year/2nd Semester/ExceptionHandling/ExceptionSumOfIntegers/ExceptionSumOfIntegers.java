package ExceptionHandling.ExceptionSumOfIntegers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionSumOfIntegers
{
    static Scanner in = new Scanner(System.in);

    // Function that gets a valid integer then validates
    public static double validIntegerInput()
    {
        double userInput = 0;
        final String ERROR_LOG = "Integer should be only numeric and positive";

        try
        {
            userInput = in.nextDouble();

            if (userInput < 0)
            {
                System.out.println(ERROR_LOG);
                System.exit(0);
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println(ERROR_LOG);
            System.exit(0);
        }

        return userInput;
    }

    public static void main(String[] args)
    {
        System.out.println("\nThis program adds a series of valid integers");
        System.out.println("\nEnter numbers (Type 0 to stop): ");

        double userInput, sum = 0;

        // Do while loop in getting the numbers and getting the sum
        do
        {
           userInput = validIntegerInput();
           sum += userInput;

        } while (userInput != 0);

        System.out.println("Sum is " + sum);
    }
}
