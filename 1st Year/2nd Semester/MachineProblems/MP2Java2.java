/*
 * Name: Guevara, Lemuel John D.
 * Section: 1CSD
 * */

package MachineProblems;

import java.util.InputMismatchException;
import java.util.Scanner;

// Enums for getting unit information such as areas and rates
enum UnitEnums
{
    // BEDROOM-COUNT_BEDROOM(unitArea, leseUnitRate, ownerUnitRate)

    // The unit areas
    ONE_BEDROOM("1-Bedroom", 30, 89.50, 85.75, 1),
    TWO_BEDROOM("2-Bedroom",65, 95.75, 89.50, 2),
    THREE_BEDROOM("3-Bedroom",96, 102.80, 93.25, 3);

    private final double unitArea, lesseUnitRate, ownerUnitRate;
    private final int numberOfParking;
    private final String unitType;

    UnitEnums(String unitType, double unitArea, double lesseUnitRate, double ownerUnitRate, int numberOfParking)
    {
        this.unitType = unitType;
        this.unitArea = unitArea;
        this.lesseUnitRate = lesseUnitRate;
        this.ownerUnitRate = ownerUnitRate;
        this.numberOfParking = numberOfParking;
    }

    public double getUnitAreaEnum() {return unitArea;}
    public double getLesseUnitRateEnum() {return lesseUnitRate;}
    public double getOwnerUnitRateEnum() {return ownerUnitRate;}
    public int getNumberOfParkingEnum() {return numberOfParking;}
    public String getUnitTypeEnum() {return unitType;}
}

// Interface for storing error logs
interface ExceptionErrorLogs
{
    String INTEGER_ERROR_LOG = "Integer should be only numeric and positive";
    String CHAR_ERROR_LOG = "Char should not be numeric";
}

// A class made for exception handling values
class ExceptionHandlers implements ExceptionErrorLogs
{
    static Scanner in = new Scanner(System.in);
    ExceptionHandlers() {}

    private void exceptionErrorLog(String errorType)
    {
        System.out.println(errorType);
        System.exit(0);
    }

    // Function that gets a valid integer then validates
    public int validIntegerInput()
    {
        int userInput = 0;

        try
        {
            userInput = in.nextInt();

            if (userInput < 0)
            {
                exceptionErrorLog(INTEGER_ERROR_LOG);
            }
        }
        catch (InputMismatchException e)
        {
            exceptionErrorLog(INTEGER_ERROR_LOG);
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
                exceptionErrorLog(CHAR_ERROR_LOG);
        }
        catch (RuntimeException e)
        {
           exceptionErrorLog(CHAR_ERROR_LOG);
        }

        return Character.toUpperCase(charInput);
    }
}

class UnitInformation
{
    static ExceptionHandlers validInput = new ExceptionHandlers();

    private UnitEnums unitTypeEnum;
    protected char occupantType, paymentOption;
    protected int numberOfParking;

    UnitInformation(char unitType, char occupantType, int numberOfParking, char paymentOption)
    {
        switch (unitType)
        {
            case 'A': this.unitTypeEnum = UnitEnums.ONE_BEDROOM; break;
            case 'B': this.unitTypeEnum = UnitEnums.TWO_BEDROOM; break;
            case 'C': this.unitTypeEnum = UnitEnums.THREE_BEDROOM; break;
        }

        this.occupantType = occupantType;
        this.numberOfParking = numberOfParking;
        this.paymentOption = paymentOption;
    }

    public String getUnitType()
    {
        return unitTypeEnum.getUnitTypeEnum();
    }

    public double getUnitArea()
    {
        return unitTypeEnum.getUnitAreaEnum();
    }

    public double getUnitRate()
    {
        double unitRate = 0;

        if (occupantType == 'L')
            unitRate = unitTypeEnum.getLesseUnitRateEnum();
        if (occupantType == 'O')
            unitRate = unitTypeEnum.getOwnerUnitRateEnum();

        return unitRate;
    }

