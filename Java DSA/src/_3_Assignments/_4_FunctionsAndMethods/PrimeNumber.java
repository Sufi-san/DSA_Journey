package _3_Assignments._4_FunctionsAndMethods;
import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter an integer to check for Prime: ");
        int num = s1.nextInt();
        boolean isPrime = primeCheck(num);
        if(isPrime){
            System.out.println("The entered number is Prime.");
        }else{
            System.out.println("The entered number is not Prime.");
        }
    }
    static boolean primeCheck(int num) {
        int divisor = 2;
        if(num < divisor){
           return false;
        } else {
            while(divisor * divisor <= num) {  // divisor * divisor instead of just divisor, reduces time complexity
                if(num % divisor == 0){
                    return false;
                    // As return statement ends the function, whenever the if condition is true,
                    // false will be returned and the function code will stop executing.
                }
                divisor++;
            }
            return true; // when the if condition is never true in all while loop iterations
        }
    }
}
