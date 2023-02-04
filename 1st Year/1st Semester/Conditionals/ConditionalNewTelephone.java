/*
* This program computes the gross cost and net cost of long distance calls
* */

package Conditionals;
import java.util.*;

public class ConditionalNewTelephone
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        double rate = 4.0, callLength, grossCost, vat = 1.12, netCost = 1, netCostA, netCostB;

        // Inputs
        System.out.println("Enter time of call (A for day and B for night, or press any other key to quit): ");
        String time = in.nextLine();
        System.out.println("Enter length of call: ");
        callLength = in.nextInt();

        // Computes the raw cost of the
        grossCost = rate * callLength;

        // Evaluates the input of time wherein A = day & B = night
        if (time.equalsIgnoreCase("A"))
        {
            // if length of call is greater than 60 minutes then call be will be discounted 15%
            if (callLength > 60)
            {
                netCostA = (grossCost * 0.85) * vat;
                netCost = netCostA;
            }
            // if call length is not greater than 60 minutes then call will have no discount
            else
            {
                netCostA = grossCost * vat;
                netCost = netCostA;
            }
        }
        // Conditions for night calls
        if (time.equalsIgnoreCase("B"))
        {
            if (callLength > 60)
            {
                netCostB = (grossCost * 0.50 * 0.85) * vat;
                netCost = netCostB;
            }
            else
            {
                netCostB = (grossCost * 0.50) * vat;
                netCost = netCostB;
            }
        }
        // Outputs
        System.out.printf("Gross cost: %.2f\n", grossCost);
        System.out.printf("Net Cost: %.2f", netCost);
    }
}
