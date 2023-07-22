package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class PerfectNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter whole number to check if it is Perfect: ");
        int num = in.nextInt(), sum = 0;
        for(int i = 1; i <= num/2; i++){
            if(num % i == 0)
                sum += i;
        }
        if(num == sum && num != 0)
            System.out.println("It is a Perfect Number.");
        else
            System.out.println("It isn't a Perfect Number.");
    }
}
