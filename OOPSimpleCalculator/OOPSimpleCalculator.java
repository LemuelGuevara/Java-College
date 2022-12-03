/*
* This program is a simple calculator program the uses OOP concepts such as encapsulation
* */

package OOPSimpleCalculator;

import java.util.Scanner;

import static java.lang.Math.*;

class MathFunctions
{
    Scanner in = new Scanner(System.in);

    private double integer, integerA, integerB;
    private final char FUNCTION_CHOICE;

    public MathFunctions(char FUNCTION_CHOICE, double integer)
    {
        this.FUNCTION_CHOICE = FUNCTION_CHOICE;
        this.integer = integer;
    }

    public MathFunctions(char FUNCTION_CHOICE, double integerA, double integerB)
    {
        this.FUNCTION_CHOICE = FUNCTION_CHOICE;
        this.integerA = integerA;
        this.integerB = integerB;
    }

    public double add()
    {
        return integerA + integerB;
    }

    public double subtract()
    {
        return integerA - integerB;
    }

    public double multiply()
    {
        return integerA * integerB;
    }

    public double divide()
    {
        return integerA / integerB;
    }

    public double powerInteger(int exponent)
    {
        return pow(integer, exponent);
    }

    public double nthRoot(int exponent)
    {
        return pow(integer, 1.0 / exponent);
    }

    public double sinAngle()
    {
        return sin(toRadians(integer));
    }

    public double cosAngle()
    {
        return cos(toRadians(integer));
    }

    public double tanAngle()
    {
        return tan(toRadians(integer));
    }

    public double getMathFunction()
    {
        double mathFunction = 0;

        switch (FUNCTION_CHOICE)
        {
            case 'A': mathFunction = add();
                break;
            case 'B': mathFunction = subtract();
                break;
            case 'C': mathFunction = multiply();
                break;
            case 'D': mathFunction = divide();
                break;
            case 'E':
                int exponent = in.nextInt();

                mathFunction = powerInteger(exponent);
                break;
            case 'F':
                int nthExponent = in.nextInt();
                mathFunction = nthRoot(nthExponent);
                break;
            case 'G': mathFunction = sinAngle();
                break;
            case 'H': mathFunction = cosAngle();
                break;
            case 'I': mathFunction = tanAngle();
                break;
        }

        return mathFunction;
    }
}

public class OOPSimpleCalculator
{
    public static boolean isArithmetic(int choiceInput)
    {
        boolean isArithmeticFunction = false;

        if (choiceInput == 0)
            isArithmeticFunction = true;
        else if (choiceInput == 1)
            return false;

        return isArithmeticFunction;
    }

    public static boolean checkContinuity(char choice)
    {
        boolean isContinuity = false;

        if (choice == 'Y')
            isContinuity = true;
        else if (choice == 'N')
            return false;

        return isContinuity;
    }

    public static void printFunctionChoices()
    {
        System.out.println("\n---ARITHMETIC FUNCTIONS---" +
                "\nA - Addition" + "\nB - Subtraction" + "\nC - Multiplication" + "\nD - Division" +
                "\n---NON-ARITHMETIC FUNCTIONS---" +
                "\nE - Exponent" + "\nF - nth-Root" + "\nG - Sine" + "\nH - Cosine" + "\nI - Tangent");
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int choiceInput;
        char functionChoice, continuityChoice;
        boolean isContinuous;

        do
        {
            printFunctionChoices();

            System.out.print("\nPress (0) for arithmetic functions if not press (1): ");
            choiceInput = in.nextInt();

            if (!(choiceInput == 0 || choiceInput == 1))
            {
                System.out.println("Invalid choice.");
                System.exit(0);
            }

            if (isArithmetic(choiceInput))
            {
                System.out.println("\nA - Addition" + "\nB - Subtraction" + "\nC - Multiplication" + "\nD - Division");

                double integerA, integerB;

                functionChoice = in.next().charAt(0);
                functionChoice = Character.toUpperCase(functionChoice);

                System.out.print("\nEnter integer (a) and integer (b): ");
                integerA = in.nextDouble();
                integerB = in.nextDouble();

                MathFunctions arithmeticFunctions = new MathFunctions(functionChoice, integerA, integerB);
                System.out.printf("%.2f", arithmeticFunctions.getMathFunction());
            }
            else
            {
                System.out.println("\nE - Exponent" + "\nF - nth-Root" + "\nG - Sine" + "\nH - Cosine" + "\nI - Tangent");

                double integer;

                functionChoice = in.next().charAt(0);
                functionChoice = Character.toUpperCase(functionChoice);

                System.out.print("Enter integer: ");
                integer = in.nextDouble();

                MathFunctions arithmeticFunctions = new MathFunctions(functionChoice, integer);
                System.out.printf("%.2f", arithmeticFunctions.getMathFunction());
            }

            System.out.println("\nType (y) to continue, type (n) to stop: ");
            continuityChoice = in.next().charAt(0);
            continuityChoice = Character.toUpperCase(continuityChoice);

            isContinuous = checkContinuity(continuityChoice);

        } while (isContinuous);
    }
}
