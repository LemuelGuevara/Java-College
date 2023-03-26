package ExceptionHandling.ExceptionAveGrade;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class ExceptionConstructor extends RuntimeException
{
    // An abstract class that will create custom exception constructors that
    // extends the RuntimeException class

    ExceptionConstructor() {super();}
}

class NegativeIntException extends ExceptionConstructor
{
    // Custom exception class that extends the ExceptionConstructor
    // that takes not parameter in its constructor

    NegativeIntException() {super();}
}

interface ExceptionChecker
{
    // A default method that will ask for a valid integer that is only positive
    // and if it is not, it will then throw a custom exception called NegativeIntException
    default void checkIntegerPositive(double integer) throws NegativeIntException
    {
        if (integer < 0)
            throw new NegativeIntException();
    }

    // A default method that will as for a valid an array size that is only positive
    // and if it is not, it will throw the negativeArraySizeException
    default void checkArraySize(int arraySize) throws NegativeArraySizeException
    {
        if (arraySize < 0)
            throw new NegativeArraySizeException();
    }
}

enum ExceptionErrorMessages
{
    // Enums for creating exception error messages

    NUMERIC_ONLY_EXCEPTION("Input is not numeric"),
    NEGATIVE_INT_EXCEPTION("Integer is negative"),
    NEGATIVE_ARRAY_SIZE_EXCEPTION("Array size is negative");

    private final String errorMessage;

    ExceptionErrorMessages(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    private void errorMessageSeparator()
    {
        char separator = '=';
        int numberOfSeparators = 50;

        for (int i = 0; i < numberOfSeparators; i++)
            System.out.print(separator);
        System.out.println();
    }

    public void getErrorMessage(Exception e)
    {
        errorMessageSeparator();
        System.out.println("EXCEPTION CAUSE: " +  errorMessage + "\n" + "EXCEPTION: " + "[" + e + "]");
        errorMessageSeparator();
    }
}

class ValidInput implements ExceptionChecker
{
    /*
    * The class is responsible for making valid inputs wherein exceptions will be
    * implemented by using the ExceptionChecker interface
    * */

    static Scanner in = new Scanner(System.in);

    // A private method that will ask for an integer that is not negative and numeric only
    private double validInteger()
    {
        double integer = 0;

        try
        {
            integer = in.nextDouble();
        }
        catch (InputMismatchException e)
        {
            ExceptionErrorMessages.NUMERIC_ONLY_EXCEPTION.getErrorMessage(e);
            System.exit(0);
        }

        return integer;
    }

    // Asks for the number of grades to be input
    public int validNumberOfGradesInput()
    {
        int numberOfGrades = 0;

        try
        {
            numberOfGrades = (int) validInteger();
            checkArraySize(numberOfGrades);
        }
        catch (NegativeArraySizeException e)
        {
            ExceptionErrorMessages.NEGATIVE_ARRAY_SIZE_EXCEPTION.getErrorMessage(e);
            System.exit(0);
        }

        return numberOfGrades;
    }

    // Asks for a grade score that is within in range of 0 to 100 only
    public double validGradeInput()
    {
        double grade;

        for (grade = validInteger(); grade < 0 || grade > 100; grade = validInteger())
        {
            try
            {
                checkIntegerPositive(grade);
            }
            catch (NegativeIntException e)
            {
                ExceptionErrorMessages.NEGATIVE_INT_EXCEPTION.getErrorMessage(e);
            }
            System.out.print("Grade not within range. Please enter again: ");
        }

        return grade;
    }
}

class GradeCalculator
{
    /*
    * This class is responsible for solving the sum and average of the given grades
    * */

    private final double[] GRADE_ARRAY;

    // Constructor that will ask for an array of grades
    GradeCalculator(double[] gradeArray)
    {
        this.GRADE_ARRAY = gradeArray;
    }

    // A private method that get the sum of the array of grades
    private double getGradeSum()
    {
        double sum = 0;

        for (double x: GRADE_ARRAY)
            sum += x;

        return sum;
    }

    // Computes the average of the grades
    public double getGradeAverage()
    {
        return getGradeSum() / GRADE_ARRAY.length;
    }
}

public class ExceptionAveGrade
{
    static ValidInput validInput = new ValidInput();

    // Creates the grade array
    public static double[] getGradeArray(int numberOfGrades)
    {
        double[] gradeArray = new double[numberOfGrades];

        for (int i = 0; i < numberOfGrades; i++)
        {
            System.out.print("Grade " + (i + 1) + ": ");
            gradeArray[i] = validInput.validGradeInput();
        }

        return gradeArray;
    }

    public static void main(String[] args)
    {
        GradeCalculator gradeAverage;
        double[] gradeArray;
        int numberOfGrades;

        System.out.print("\nEnter number of grades: ");
        numberOfGrades = validInput.validNumberOfGradesInput();

        System.out.println("Enter grades: ");
        gradeArray = getGradeArray(numberOfGrades);
        gradeAverage = new GradeCalculator(gradeArray);

        System.out.println("Grades: " + Arrays.toString(gradeArray));
        System.out.print("Grade average: " + gradeAverage.getGradeAverage());
    }
}
