/**
 * This program prompts the user to enter an hourly pay rate and asks for number of hours
 * user works in a week. The program then outputs income before and after taxes, the money
 * the user spends on clothes and accessories, money spent in school supplies, money to buy
 * savings bonds, and money the parents of the user spend to buy additional saving bonds.
 */

package BASIC_102_18;
import java.util.*;

public class BASIC_102_18
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        final double TAX_RATE = 0.86;

        Scanner in = new Scanner(System.in);

        // Job related variables
        double payRate, workHours, grossIncome, netIncome, netIncomeAfter;
        // Money spent outside
        double clothesAccessoriesPercent, schoolSuppliesPercent, bondsPercent, parentBondsPercent;

        // Program description prompt
        System.out.println("This program computes your gross and net come and your expenses in different categories.\n");

        // Job inputs
        System.out.println("Enter hourly pay rate: ");
        payRate = in.nextDouble();
        System.out.println("Enter number of work hours per week: ");
        workHours = in.nextDouble();

        // The income before and after taxes
        grossIncome = payRate * workHours;
        netIncome = grossIncome * TAX_RATE;

        // Display gross and net income
        System.out.println("Gross income: " + grossIncome + "\n" + "Net income: " + netIncome + "\n");

        // Asks the user to input percentage of money spent in different areas of expenses
        System.out.println("Enter percentage to be spent on clothes and accessories: ");
        clothesAccessoriesPercent = in.nextDouble();
        System.out.println("Enter percentage to be spent on school supplies: ");
        schoolSuppliesPercent = in.nextDouble();
        System.out.println("Enter percentage to be spent on savings bonds: ");
        bondsPercent = in.nextDouble();
        System.out.println("Enter amount of money your parents spend in buying additional savings bonds: ");
        parentBondsPercent = in.nextDouble();

        /*
        * Computation of expenses wherein the given prompt percentage will be converted to decimal then
        * multiplied by the net income to find the total amount of money this spent in that area of
        * expense
        * */

        clothesAccessoriesPercent = netIncome * (clothesAccessoriesPercent / 100);
        schoolSuppliesPercent = netIncome * (schoolSuppliesPercent / 100);
        bondsPercent = netIncome * (bondsPercent / 100);

        // Sums all expenses then subtracts it to the net income which then results to the remaining money left
        netIncomeAfter = netIncome - (clothesAccessoriesPercent + schoolSuppliesPercent + bondsPercent + parentBondsPercent);

        // Output of expenses
        System.out.println("Money spent in different areas of expenses\n");

        System.out.printf("Clothes and accessories: %.2f\n", clothesAccessoriesPercent);
        System.out.printf("School supplies: %.2f\n", schoolSuppliesPercent);
        System.out.printf("Savings bonds: %.2f\n", bondsPercent);
        System.out.print("Parent's savings bonds: " + parentBondsPercent + "\n");

        // Outputs net income after expenses
        System.out.printf("Net income after expenses: %.2f\n", netIncomeAfter);
    }
}
