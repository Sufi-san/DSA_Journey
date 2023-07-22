package _3_Assignments._2_BasicJava;
import java.util.Scanner;
public class LargestOf2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        double num1 = in.nextDouble();
        double num2 = in.nextDouble();
        double max = num1;
        if(num2 > max)
            max = num2;
        System.out.println("Largest of two is: "+max);
    }
}
