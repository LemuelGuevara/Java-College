package ExceptionHandling;

import java.util.*;
import java.util.InputMismatchException;

class ExceptionHandlers
{
    /*
     * This is a class that is composed mainly of functions that handle exceptions
     * */

    private final String INTEGER_ERROR_LOG = "Integer should be only numeric and positive";

    // Function that gets a valid integer then validates
    public int validIntegerInput()
    {
        Scanner integerInput = new Scanner(System.in);
        int userInput = 0;

        try
        {
            userInput = integerInput.nextInt();

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
}

class ArrayFactory
{
    /*
     * This is class is responsible for initializing for an array
     * */

    private final int ARRAY_SIZE;
    private final int[] ARRAY;

    ArrayFactory(int arraySize)
    {
        this.ARRAY_SIZE = arraySize;
        this.ARRAY = initializeArray();
    }

    // Inits an array with random integers ranging from 1 to 100
    private int[] initializeArray()
    {
        Random rand = new Random();
        int[] array = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++)
            array[i] = rand.nextInt(1, 99);

        return array;
    }

    public int[] getArray() {return ARRAY;}

    @Override
    public String toString()
    {
        return Arrays.toString(ARRAY);
    }
}

class CopyArray
{
    /*
    * This classed is constructed in order to have a separate class for copying the array
    * where a constructor is made for the sake of recycling
    * */

    private final int[] arrayA, arrayB;
    private final int elementSize;
    private final int arrayAStartIndex;
    private int arrayBStartIndex;

    CopyArray(ArrayFactory arrayA, ArrayFactory arrayB, int elementSize, int arrayAStartIndex, int arrayBStartIndex)
    {
        this.arrayA = arrayA.getArray();
        this.arrayB = arrayB.getArray();
        this.elementSize = elementSize;
        this.arrayAStartIndex = arrayAStartIndex;
        this.arrayBStartIndex = arrayBStartIndex;
    }

    // Copies the array A elements to array B
    public int[] copyArray()
    {
        int[] arrayC = arrayB;

        try
        {
            for (int i = arrayAStartIndex; i < elementSize; i++)
                arrayC[arrayBStartIndex++] = arrayA[i];
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("I am so sorry but the index is sadly out of bounds");
            System.exit(0);
        }

        return arrayC;
    }

    @Override
    public String toString() {
        return Arrays.toString(copyArray());
    }
}

public class ExceptionCopyArray
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ExceptionHandlers exceptionHandlers = new ExceptionHandlers();
        CopyArray copiedArray;

        int arrayASize, arrayBSize, elementsSize, arrayAStartIndex, arrayBStartIndex;

        System.out.println("\nThis program will copy a range of elements from array A to array B.");

        System.out.print("\nEnter size of array A: ");
        arrayASize = in.nextInt();
        System.out.print("Enter size of array B: ");
        arrayBSize = in.nextInt();

        ArrayFactory arrayA = new ArrayFactory(arrayASize);
        ArrayFactory arrayB = new ArrayFactory(arrayBSize);

        System.out.println("Array A: " + arrayA + "\nArray B: " + arrayB);

        System.out.print("Enter number of elements to be copied: ");
        elementsSize = exceptionHandlers.validIntegerInput();
        System.out.print("Enter starting index of Array A: ");
        arrayAStartIndex = exceptionHandlers.validIntegerInput();
        System.out.print("Enter starting index of Array B: ");
        arrayBStartIndex = exceptionHandlers.validIntegerInput();

        copiedArray = new CopyArray(arrayA, arrayB, elementsSize, arrayAStartIndex, arrayBStartIndex);

        System.out.println("Copied array: " + copiedArray);
    }
}
