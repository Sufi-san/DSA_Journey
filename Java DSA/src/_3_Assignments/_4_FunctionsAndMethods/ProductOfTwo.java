package _3_Assignments._4_FunctionsAndMethods;

import java.util.Scanner;

public class ProductOfTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Number 1: ");
        double num1 = in.nextDouble();
        System.out.println("Enter Number 2: ");
        double num2 = in.nextDouble();
        multiply(num1, num2);
    }
    static void multiply(double num1, double num2){
        System.out.println("Product of the numbers: "+num1 * num2);
    }
}
