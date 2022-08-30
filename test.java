
/*
 * This program computes the gross cost and net cost of long distance calls
*/
import java.util.*;

public class test {
  public static void outputCost(double grossCost, double netCost) {
    System.out.println("Gross cost : " + grossCost + "\n" + "Net cost: " + netCost);
  }

  public static void main(String[] args) {

    int rate, callLength;
    double grossCost, vat, netCostA, netCostB;

    rate = 4;
    vat = 1.12;

    // Inputs are time of call and length of call
    Scanner in = new Scanner(System.in);

    System.out.println("Enter time of call (A for day and B for night): ");
    String time = in.nextLine();

    System.out.println("Enter length of call: ");
    callLength = in.nextInt();

    // Computes the raw cost of the
    grossCost = rate * callLength;

    // Evaluates the input of time wherein A = day & B = night
    if (time.equals("A") & callLength > 60) {

      // if length of call is greater than 60 mins then call be will discounted 15%
      netCostA = (grossCost * 0.85) * vat;
      outputCost(grossCost, netCostA);

    } else {

      netCostA = grossCost + vat;
      outputCost(grossCost, netCostA);
    }

    // If time is night
    if (time.equals("B") && callLength > 60) {

      netCostB = (grossCost * 0.50 * 0.85) * vat;
      outputCost(grossCost, netCostB);

    } else {

      netCostB = (grossCost * 0.50) * vat;
      outputCost(grossCost, netCostB);

    }
  }
}
