package ALGOF_03;

import java.util.Scanner;
class Harmonic
{
    public static void main(String arg[])
    {
        double n,i;
        double sum=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        n=sc.nextDouble();

        sum++;
        sum = sum + (1/n);

        System.out.println("Harmonic value = "+sum);
    }
}