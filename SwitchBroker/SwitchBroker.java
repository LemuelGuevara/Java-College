/*
* This program prompts the user for the broker type,
* sale price of the property and the property code. If the user enters an invalid property code or broker code,
* the program should display an appropriate message and end the program. Allow the user to enter uppercase
* and lowercase letters.
* */

package SwitchBroker;
import java.util.*;

public class SwitchBroker
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        char propertyType, brokerType;
        double salesPrice, commissionRate = 0, tax = 0, grossCommission, netCommission;

        // Program description prompt
        System.out.println("This program prompts the user for the broker type,\n" +
                "sale price of the property and the property code. If the user enters an invalid property code or broker code, \n" +
                "the program should display an appropriate message and end the program. Allow the user to enter uppercase \n" +
                "and lowercase letters.\n");

        // Inputs
        System.out.println("Enter sales price of property: ");
        salesPrice = in.nextDouble();
        System.out.println("Enter property type (Residential - R, Commercial - C, Agricultural - G): ");
        propertyType = in.next().charAt(0);
        propertyType = Character.toUpperCase(propertyType);
        System.out.println("Enter broker type (In-house - I, Accredited - A): ");
        brokerType = in.next().charAt(0);
        brokerType = Character.toUpperCase(brokerType);

        // Condition if broker type input is invalid
        if (!(brokerType == 'I' || brokerType == 'A'))
        {
            System.out.println("Broker type input is invalid. Please try again.");
            System.exit(0);
        }

        // Switch statement for propertyType
        switch (propertyType)
        {
            case 'R':
                commissionRate = 0.060;
                break;
            case 'C':
                commissionRate = 0.045;
                break;
            case 'G':
                commissionRate = 0.040;
            default:
                // If input is none of the choices
                System.out.println("Type is invalid. Please input a valid type.");
                System.exit(0);
        }
        // Switch statement for brokerType
        switch (brokerType)
        {
            case 'I': tax = 1.20;
                break;
            case 'A': tax = 1.25;
                break;
            default:
                // If input is none of the choices
                System.out.println("Type is invalid. Please input a valid type.");
                System.exit(0);
        }

        // Computation
        grossCommission = salesPrice * commissionRate;
        netCommission = grossCommission - tax;

        // Outputs
        System.out.printf("Gross Commission: %.2f%n", grossCommission);
        System.out.printf("Net Commission: %.2f%n", netCommission);
    }
}
