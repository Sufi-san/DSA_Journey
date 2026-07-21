package _3_Assignments._3_ConditionalsAndLoops_D;
import java.util.Scanner;
public class DigitSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter whole number to get sum of its digits: ");
        int num = in.nextInt(), sum = 0, digit;
        while(num != 0){
            digit = num%10;
            sum += digit;
            num /= 10;
        }
        System.out.println("Sum of Digits: "+sum);
    }
}
