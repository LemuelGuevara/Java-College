/*
* This program calculates the shipping charges of an order. It will prompt the user to input
* the weight of the order in ounces and it will ask for what type of customer are they
* (R - Regular, V - VIP).
* */

package SwitchSoftware;
import java.util.*;

public class SwitchSoftware
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        double weight, rate = 0, shippingCharge, discount = 0.88, tax = 1.12;
        char customerType;

        // Program description prompt
        System.out.println("This program calculates the shipping charges of an order. It will prompt the user to input\n" +
                "the weight of the order in ounces and it will ask for what type of customer are they\n" +
                "(R - Regular, V - VIP).\n");

        // Inputs
        System.out.println("Enter weight of order: ");
        weight = in.nextDouble();
        System.out.println("Enter customer type(R - Regular, V - VIP): ");
        customerType = in.next().charAt(0);
        customerType = Character.toUpperCase(customerType);

        // Checks if weight is less than 1 or greater than 50
        if (weight < 1 || weight > 50)
        {
            System.out.println("Weight is invalid. Please input a valid weight.");
            System.exit(0);
        }

        // Charge evaluation
        if (weight <= 8)
            rate = 155.75;
        else if (weight < 32)
            rate = 155.75 + (weight - 8) * 15.50;
        else if (weight >= 32)
            rate = 550.60 + (weight - 32) * 18.75;

        // To determine type of customer
        switch (customerType)
        {
            case 'R': rate *= 1;
                break;
            case 'V': rate *= 0.88;
                break;

            default:
                System.out.println("Customer type is invalid. Please input a valid customer type.");
        }

        // Shipping charge
        shippingCharge = rate * 1.12;

        // Outputs
        System.out.printf("Shipping charge: %.2f%n", shippingCharge);

    }
}
