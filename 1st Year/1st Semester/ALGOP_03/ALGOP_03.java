package ALGOP_03;
import java.util.*;
import java.lang.Math;

/*
 * This program asks for the weight of the package, type of package,
 * and distance then computes for the gross charge and total charge
 */

public class ALGOP_03 {
  public static void outputCharge(double grossCharge, double totalCharge) {
    System.out.println("Gross charge: " + grossCharge + "\nTotal charge: " + totalCharge);
  }

  public static void main(String[] args) {
    // Initialization of variables
    int weight, distance;
    double grossCharge , distanceCost, rate = 0, vat = 0.90, totalCharge;
    String packageType;

    // Inputs
    while (true) {
      Scanner input = new Scanner(System.in);

      System.out.println("Enter type of package (a for type B and b for type B): ");
      packageType = input.next();

      if (!packageType.equalsIgnoreCase("a") && (!packageType.equalsIgnoreCase("b"))) {
        break;
      }

      System.out.println("Enter weight of package: ");
      weight = input.nextInt();

      System.out.println("Enter distance: ");
      distance = input.nextInt();

      // Computes for the cost of the distance
      if (distance <= 500) {
        distanceCost = 1.0;
      } else {
        distanceCost = distance / 500.0;
      }
      // Evaluation for package type a
      if (packageType.equalsIgnoreCase("a"))
      {
        if (weight <= 5)
        {
          rate = 10.50;
        }
        else if (weight >= 5 && weight <= 10)
        {
          rate = 15.75;
        }
        else if (weight >= 10 && weight <= 20)
        {
          rate = 20.65;
        }
      }
      // Evaluation for package type b
      if (packageType.equalsIgnoreCase("b"))
      {
        if (weight <= 5)
        {
          rate = 11.75;
        }
        else if (weight >= 5 && weight <= 10)
        {
          rate = 18.50;
        }
        else if (weight >= 10 && weight <= 20)
        {
          rate = 23.65;
        }
      }
      grossCharge = Math.ceil(weight * rate * distanceCost);
      totalCharge = grossCharge + vat;

      outputCharge(grossCharge, totalCharge);
    }
  }
}