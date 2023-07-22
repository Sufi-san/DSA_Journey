package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class DigitSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter whole number to get sum of its digits: ");
        int num = in.nextInt(), sum = 0, digit, temp = num;
        while(temp != 0){
            digit = temp%10;
            sum += digit;
            temp /= 10;
        }
        System.out.println("Sum of Digits: "+sum);
    }
}
