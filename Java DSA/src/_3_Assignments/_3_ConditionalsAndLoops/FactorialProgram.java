package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class FactorialProgram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fact = 1;
        System.out.println("Enter whole number to calculate factorial");
        int num = in.nextInt();
        for(int i = num; i > 0; i--){
            fact *= i;
        }
        System.out.println("Factorial of "+num+" is "+fact);
    }
}
