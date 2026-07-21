package _3_Assignments._3_ConditionalsAndLoops_D;
import java.util.Scanner;
public class ProductDiscount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Product Cost: ");
        double cost = in.nextDouble();
        System.out.println("Enter Discount Percentage(%):");
        double discountRate = in.nextDouble();
        double discountedCost = cost - cost*discountRate/100;
        System.out.println("Cost After Discount: "+discountedCost+"\nYou Save: "+(cost - discountedCost));
    }
}
