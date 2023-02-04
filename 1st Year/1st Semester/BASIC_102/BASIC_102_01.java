package BASIC_102;

/**
 * BASIC_102_01
 */

public class BASIC_102_01
{
    // Main method for running the program
    public static void main(String[] args) 
    {   
        // A list of string of the given info 
        String[] info={ "\n*\tProgramming Assignment 1\t*", "*\tComputer Programming 1\t\t*", "*\tAuthor: Duffy Ducky\t\t\t*",
        "*\tDue Date: Thursday, Jan.24\t*"};
        
        // Calls the method generateAterisks
        generateAsterisk();

        // Prints the given output of the string list wherein [0] is the position of the object in the array
        for (String inf: info)
        {
            System.out.println(inf);
        }

        generateAsterisk();
    }

     // Method that makes a for loop to duplicate the character asterisk 
    public static void generateAsterisk()
     {
         char asterisk='*';
 
         for (int n=0; n<33; n++)
        {   
             System.out.print(asterisk);
        }
     }

}
