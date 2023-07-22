package _3_Assignments._1_FlowchartPseudocode;
import java.util.Scanner;
public class Simple_HCF_LCM {
    /* Logic: Divide the divisor by the remainder, till obtained remainder is equal to zero.
        On each iteration of loop,
        Dividend = Divisor,
        Divisor = Remainder
     */
    public static void main(String[] args) {
        int num1, num2, a, b, hcf, lcm, rem;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two whole numbers to find their HCF and LCM:(Press enter after each entry) ");
        num1 = in.nextInt();
        num2 = in.nextInt();
        a = num1; b = num2;
        do{
            rem = a % b;
            a = b;
            b = rem;
        }while(rem != 0);
        hcf = a;
        lcm = num1*num2/hcf;
        System.out.println("HCF = "+hcf+", LCM = "+lcm);
    }
}
