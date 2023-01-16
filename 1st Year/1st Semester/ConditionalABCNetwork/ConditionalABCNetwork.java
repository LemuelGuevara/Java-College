/*
* This program that asks the user for the time of call(D or N),the length of call in minutes and type of call (S/O/I).
* If length of call is greater than 20 minutes and it is a night call, a 10% discount is given.
* The total charge is the corresponding rate times the length of the call less discount.
* The net charge is total charge plus 10% EVAT. The program then displays the total charge and net charge.
* */

package ConditionalABCNetwork;
import java.util.*;

public class ConditionalABCNetwork
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        char callTime, callType;
        double rate = 0, callLength, grossCharge, netCharge, discount = 0.9, vat = 1.1;

        // Program description prompt
        System.out.println("This program computes for the grossCharge and netCharge of a network call");

        // Inputs
        System.out.println("Enter Time of call (D, N): ");
        callTime = in.next().charAt(0);
        callTime = Character.toUpperCase(callTime);
        System.out.println("Enter type of call (S, O, I): ");
        callType = in.next().charAt(0);
        callType = Character.toUpperCase(callType);
        System.out.println("Enter length of call: ");
        callLength = in.nextDouble();

        // Condition if time of call is none of the given choices
        if (!(callTime == 'D' || callTime == 'N' ))
        {
            System.out.println("Invalid time of call");
            System.exit(0);
        }
        // Condition if type of call is none of the choices
        if (!(callType == 'S' || callType == 'I' || callType == 'O'))
        {
            System.out.println("Invalid type of call");
            System.exit(0);
        }

        // Conditions
        if (callTime == 'D')
        {
            if (callType == 'S')
                rate = 6.75;
            else if (callType == 'O')
                rate = 8.75;
            else if (callType == 'I')
                rate = 26.65;
        }
        if (callTime == 'N')
        {
            if (callType == 'S')
                rate = 6.25;
            else if (callType == 'O')
                rate = 7.50;
            else if (callType == 'I')
                rate = 23.30;
        }

        // Gross charge
        grossCharge = rate * callLength;

        // Checks if discount is available
        if (callLength > 20 && callTime == 'N')
            grossCharge *= discount;

        // Net charge
        netCharge = grossCharge * vat;

        // Outputs
        System.out.printf("Gross Charge: %.2f%n", grossCharge);
        System.out.printf("Net Charge: %.2f%n", netCharge);
    }
}
