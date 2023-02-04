package Arrays2D;

import java.util.*;

public class Arrays2D_AirplaneSeating
{
    static Scanner in = new Scanner(System.in);

    static final int SEAT_ROWS = 16;
    static final int SEAT_COLUMNS = 6;

    static char[][] airPlaneSeats = loadAirplaneSeatArray();
    static String[] seatLetters = {"A", "B", "C","D", "E", "F"};
    static String[] rowNumbers = new String[SEAT_ROWS];

    // Loads the array with the default character *
    public static char[][] loadAirplaneSeatArray()
    {
        char[][] seatArray = new char[SEAT_ROWS][SEAT_COLUMNS];

        for (int i = 0; i < SEAT_ROWS; i++)
            for (int j = 0; j < SEAT_COLUMNS; j++)
                seatArray[i][j] = '*';

        return seatArray;
    }

    // Prints the seat letters
    public static void showSeatLetters()
    {
        System.out.print("\t\t");
        for (int i = 0; i < seatLetters.length; i++)
        {
            System.out.print(seatLetters[i] + " ");
            if (i == 2)
                System.out.print("\t");
        }
        System.out.println();
    }

    // Loads the seating plan
    public static void showSeatingPlan()
    {
        showSeatLetters();

        for (int i = 0; i < SEAT_ROWS; i++)
        {
            rowNumbers[i] = "Row ";

            System.out.print(rowNumbers[i] + (i + 1)  + "\t");

            for (int j = 0; j < SEAT_COLUMNS; j++)
            {
                System.out.print(airPlaneSeats[i][j] + " ");

                if (j == 2)
                    System.out.print("\t");
            }
            System.out.println();
        }
    }

    // Displays the selected seat class that is chosen by the user
    public static void showSelectedClass(String selectedClass)
    {
        int startingRow = 0, endingRow = 0;
        String seatClass = "";

        if (selectedClass.equalsIgnoreCase("FC"))
        {
            startingRow = 1;
            endingRow = 2;
            seatClass = "FIRST CLASS";
        }
        if (selectedClass.equalsIgnoreCase("BC"))
        {
            startingRow = 3;
            endingRow = 7;
            seatClass = "BUSINESS CLASS";
        }
        if (selectedClass.equalsIgnoreCase("EC"))
        {
            startingRow = 8;
            endingRow = 13;
            seatClass = "ECONOMY CLASS";
        }

        System.out.println("\t --- " + seatClass + " ---");
        showSeatLetters();

        for (int i = startingRow - 1; i < endingRow; i++)
        {
            System.out.print(rowNumbers[i] + (i + 1)  + "\t");

            for (int j = 0; j < SEAT_COLUMNS; j++)
            {
                System.out.print(airPlaneSeats[i][j] + " ");

                if (j == 2)
                    System.out.print("\t");
            }
            System.out.println();
        }
    }

    // Sets the position of the seat and stores in the airPlaneSeats array
    public static void setSeatPosition(int seatRow, char seatLetter)
    {
        int seatLetterIndex = -1;

        for (int i = 0; i < seatLetters.length; i++)
            if (seatLetters[i].equals(Character.toString(seatLetter)))
            {
                seatLetterIndex = i;
                break;
            }

        airPlaneSeats[seatRow - 1][seatLetterIndex] = 'X';

        if (airPlaneSeats[seatRow - 1][seatLetterIndex] == 'X')
            System.out.println("Seat is occupied!\n");
    }

    // Checks if program will still continue then returns a boolean
    public static boolean checkContinuity(char choice)
    {
        boolean isContinuity = false;

        if (choice == 'Y')
            isContinuity = true;
        else if (choice == 'N')
            return false;

        return isContinuity;
    }

    public static void main(String[] args)
    {
        String inputChoice;
        int seatRow;
        char seatLetter, continuityChoice;

        boolean isContinuous;

        // Shows the initial seating plan
        System.out.println();
        showSeatingPlan();

        do
        {
            System.out.println("\nCHOICES:");
            System.out.println("FC - First Class\n" + "BC - Business Class\n" + "EC - Economy Class\n" + "S - Show Seating Plan\n");
            System.out.print("Input choice: ");
            inputChoice = in.next();
            inputChoice = inputChoice.toUpperCase();

            showSelectedClass(inputChoice);

            System.out.print("Select row and seat letter: ");
            seatRow = in.nextInt();
            seatLetter = in.next().charAt(0);
            seatLetter = Character.toUpperCase(seatLetter);
            System.out.println(seatLetter);

            setSeatPosition(seatRow, seatLetter);
            showSeatingPlan();

            // Asks if user wants to continue the program or not
            System.out.println("\nType (y) to continue, type (n) to stop: ");
            continuityChoice = in.next().charAt(0);
            continuityChoice = Character.toUpperCase(continuityChoice);

            isContinuous = checkContinuity(continuityChoice);

        } while (isContinuous);
    }
}
