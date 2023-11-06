package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class PerfectNumber {
    public static void main(String[] args) {
        // A number is perfect if the sum of all its divisors (excluding itself) is equal to that number.
        Scanner in = new Scanner(System.in);
        System.out.println("Enter whole number to check if it is Perfect: ");
        int num = in.nextInt(), sum = 1;
        for(int i = 2; i * i <= num; i++){ // optimising using logic similar to 'prime number'/'factor' optimisation
            if(num % i == 0) {
                if(i != num / i) sum += i + (num / i);
                else sum += i;
            }
        }
        if(num == sum && num != 1)
            System.out.println("It is a Perfect Number.");
        else
            System.out.println("It isn't a Perfect Number.");
    }
}
