package _3_Assignments._2_BasicJava;
import java.util.Scanner;
public class FibonacciNumb {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter how many numbers should be displayed from Fibonacci Series: ");
        int limit = s1.nextInt();
        int a = 0, b = 1;
        System.out.print(a+" "+b);
        for (int i = 2; i < limit; i++) { // i = 2, since we already have 2 numbers i.e 0 and 1.
            int c = b;
            b = a + b;
            a = c;
            System.out.print(" "+b);
        }
    }
}
