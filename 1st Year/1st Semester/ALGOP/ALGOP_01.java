/*
 * This program finds the true bearing that is given by the user 
*/
package ALGOP;
import java.util.*;

public class ALGOP_01
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    
    // Input for the true bearing
    System.out.println("Enter true bearing:");
    int tB = in.nextInt();

    // Conditions
    if (tB <= 90)
    {
      System.out.println("N " + tB + " E");
    }
    else if (tB < 360 & tB > 180)
    {
      System.out.println("N " + (360-tB) + " W");
    }
    else if (tB < 180 & tB > 90)
    {
      System.out.println("S " + (180-tB) + " E");
    }
    else if (tB < 270 & tB > 180)
    {
      System.out.println("S " + (tB-180) + " W");
    }
  }
}