    public double getUnitNumberOfParking()
    {
        String PARKING_SPACES_ERROR_LOG = "You have reached the maximum number of parking spaces. Please input again:";

        /*for (numberOfParking = validInput.validIntegerInput(); numberOfParking != unitTypeEnum.getNumberOfParking();
             numberOfParking = validInput.validIntegerInput())
            System.out.println(PARKING_SPACES_ERROR_LOG);
         */

        return numberOfParking;
    }

    public char getPaymentOption()
    {
        return paymentOption;
    }
}

class UnitDueCalculator
{
    UnitInformation unitInformation;

    private double totalArea, monthlyDue, yearlyDue;

    UnitDueCalculator(UnitInformation unitInformation)
    {
        this.unitInformation = unitInformation;
    }

    // Gets the total area
    public void getTotalArea()
    {
        double parkingAreaSpace = 12.5;

        totalArea = (unitInformation.getUnitNumberOfParking() * parkingAreaSpace) + unitInformation.getUnitArea();
    }

    // Gets the monthly association dues

    public void getMonthlyDues()
    {
        monthlyDue = totalArea * unitInformation.getUnitRate();
    }

    public void getYearlyDues()
    {
        yearlyDue = monthlyDue * 11;
    }

    public double getTotalDue()
    {
        double totalDue = 0;

        getTotalArea();
        getMonthlyDues();
        getYearlyDues();

        if (unitInformation.getPaymentOption() == 'M')
            totalDue = monthlyDue;
        if (unitInformation.getPaymentOption() == 'Y')
            totalDue = yearlyDue;

        return totalDue;
    }
}

class UnitPaymentDetails extends UnitDueCalculator
{
    UnitPaymentDetails(UnitInformation unitInformation)
    {
        super(unitInformation);
    }

    public void showPaymentDetails()
    {
        // Shows the due details
        System.out.println("\nUnity Type: " + unitInformation.getUnitType());

        if (unitInformation.occupantType == 'L')
            System.out.println("Occupant Type: Lesse");
        if (unitInformation.occupantType == 'O')
            System.out.println("Occupant Type: Owner");

        System.out.println("Number of Parking: " + unitInformation.numberOfParking);
        System.out.println("Total Due: " + getTotalDue());
    }
}

public class MP2Java2
{
    // Checks if the program is continuous
    public static boolean isContinuous(char userChoice)
    {
        boolean isContinuity = userChoice == 'Y';

        return isContinuity;
    }

    public static void main(String[] args)
    {
        ExceptionHandlers validInput = new ExceptionHandlers();
        UnitInformation unitInformation;
        UnitPaymentDetails unitPaymentDetails;

        int numberOfParking;
        char unitType, occupantType, paymentOption, userChoice;

        do
        {
            System.out.println("\nThis program will calculate the association dues(AD) an occupant(Owner or Lessee) has to pay");
            System.out.println("Enter unit type (A = 1-Bedroom, B = 2-Bedroom, C = 3-Bedroom):");
            unitType = validInput.validCharInput();

            System.out.println("Enter occupant Type (L-Lesse, O-Owner): ");
            occupantType = validInput.validCharInput();

            System.out.println("Enter number of parking (Max is 3):");
            numberOfParking = validInput.validIntegerInput();

            System.out.println("Enter payment option (M - Monthly, Y - Yearly: ");
            paymentOption = validInput.validCharInput();
            paymentOption = Character.toUpperCase(paymentOption);

            unitInformation = new UnitInformation(unitType, occupantType, numberOfParking, paymentOption);
            unitPaymentDetails = new UnitPaymentDetails(unitInformation);
            unitPaymentDetails.showPaymentDetails();

            // Asks the user if they still want to continue the program
            System.out.println("\nPress Y to continue and press any other key to stop.");
            userChoice = validInput.validCharInput();
            userChoice = Character.toUpperCase(userChoice);

        } while (isContinuous(userChoice));
    }
}
