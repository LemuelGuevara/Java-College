package Arrays1D;

import java.util.*;

public class Array1DClassAve
{
    static Scanner in = new Scanner(System.in);
    static final double highestMean = 100 * .90;

    // Get valid score
    static double getValidScore()
    {
        double score;

        for (score = in.nextDouble(); score < 0 || score > 100; score = in.nextDouble())
            System.out.println("Please enter a valid score.");

        return score;
    }

    // Validate number of students
    static int getValidNumStudents()
    {
        int n;

        System.out.print("\nEnter number of students: ");
        n = in.nextInt();

        if (n > 50)
        {
            System.out.println("Max number of students is only 50.");
            System.exit(0);
        }

        return n;
    }

    // Gets class average
    static double getAverage(double[] scores)
    {
        double sum = 0, average;
        int n = scores.length;

        for (double score : scores)
            sum += score;

        average = sum / n;

        return average;
    }

    // Gets the highest scores and names of the students
    static int getHighestScoresCount(double[] scores)
    {
        int highScoreCtr = 0;

        for (double scoreElement: scores)
        {
            if (scoreElement >= highestMean)
                highScoreCtr++; // Counts all high scores
        }

        return highScoreCtr;
    }

    // Prints the highest scores along with the names of the students
    static void printHighestScores(String[] students, double[] scores, int[] studentId, int highScoreCount)
    {
        int size = students.length;
        int score, index = 0;

        // Arrays for the high scores
        double[] highestScores = new double[highScoreCount];
        int[] highestStudentsId = new int[highScoreCount];
        String[] highestStudents = new String[highScoreCount];

        for (int i = 0; i < size; i++)
        {
            // Score element in the array
            score = (int) scores[i];

            // Only gets the elements in the array that is higher than the highest mean score
            if (score >= highestMean)
            {
                ++index;

                int temp = (int) scores[i]; // Temporarily stores element here
                int scoreIndex = index; // sets the index to the index in the new array
                scoreIndex -= 1; // Makes the index not go out of bounds

                // Prevents duplication of index
                if (scoreIndex == index)
                    scoreIndex += 1;

                // Indices of the high scores with students name and id
                highestScores[scoreIndex] = temp;
                highestStudentsId[scoreIndex] = studentId[i];
                highestStudents[scoreIndex] = students[i];
            }
        }
        System.out.println("ID" + "\t" + "NAME" + "\t" + "SCORE");

        for (int i = 0; i < highestScores.length; i++)
            System.out.println(highestStudentsId[i] + "\t" + highestStudents[i] + " \t" + highestScores[i]);
    }

    // Prints all input scores
    static void printScores(String[] students, double[] scores, int[] studentId, int size)
    {
        System.out.println("ID" + "\t" + "NAME" + "\t" + "SCORE");
        for (int i = 0; i < size; i++)
            System.out.println(studentId[i] + "\t" + students[i] + " \t"  + scores[i]);
    }

    public static void main(String[] args)
    {
        // Variables
        final int size;
        int highScoreCount;
        size = getValidNumStudents();

        String[] studentNames = new String[size];
        int[] studentId = new int[size];
        double[] scores = new double[size];

        // Gets input from user
        for (int i = 0; i < size; i++)
        {
            System.out.println("|Student " + (i + 1) + "|");
            studentId[i] = i + 1;
            {
                System.out.print("Enter student name: ");
                studentNames[i] = in.next();

                System.out.print("Enter student score: ");
                scores[i] = getValidScore();
            }
        }

        // Outputs
        System.out.println("\nClass Average: " + getAverage(scores));

        System.out.println("\nStudents and their scores:");
        printScores(studentNames, scores, studentId, size);

        System.out.println("\nStudents with the highest score:");
        highScoreCount = getHighestScoresCount(scores);
        printHighestScores(studentNames, scores, studentId, highScoreCount);
    }
}
