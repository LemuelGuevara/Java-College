/*
* This program will compute the grade n students
* */

package LoopMethodGrade;

import java.util.*;

public class LoopMethodGrade
{
    static Scanner in = new Scanner(System.in);

    // Checks if input score is valid
    static double validateScoreInput()
    {
        double score;

        for(score = in.nextDouble(); score < 0 || score > 100; score = in.nextDouble())
            System.out.print("Invalid grade, grade is from 0-100, input again :");

        return score;
    }

    // Evaluates prelim grade
    static String evalGrade(double prelimGrade)
    {
        double equivalentGrade;
        String remarks;

        if (prelimGrade < 60)
        {
            equivalentGrade = 5.0;
            remarks = "Failed";
        }
        else if (prelimGrade < 76)
        {
            equivalentGrade = 3.0;
            remarks = "Fair";
        }
        else if (prelimGrade < 90)
        {
            equivalentGrade = 2.0;
            remarks = "Good";
        }
        else
        {
            equivalentGrade = 1.0;
            remarks = "Very Good";
        }

        return "Equivalent Grade: " + equivalentGrade + "\n" + "Remarks: " + remarks;
    }

    // Gets the quiz scores and average
    static double getQuizScore()
    {
        double quizScore, quizN, quizSum = 0, quizAverage;

        System.out.println("\n---Quiz Scores---\n");
        System.out.println("#Input number of quizzes#");
        quizN = in.nextDouble();

        for (int i = 1; i <= quizN; i++)
        {
            System.out.print("Input quiz score for quiz " + i + ": ");
            quizScore = validateScoreInput();
            quizSum += quizScore;
        }

        quizAverage = quizSum / quizN;

        return quizAverage;
    }

    // Gets the machine problem scores and average
    static double getMachineProblemScore()
    {
        double machineProbScore, machineProbN, machineProbSum = 0, machineProbAverage;

        System.out.println("\n---Machine Problem Scores---\n");
        System.out.println("#Input number of machine problems#");
        machineProbN = in.nextDouble();

        for (int i = 1; i <= machineProbN; i++)
        {
            System.out.print("Input machine problem score for machine problem " + i + ": ");
            machineProbScore = validateScoreInput();
            machineProbSum += machineProbScore;
        }

        machineProbAverage = machineProbSum / machineProbN;

        return machineProbAverage;
    }

    // Gets major exame score and percentage score
    static double getMajorExameScore()
    {
        double majorExamScore;

        System.out.println("\n---Major Exam Score---\n");
        System.out.print("Input score of major exam: ");
        majorExamScore = in.nextDouble();

        return majorExamScore;
    }

    static double getMajorFinals()
    {
        double majorExamScore;

        System.out.println("\n---Major Final Score---\n");
        System.out.print("Input score of major exam: ");
        majorExamScore = in.nextDouble();

        return majorExamScore;
    }
    
    // Computes for the total prelim grade
    static double getPrelimGrade()
    {
        double prelimGrade, percentageQuiz, percentageMachineProb, percentageMajorExam;
        double percentageMajorFinals;

        // Percentage score for each assessment
        percentageQuiz = getQuizScore() * .30;
        percentageMachineProb = getMachineProblemScore() * .30;
        percentageMajorExam = getMajorExameScore();
        percentageMajorFinals = getMajorFinals();

        prelimGrade = percentageQuiz + percentageMachineProb + ((percentageMajorExam + percentageMajorFinals) / 2) * .40;

        return prelimGrade;
    }

    public static void main(String[] args)
    {
        double n, prelims;
        String gradeRemarks;

        // Program description prompt
        System.out.println("This program will compute the grade n students\n");

        do
        {
            System.out.println("Input number of students (type 0 to exit):");
            n = in.nextDouble();

            for (int studentN = 1; studentN <= n; studentN++)
            {
                System.out.println("\nInput scores of student " + studentN + ":");
                // Gets prelims
                prelims = getPrelimGrade();

                System.out.println("\n");

                System.out.println("\n-----Student " + studentN + "-----\n");
                System.out.println("Prelim Grade: " + prelims);

                // Gets the equivalent grade and remarks
                gradeRemarks = evalGrade(prelims);

                System.out.println(gradeRemarks);
                System.out.println("\n-----Student " + studentN + "-----\n");
            }
        } while (n != 0);
    }
}
