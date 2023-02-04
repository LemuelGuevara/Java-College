/*
* Name: Guevara, Lemuel John
* Section: 1CSD
*
* Program: This program counts a paying and a non-paying car
*           which also counts the total money collected
* */

package OOP;

import java.util.*;

class TollBooth
{
    int totalCars;
    double totalMoney, tollFee;

    // Constructors that initializes total cars and money to 0
    TollBooth(double tollFee)
    {
        this.totalCars = 0;
        this.totalMoney = 0;
        this.tollFee = tollFee;
    }

    // Adds 1 to the total cars but adds 0.50
    public void payingCar()
    {
        totalCars += 1;
        totalMoney += tollFee;
    }

    // Adds 1 to the total cars but does not add money
    public void nonPayingCar()
    {
        totalCars += 1;
    }

    // Displays the results
    public void display()
    {
        System.out.println("\nTotal cars: " + totalCars);
        System.out.println("Toll fee: " + totalMoney);
    }
}

public class OOPTollBooth
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        char userInput;
        double tollFee;

        // Program description
        System.out.println("\nThis program counts a paying and a non-paying car " +
                "which also counts the total money collected");

        System.out.print("\nEnter a toll fee for a passing car: ");
        tollFee = in.nextDouble();
        TollBooth toll = new TollBooth(tollFee);

        // Input choices
        System.out.println("\nChoices: ");
        System.out.println("(P) to count a paying car\n" + "(N) to count a non-paying car");
        System.out.println("(Z) to end program and show results\n");
        System.out.println("Enter choice:");

        do
        {
            // Input
            userInput = in.next().charAt(0);
            userInput = Character.toUpperCase(userInput);

            // Eval of the choice input
            if (userInput == 'P')
                toll.payingCar();
            if (userInput == 'N')
                toll.nonPayingCar();

        } while (userInput != 'Z');

        // Results
        toll.display();
    }
}