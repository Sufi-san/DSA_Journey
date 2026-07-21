package _3_Assignments._3_ConditionalsAndLoops_D;

import java.util.Scanner;

public class CommissionPercentage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double amount, commission;
        System.out.println("Enter the total amount: ");
        amount = in.nextDouble();
        System.out.println("Enter Commission amount: ");
        commission = in.nextDouble();
        double percentComm = commission * 100 / amount;
        System.out.println("Percentage Commission for given amount is: "+percentComm+" %");
    }
}
