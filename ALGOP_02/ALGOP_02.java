package ALGOP_02;
import java.util.*;

/*
 * This program computes the gross cost and net cost of long distance calls
 */

public class ALGOP_02 {
  public static void outputCost(double grossCost, double netCost) {
    System.out.println("Gross cost : " + grossCost + "\n" + "Net cost: " + netCost);
  }

  public static void main(String[] args)
  {
    int rate, callLength;
    double grossCost, vat, netCost = 0, netCostA, netCostB;
    rate = 4;
    vat = 1.12;

    while (true)
    {
      // Inputs are time of call and length of call
      Scanner in = new Scanner(System.in);

      // Asks for the time of the given call
      System.out.println("Enter time of call (A for day and B for night, or press any other key to quit): ");
      String time = in.nextLine();

      if (!time.equalsIgnoreCase("A") && (!time.equalsIgnoreCase("B")))
      {
        break;
      }

      System.out.println("Enter length of call: ");
      callLength = in.nextInt();

      // Computes the raw cost of the
      grossCost = rate * callLength;

      // Evaluates the input of time wherein A = day & B = night
      if (time.equalsIgnoreCase("A"))
      {
        // if length of call is greater than 60 minutes then call be will be discounted 15%
        if (callLength > 60)
        {
          netCostA = (grossCost * 0.85) * vat;
          netCost = netCostA;
        }
        // if call length is not greater than 60 minutes then call will have no discount
        else 
        {
          netCostA = grossCost + vat;
          netCost = netCostA;
        }
      }
      // Conditions for night calls
      else if (time.equalsIgnoreCase("B"))
      {
        if (callLength > 60) 
        {
          netCostB = (grossCost * 0.50 * 0.85) * vat;
          netCost = netCostB;
        }
        else 
        {
          netCostB = (grossCost * 0.50) * vat;
          netCost = netCostB;
        }
      }
      outputCost(grossCost, netCost);
    }
  }
}
