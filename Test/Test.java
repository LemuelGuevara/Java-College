package Test;
import static java.lang.Math.*;
import java.util.*;

public class Test {

    static boolean prime(int x)
    {
        int divisibleCtr = 0;
        boolean primeNumber = false;

        // For loop
        for (int i = 1; i <= x; i++)
        {
            if (x % i == 0)
            {
                // Counts all the divisible numbers
                divisibleCtr++;
            }
        }

        // Not prime if divisible numbers are greater than 2
        if (!(divisibleCtr > 2))
            primeNumber = true;

        return primeNumber;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num, ctr = 0, pos = 0, primeNum = 0, max, min, x, maxPrime = 0, minPrime = 0;
        int maxPos = 0, minPos = 0, primeCtr = 0;

        num = in.nextInt();

        // Checks if input value is 1 (1 is not a prime number)
        if (num == 1)
        {
            System.out.println("1 is not a prime number. Please input a valid number.");
            System.exit(0);
        }

        // Initializes max and min with num input
        max = num;
        min = num;

        while (num != 0)
        {
            x = num;

            // Counts all the values
            ctr++;

            // Checks if number in the series is a prime number
            if (prime(x))
            {
                // Position of the prime number
                pos = ctr;
                // The prime number
                primeNum = x;

                // Will get the max and min values only if the number prime
                // Checks also if the max or min value is prime or not
                if (max < primeNum || (!(prime(max))))
                {
                    max = primeNum;
                    maxPos = pos; // Position of the max prime
                }
                if (min > primeNum || (!(prime(min))))
                {
                    min = primeNum;
                    minPos = pos; // Position of the min prime
                }

                // Max and min prime numbers
                maxPrime = max;
                minPrime = min;

                // Counts the total number of prime numbers
                primeCtr++;
            }

            // Gets another input
            num = in.nextInt();
        }

        // If count of prime is 1
        if (primeCtr == 1)
        {
            System.out.println("There is only prime number, the prime number is " + primeNum + ", position is " + pos);
            System.exit(0);
        }
        // If there is no prime numbers in the series
        if (primeCtr == 0)
        {
            System.out.println("There is no prime number in the series.");
            System.exit(0);
        }

        // Outputs
        System.out.println();
        System.out.println("Highest prime number is " + maxPrime + ", position is " + maxPos);
        System.out.println("Lowest prime number is " + minPrime + ", position is " + minPos);
    }
}
