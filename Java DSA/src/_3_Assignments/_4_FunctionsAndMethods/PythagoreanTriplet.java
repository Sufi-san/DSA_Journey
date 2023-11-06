package _3_Assignments._4_FunctionsAndMethods;
import java.util.Scanner;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1, num2, num3;
        System.out.println("Enter three positive integers to check for Pythagorean triplets:");
        System.out.println("Integer 1: ");
        num1 = in.nextInt();
        System.out.println("Integer 2: ");
        num2 = in.nextInt();
        System.out.println("Integer 3: ");
        num3 = in.nextInt();
        if(isPythaTriplet(num1, num2, num3))
            System.out.printf("\n%d, %d and %d are Pythagorean Triplets.\n", num1, num2, num3);
        else
            System.out.println("Entered numbers are not Pythagorean Triplets.");
    }

    static boolean isPythaTriplet(int num1, int num2, int num3){
        int maxNum = Math.max(Math.max(num1, num2), num3);
        int a = num1, b = num2;
        if(maxNum == num2){
            b = num3;
        }
        else if(maxNum == num1){
            a = num3;
        }
        return (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(maxNum, 2));
    }
}
