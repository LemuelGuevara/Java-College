/*
* This program gets strings first and last name of a user then displays their initials,
* name in the address book, and username
* Example: "J.S", "John SMITH", "jsmith"
* */

package StringName;
import java.util.*;

public class StringName
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        String firstName, lastName, addressName, userName;
        char firstNameInitial, lastNameInitial;

        // Program description prompt
        System.out.println("This program gets the firs and last name of the user then prints\n" +
                "their initials (F.L.), name in the address book (FirstnameLastname), and\n" +
                "username (fLastname)\n");

        // Inputs
        System.out.println("Enter First Name (no second names): ");
        firstName = in.next();
        System.out.println("Enter Last Name: ");
        lastName = in.next();

        // Concat
        // Get the initials of first & last name by getting their char index
        firstNameInitial = firstName.toLowerCase().charAt(0);
        lastNameInitial = lastName.toLowerCase().charAt(0);

        // Address book name (only lastName is all capitalized)
        // Substring used for getting the char index and its value
        addressName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1) + " "
                + lastName.toUpperCase();

        // Outputs
        System.out.printf("\nInitials: %S\n", firstNameInitial + "." + lastNameInitial + ".");
        System.out.println("Address Book Name: " + addressName);
        System.out.println("Username: " + firstNameInitial + lastName.toLowerCase());
    }
}
