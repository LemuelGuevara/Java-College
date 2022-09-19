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
        System.out.println("Enter length of call: ");
        callLength = in.nextDouble();
        System.out.println("Enter type of call (S, O, I): ");
        callType = in.next().charAt(0);


        // Condition if time of call is none of the given choices
        if (!(callTime == 'D' || callTime == 'N' || callTime == 'd' || callTime == 'n'))
        {
            System.out.println("Invalid time of call");
            System.exit(0);
        }
        // Condition if type of call is none of the choices
        if (!(callType == 'S' || callType == 'N' || callType == 'I' || callType == 's' || callType == 'n' || callType == 'i'))
        {
            System.out.println("Invalid time of call");
            System.exit(0);
        }

        // Uppercase all inputs for the conditions
        callTime = Character.toUpperCase(callTime);
        callType = Character.toUpperCase(callType);

        // Conditions
        if (callTime == 'D')
        {
            if (callType == 'S')
                rate = 6.75;
            if (callType == 'O')
                rate = 8.75;
            if (callType == 'I')
                rate = 26.65;
        }
        if (callTime == 'N')
        {
            if (callType == 'S')
                rate = 6.25;
            if (callType == 'O')
                rate = 7.50;
            if (callType == 'I')
                rate = 23.30;
        }

        // Gross charge
        grossCharge = rate * callLength;
        // Gross charge before discount and taxes
        System.out.printf("Gross Charge: %.2f%n", grossCharge);

        // Checks if discount is available
        if (callLength > 20)
            grossCharge *= discount;

        // Net charge
        netCharge = grossCharge * vat;

        // Net charge output
        System.out.printf("Net Charge: %.2f%n", netCharge);
    }
}
