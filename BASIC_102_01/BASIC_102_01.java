

/**
 * BASIC_102_01
 */
public class BASIC_102_01 {

    // Main method for running the program
    public static void main(String[] args) 
    {   
        // A list of string of the given info 
        String[] infos={ "\n*\tProgramming Assignment 1\t*", "*\tComputer Programming 1\t\t*", "*\tAuthor: Duffy Ducky\t\t*", 
        "*\tDue Date: Thursday, Jan.24\t*"};
        
        // Calls the method generateAterisks
        generateAsterisk();

        // Prints the given output of the string list wherein [0] is the position of the object in the array
        for (String info: infos) 
        {
            System.out.println(info);
        }

        generateAsterisk();
        // System.out.println("\n" + "*\t" + infos[0] + "\t*");
        // System.out.println("*\t" + infos[1] + "\t\t*");
        // System.out.println("*\t" + infos[2] + "\t\t*");
        // System.out.println("*\t" + infos[3] + "\t*");
    }

     // Method that makes a for loop to duplicate the character asterisk 
    public static void generateAsterisk() 
     {
         char asterisk='*';
 
         for (int n=0; n<41; n++) 
        {   
             System.out.print(asterisk);
        }
     }

}
