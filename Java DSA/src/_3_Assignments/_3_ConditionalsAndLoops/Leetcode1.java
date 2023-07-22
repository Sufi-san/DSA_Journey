package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class Leetcode1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Positive Integer:");
        int num = in.nextInt();
        int ans = subtractProductAndSum(num);
        System.out.println(ans);
    }

    static int subtractProductAndSum(int n) {
        int digit, digProd = 1, digSum = 0;
        while(n > 0){
            digit = n % 10;
            digProd *= digit;
            digSum += digit;
            n /= 10;
        }
        return digProd - digSum;
    }
}
