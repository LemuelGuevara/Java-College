/*
* This program converts feet to meters
*/

package WhileFeetMeters;

import java.util.*;
import static java.lang.Math.*;

public class WhileFeetMeters
{
    public static void main(String[] args)
    {
        // Initialization and declaration of variables
        Scanner in = new Scanner(System.in);

        double feet = 3, meters, meterSen = 30;

        // Program description prompt
        System.out.println("This program converts feet to meters");

        System.out.println("\t" + "Feet" + "\t\t\t" + "Meters");

        // While loop
        while (feet <= meterSen) {
            meters = feet / 3.2808;

            System.out.printf("%8.2f", feet);
            System.out.printf("%17.2f%n", meters);

            feet += 3;
        }
    }
}