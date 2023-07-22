package _3_Assignments._4_FunctionsAndMethods;
import java.util.Scanner;
public class MaxMinMethod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 3 numbers (press enter after each entry):");
        double num1 = in.nextDouble(), num2 = in.nextDouble(), num3 = in.nextDouble();
        findMaxMin(num1, num2, num3);
    }

    static void findMaxMin(double num1, double num2, double num3){
        double max, min;
        max = Math.max(Math.max(num1, num2), num3);
        min = Math.min(Math.min(num1, num2), num3);
        System.out.println("Maximum: "+max+"\nMinimum: "+min);
    }

}
