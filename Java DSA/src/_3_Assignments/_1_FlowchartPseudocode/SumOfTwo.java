package _3_Assignments._1_FlowchartPseudocode;

import java.util.Scanner;

public class SumOfTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        double num1 = in.nextDouble();
        double num2 = in.nextDouble();
        System.out.println("Sum of entered numbers: "+(num1+num2));
    }
}
