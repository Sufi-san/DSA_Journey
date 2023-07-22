package _3_Assignments._4_FunctionsAndMethods;
import java.util.Scanner;

public class PrimeRange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two positive integers: ");
        int num1 = in.nextInt(), num2 = in.nextInt();
        if(num1 > -1 && num2 > -1)
            givePrimeRange(num1, num2);
        else
            System.out.println("Please enter positive integers only.");
    }

    static void givePrimeRange(int num1, int num2){
        System.out.println("\nPrime Numbers in selected range are:\n");
        int max = Math.max(num1, num2), min = Math.min(num1, num2), primeCount = 0;
        min = (min == 0 || min == 1)? 2 : min;
        for(int i = min; i <= max; i++){
            if(primeCount - 10 == 0) {
                System.out.println();
                primeCount = 0;
            }
            if(primeCheck(i)) {
                primeCount++;
                System.out.print(" " + i);
            }
        }
    }

    static boolean primeCheck(int n){
        int divisor = 2;
        while(divisor * divisor <= n){
            if(n % divisor == 0)
                return false;
            divisor++;
        }
        return true;
    }
}
