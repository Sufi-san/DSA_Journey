package _2_Implementation.ConditionalsAndLoops;
import java.util.Scanner;
public class Q_NumReverse {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the number that is to be reversed: ");
        int num = s1.nextInt();
        int rev_num = 0;
        while(num > 0){
            int rem = num % 10;
            rev_num = rev_num * 10 + rem;
            num /= 10;  // Same as, num = num / 10;
        }
        System.out.println("The reversed number is: "+rev_num);
    }
}
