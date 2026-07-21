package _2_Implementation.Basic;
import java.util.Scanner;

public class PrimitiveInputs {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int int_var = s1.nextInt();
        System.out.println("Enter a decimal: ");
        float float_var = s1.nextFloat();
        s1.nextLine();  // To consume the full line and move cursor below so that the following nextLine() method works
        System.out.println("Enter a String: ");
        String string_var = s1.nextLine();
        System.out.println("Entered integer is: "+int_var+", decimal is: "+float_var+", string is: "+string_var);
    }
}
