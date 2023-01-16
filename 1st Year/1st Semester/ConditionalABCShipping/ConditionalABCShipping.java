/*
 * This program asks for the weight of the package, type of package,
 * and distance then computes for the gross charge and total charge
 */

package ConditionalABCShipping;
import java.util.*;
import static java.lang.Math.*;

public class ConditionalABCShipping
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        double weight, distance, grossCharge, distanceCost, rate = 0, vat = 1.1, totalCharge;
        String packageType;

        // Inputs
        System.out.println("Enter type of package (a for type B and b for type B): ");
        packageType = in.next();
        System.out.println("Enter weight of package: ");
        weight = in.nextInt();
        System.out.println("Enter distance: ");
        distance = in.nextInt();

        // Computes for the cost of the distance
        if (distance <= 500)
        {
            distanceCost = 1.0;
        }
        else // if distance is more than 500km
        {
            distanceCost = ceil(distance / 500.0);
        }

        // Evaluation for package type a
        if (packageType.equalsIgnoreCase("a"))
        {
            if (weight <= 5)
            {
                rate = 10.50;
            }
            if (weight > 5 && weight <= 10)
            {
                rate = 15.75;
            }
            if (weight > 10 && weight <= 20)
            {
                rate = 20.65;
            }
        }
        // Evaluation for package type b
        if (packageType.equalsIgnoreCase("b"))
        {
            if (weight <= 5)
            {
                rate = 11.75;
            }
            if (weight > 5 && weight <= 10)
            {
                rate = 18.50;
            }
            if (weight > 10 && weight <= 20)
            {
                rate = 23.65;
            }
        }
        // Computation of gross and total charge
        grossCharge = weight * rate * distanceCost;
        totalCharge = grossCharge * vat;

        // Outputs
        System.out.printf("Gross cost: %.2f\n", grossCharge);
        System.out.printf("Net Cost: %.2f", totalCharge);
    }
}