package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class OnlyLCM { // trying to find LCM without finding HCF first
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1, num2, lcm = 0, min;
        System.out.println("Enter two natural numbers to find their LCM: (press Enter after each entry)");
        num1 = min = in.nextInt();
        num2 = in.nextInt();
        min = (min > num2) ? num2 : num1;
        while (lcm == 0) {
            if (min % num1 == 0 && min % num2 == 0) {  // Lowest number divisible by both numbers
                lcm = min;
            }
            min++;
        }
        System.out.println("LCM = " + lcm);
    }
}
