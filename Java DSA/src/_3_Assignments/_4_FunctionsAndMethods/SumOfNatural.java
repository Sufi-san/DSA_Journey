package _3_Assignments._4_FunctionsAndMethods;
import java.util.Scanner;

public class SumOfNatural {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int naturalNum, sum = 0;
        System.out.println("Enter natural number till which numbers are to be summed: ");
        naturalNum = in.nextInt();
        if(naturalNum > 0) {
            sum = calcSum(naturalNum);
            System.out.println("Sum of natural numbers till " + naturalNum + ": " + sum);
        }
        else
            System.out.println("Please enter natural numbers only.");
    }

    static int calcSum(int naturalNum){
        if(naturalNum > 0)
            return naturalNum + calcSum(naturalNum - 1); // Done using Recursion
        else
            return naturalNum;
    }
}
