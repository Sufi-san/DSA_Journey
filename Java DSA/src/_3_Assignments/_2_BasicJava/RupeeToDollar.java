package _3_Assignments._2_BasicJava;
import java.util.Scanner;

public class RupeeToDollar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float rate = 82.54f;
        System.out.println("Enter amount in rupees:");
        double rup = in.nextDouble();
        double dol = rup/rate;
        System.out.printf("₹%.3f = $%.3f",rup, dol);  // unicode for rupee symbol: \u20b9
    }
}
