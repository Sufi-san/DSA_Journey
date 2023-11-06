package _3_Assignments._3_ConditionalsAndLoops;

import java.util.Scanner;

public class SumOfNFormulaic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a natural number to find Sum of all numbers up to that number: ");
        int num = in.nextInt();
        // Using the formula to find the answer
        System.out.println("Sum of Natural Numbers up to "+num+" is: "+(num*(num + 1))/2);
        // Using loop
        System.out.println("Answer using loop: "+findSum(num));
    }

    static int findSum(int num){
        int sum = num;
        for(int i = 1; i < num; i++){
            sum += i;
        }
        return sum;
    }
}
