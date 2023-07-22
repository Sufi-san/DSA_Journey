package _3_Assignments._2_BasicJava;
import java.util.Scanner;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter data in the following order(press Enter after each input): Principal Amount, Rate of Interest, Time(in Years)");
        double p = in.nextDouble();
        double r = in.nextDouble();
        int t = in.nextInt();
        double si = p*r*t/100;
        System.out.printf("SI = %.3f", si);
    }
}
