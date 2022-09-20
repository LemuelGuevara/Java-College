/*
 * This program asks for the weight of the package, type of package,
 * and distance then computes for the gross charge and total charge
 * */

package SwitchABCShipping;
import java.util.*;
import static java.lang.Math.*;

public class SwitchABCShipping
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        char packageType;
        double weight, distance, grossCharge, distanceCost, rate = 0, vat = 1.1, totalCharge;

        // Program prompt description
        System.out.println("This program asks the user to input the weight, type, and distance to be shipped of a \n" +
                "package\n");

        // Inputs
        System.out.println("Enter type of package (a for type B and b for type B): ");
        packageType = in.next().charAt(0);
        packageType = Character.toUpperCase(packageType);
        System.out.println("Enter weight of package: ");
        weight = in.nextDouble();
        System.out.println("Enter distance: ");
        distance = in.nextDouble();

        // Condition if weight is <= 0 or > 20
        if (weight <= 0 || weight > 20)
        {
            System.out.println("Weight is invalid.");
            System.exit(0);
        }

        // Switch statement
        switch (packageType)
        {
            case 'A':
                if (weight <= 5)
                {
                    rate = 10.50;
                }
                else if (weight <= 10)
                {
                    rate = 15.75;
                }
                else if (weight <= 20)
                {
                    rate = 20.65;
                }
                break;
            case 'B':
                if (weight <= 5)
                {
                    rate = 11.75;
                }
                else if (weight <= 10)
                {
                    rate = 18.50;
                }
                else if (weight <= 20)
                {
                    rate = 23.65;
                }
                break;
            default:
                System.out.println("Package type is invalid.");
                System.exit(0);
        }

        // Computes for the cost of the distance
        if (distance <= 500)
        {
            distanceCost = 1.0;
        }
        else // if distance is more than 500km
        {
            distanceCost = ceil(distance / 500.0);
        }

        // Computation of gross and total charge
        grossCharge = weight * rate * distanceCost;
        totalCharge = grossCharge * vat;

        // Outputs
        System.out.printf("Gross cost: %.2f\n", grossCharge);
        System.out.printf("Net Cost: %.2f", totalCharge);
    }
}
