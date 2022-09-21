package Test;
import static java.lang.Math.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {

        //Declaring a variable for switch expression
        int year = 3;
        int marks = 80;
        switch(year) //Switch expression
        {
            //Case statements
            case 1:
                System.out.println("First year students are not eligible for scholarship ");
                break;
            case 2:
                System.out.println("Second year students are not eligible for scholarship");
                break;
            case 3:
                switch(marks)
                {
                    case 50:
                        System.out.println("You are not eligible for scholarship");
                        break;
                    case 80:
                        System.out.println("Congrats!!!!! you are eligible for scholarship");
                        break;
                }
                break;
            //Default case statement
            default: System.out.println("Please enter valid year");
        }

//        int a = 1;
//
//        int [][] integers = {
//                {3, 5, 7},
//                {10, 2, 9},
//                {1, 3, 5}
//        };
//
//        for (int i = 1; i < 3; i++)
//        {
//            for (int j = 1; j < integers[i].length; j++)
//            {
//                System.out.print(integers[i][j] + " ");
//
//                if (i == j)
//                {
//                    a *= integers[j][i];
//                }
//            }
//
//            System.out.println();
//        }
//        System.out.println(a);
    }
}
