package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class ProductDiscount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Product Cost: ");
        double cost = in.nextDouble();
        System.out.println("Enter Discount Percentage(%):");
        double discountRate = in.nextDouble();
        double trueDiscount = cost - cost*discountRate/100;
        System.out.println("Discount: "+trueDiscount+"\nYou Save: "+(cost - trueDiscount));
    }
}
