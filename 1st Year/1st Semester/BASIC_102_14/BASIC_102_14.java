/**
 * This program reads original price of the item
 * sold, the percentage of the marked-up price, and the sales tax rate. The
 * program then outputs the original price of the item, the marked-up percentage
 * of the item, the store’s selling price of the item, the sales tax rate,
 * the sales tax, and the final price of the item.
 */

package BASIC_102_14;
import java.util.*;

public class BASIC_102_14
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        double origPrice, markedUpPercentage, salesTaxRate, salesTax, sellingPrice, finalPrice;

        // Program description prompt
        System.out.println("This program reads original price of the item\n" +
                "sold, the percentage of the marked-up price, and the sales tax rate. The\n" +
                "program then outputs the original price of the item, the marked-up percentage\n" +
                "of the item, the store’s selling price of the item, the sales tax rate,\n" +
                "the sales tax, and the final price of the item.\n");

        // Get inputs
        System.out.println("Enter original price: ");
        origPrice = in.nextDouble();
        System.out.println("Enter marked-up percentage of price: ");
        markedUpPercentage = in.nextDouble();
        System.out.println("Enter sales tax rate: ");
        salesTaxRate = in.nextDouble();

        // Selling price computation
        sellingPrice = origPrice*(markedUpPercentage / 100);
        sellingPrice += origPrice;

        // Solve for salesTax
        salesTax = origPrice*(salesTaxRate / 100.0);

        // Compute final price
        finalPrice = origPrice+salesTax;

        // Outputs
        System.out.println("Original price: " + origPrice);
        System.out.println("Marked-up percentage: " + markedUpPercentage);
        System.out.println("Selling price: " + sellingPrice);
        System.out.println("Sales tax rate: " + salesTaxRate);
        System.out.println("Sales tax: " + salesTax);
        System.out.println("Final price: " + finalPrice);
    }
}
