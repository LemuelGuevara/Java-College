/*
* Name: Guevara, Lemuel John D.
* Section: 1CSD
*
* */

package MachineProblems;
import java.util.*;

public class MP3
{
    public static void main(String[] args)
    {
        // Declaration and initialization of variables
        Scanner in = new Scanner(System.in);

        double membershipFee, miscFee = 0, basicFee = 0, nSupplementaryMembers, supplementaryMemberRate = 0;
        char memberType, paymentTerm;

        // Program description prompt
        System.out.println("This program that will calculate the annual membership fee a primary member has to pay.");

        // Inputs
        System.out.println("Enter primary member type (Regular - R, VIP - V): ");
        memberType = in.next().charAt(0);
        memberType = Character.toUpperCase(memberType);

        if (memberType != 'R' || memberType != 'V')
        {
            System.out.println("Please input a valid choice");
            System.exit(0);
        }

        System.out.println("Enter payment term(Cash - C, Monthly - M, Quarterly - Q, Semi-Annually - S): ");
        paymentTerm = in.next().charAt(0);
        paymentTerm = Character.toUpperCase(paymentTerm);
        System.out.println("Enter number of supplementary members: ");
        nSupplementaryMembers = in.nextDouble();

        // Checks misc fee for member type
        if (memberType == 'R')
            miscFee = 1000;
        if (memberType == 'V')
            miscFee = 1650;

        // Checks the rate per supplementary member
        if (memberType == 'R')
            supplementaryMemberRate = 900;
        if (memberType == 'V')
            supplementaryMemberRate = 1000;


        // Switch statement
        switch (memberType)
        {
            case 'R':
            {
                // Checks if supplementary member count is in range
                if (nSupplementaryMembers <= 0)
                {
                    System.out.println("Please enter a number greater than 0.");
                    System.exit(0);
                }
                else if (nSupplementaryMembers > 3)
                {
                    System.out.println("Enter a number greater less than 3.");
                    System.exit(0);
                }

                switch (paymentTerm)
                {
                    case 'C':
                        basicFee = 1200 * 0.85 *  12;
                        miscFee *= 12;
                        supplementaryMemberRate *= 12;
                        break;
                    case 'M':
                        basicFee = 1200;
                        miscFee *= 1;
                        supplementaryMemberRate *= 1;
                        break;
                    case 'Q':
                        basicFee = 3890;
                        miscFee *= 3; // changed to 3 because every 3 months
                        supplementaryMemberRate *= 3; // changed to 3 because every 3 months
                        break;
                    case 'S':
                        basicFee = 8230;
                        miscFee *= 6;
                        supplementaryMemberRate *= 6;
                        break;
                    default:
                        System.out.println("Enter valid payment term.");
                        System.exit(0);
                }
            }
            case 'V':
            {
                // Checks if supplementary member count is in range
                if (nSupplementaryMembers <= 0)
                {
                    System.out.println("Please enter a number greater than 0.");
                    System.exit(0);
                }
                else if (nSupplementaryMembers > 5)
                {
                    System.out.println("Enter a number greater less than 5.");
                    System.exit(0);
                }

                switch (paymentTerm)
                {

                    case 'C':
                        basicFee = 1500 * 0.85 * 12; // Cash payment
                        miscFee *= 12;
                        supplementaryMemberRate *= 12;
                        break;
                    case 'M':
                        basicFee = 1500;
                        miscFee *= 1;
                        supplementaryMemberRate *= 1;
                        break;
                    case 'Q':
                        basicFee = 4865;
                        miscFee *= 3; // changed to 3 because every 3 months
                        supplementaryMemberRate *= 3; // changed to 3 because every 3 months
                        break;
                    case 'S':
                        basicFee = 10650;
                        miscFee *= 6;
                        supplementaryMemberRate *= 6;
                        break;
                    default:
                        System.out.println("Enter valid payment term.");
                        System.exit(0);
                }

                if (memberType != 'R' || memberType != 'V')
                    System.exit(0);
            }
//            default:
//                System.out.println("Please input a valid member type.");
//                System.exit(0);
        }

        // Computation of membership fee
        membershipFee = miscFee + basicFee + nSupplementaryMembers * supplementaryMemberRate;
        System.out.printf("Membership fee: %.2f", membershipFee);

    }
}
