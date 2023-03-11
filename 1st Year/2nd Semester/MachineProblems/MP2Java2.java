/*
 * Name: Guevara, Lemuel John D.
 * Section: 1CSD
 * */

package MachineProblems;

import java.util.InputMismatchException;
import java.util.Scanner;

// Enums for getting unit information such as areas and rates
enum UnitInformation
{
    // The unit areas
    ONE_BEDROOM(30), TWO_BEDROOMS(65), THREE_BEDROOMS(96),
    // The rates of the units
    ONE_BEDROOM_LESSE(89.50), TWO_BEDROOM_LESSE(95.75), THREE_BEDROOM_LESSE(102.80),
    ONE_BEDROOM_OWNER(85.75), TWO_BEDROOM_OWNER(89.50), THREE_BEDROOM_OWNER(93.25);

    private final double value;

    UnitInformation(final double unitInformation) {value = unitInformation;}
    public double getUnitArea() {return value;}
}

// Interface that calculates the dues
interface AssociationDueCalculator
{
    double getTotalArea(double unitArea);
    double getMonthlyAssoctDues(double totalArea, double unitRate);
}

// Interface for storing error logs
interface ExceptionErrorLogs
{
    final String INTEGER_ERROR_LOG = "Integer should be only numeric and positive";
    final String CHAR_ERROR_LOG = "Char should not be numeric";
}

// A class made for exception handling values
class ExceptionHandlers implements ExceptionErrorLogs
{
    static Scanner in = new Scanner(System.in);
    ExceptionHandlers() {}

    // Function that gets a valid integer then validates
    public int validIntegerInput()
    {
        int userInput = 0;

        try
        {
            userInput = in.nextInt();

            if (userInput < 0)
            {
                System.out.println(INTEGER_ERROR_LOG);
                System.exit(0);
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println(INTEGER_ERROR_LOG);
            System.exit(0);
        }

        return userInput;
    }

    public char validCharInput()
    {
        char charInput = ' ';

        try
        {
            charInput = in.next().charAt(0);

            if (Character.isDigit(charInput))
            {
                System.out.println("Your input should a character");
                System.exit(0);
            }
        }
        catch (RuntimeException e)
        {
            System.out.println(CHAR_ERROR_LOG);
            System.exit(0);
        }

        return charInput;
    }
}

// The class responsible for getting the dues and displaying it
class UnitDues implements AssociationDueCalculator
{
    private final double PARKING_AREA_SPACE = 12.5;
    protected int unitType, numberOfParking;
    protected final char occupantType, paymentOption;

    UnitDues(int unitType, char occupantType, int numberOfParking, char paymentOption)
    {
        this.unitType = unitType;
        this.occupantType = occupantType;
        this.numberOfParking = numberOfParking;
        this.paymentOption = paymentOption;
    }

    // Gets the total area
    @Override
    public double getTotalArea(double unitArea) {
        double totalArea;

        totalArea = (numberOfParking * PARKING_AREA_SPACE) + unitArea;

        return totalArea;
    }

    // Gets the monthly association dues
    @Override
    public double getMonthlyAssoctDues(double totalArea, double unitRate)
    {
        return totalArea * unitRate;
    }

    // Evaluates the choice of the user
    public void evaluateChoice()
    {
        double unitArea = 0, unitRate = 0, totalArea, monthlyDue = 0, yearlyDue;

        // Switch case for getting the unit type and its details
        switch (unitType)
        {
            case 1:
                unitArea = UnitInformation.ONE_BEDROOM.getUnitArea();

                if (occupantType == 'L')
                    unitRate = UnitInformation.ONE_BEDROOM_LESSE.getUnitArea();
                if (occupantType == 'O')
                    unitRate = UnitInformation.ONE_BEDROOM_OWNER.getUnitArea();
                break;
            case 2:
                unitArea = UnitInformation.TWO_BEDROOMS.getUnitArea();

                if (occupantType == 'L')
                    unitRate = UnitInformation.TWO_BEDROOM_LESSE.getUnitArea();
                if (occupantType == 'O')
                    unitRate = UnitInformation.TWO_BEDROOM_OWNER.getUnitArea();
                break;
            case 3:
                unitArea = UnitInformation.THREE_BEDROOMS.getUnitArea();

                if (occupantType == 'L')
                    unitRate = UnitInformation.THREE_BEDROOM_LESSE.getUnitArea();
                if (occupantType == 'O')
                    unitRate = UnitInformation.THREE_BEDROOM_OWNER.getUnitArea();
                break;
        }

        // Computes the dues
        totalArea = getTotalArea(unitArea);
        monthlyDue = getMonthlyAssoctDues(totalArea, unitRate);
        yearlyDue = monthlyDue * 11;

        // Shows the due details
        System.out.println("\nUnity Type: " + unitType + "-Bedroom");

        if (occupantType == 'L')
            System.out.println("Occupant Type: Lesse");
        if (occupantType == 'O')
            System.out.println("Occupant Type: Owner");
        System.out.println("Number of Parking: " + numberOfParking);

        if (paymentOption == 'M')
        {
            System.out.println("Payment Option: Monthly");
            System.out.printf("Total Due: %.2f", monthlyDue);
        }
        if (paymentOption == 'Y')
        {
            System.out.println("Payment Option: Yearly");
            System.out.printf("Total Due: %.2f", yearlyDue);
        }
        System.out.println();
    }
}

public class MP2Java2
{
    static Scanner in = new Scanner(System.in);
    static ExceptionHandlers validInput = new ExceptionHandlers();

    // Checks if the number of parking space is within range
    public static int validChoiceRange()
    {
        int numberOfParking;

        for(numberOfParking = validInput.validIntegerInput(); numberOfParking < 0 || numberOfParking > 3; numberOfParking = validInput.validIntegerInput())
            System.out.print("Input is not from any of the choices, please input again:");

        return numberOfParking;
    }

    // Checks if the program is continuous
    public static boolean isContinuous(char userChoice)
    {
        boolean isContinuity = false;

        if (userChoice == 'Y')
            isContinuity = true;

        return isContinuity;
    }

    public static void main(String[] args)
    {
        UnitDues unitDues;
        int unitType, numberOfParking;
        char occupantType, paymentOption, userChoice;

        do
        {
            System.out.println("\nThis program will calculate the association dues(AD) an occupant(Owner or Lessee) has to pay");
            System.out.println("Enter unit type (1-Bedroom, 2-Bedroom, 3-Bedroom):");
            unitType = validChoiceRange();
            System.out.println("Enter occupant Type (L-Lesse, O-Owner): ");
            occupantType = validInput.validCharInput();
            occupantType = Character.toUpperCase(occupantType);
            System.out.println("Enter number of parking (Max is 3):");
            numberOfParking = validChoiceRange();
            System.out.println("Enter payment option (M - Monthly, Y - Yearly: ");
            paymentOption = validInput.validCharInput();
            paymentOption = Character.toUpperCase(paymentOption);

            unitDues = new UnitDues(unitType, occupantType, numberOfParking, paymentOption);
            unitDues.evaluateChoice();

            // Asks the user if they still want to continue the program
            System.out.println("\nPress Y to continue and press any other key to stop.");
            userChoice = in.next().charAt(0);
            userChoice = Character.toUpperCase(userChoice);

        } while (isContinuous(userChoice));
    }
}
