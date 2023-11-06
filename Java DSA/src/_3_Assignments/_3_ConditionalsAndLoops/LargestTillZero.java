package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class LargestTillZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double inp, max = Double.MIN_VALUE;
        System.out.println("Enter numbers and/or press 0 to find largest of all entries:");
        inp = in.nextDouble();
        while(inp != 0){
            max = Math.max(inp, max);
            inp = in.nextDouble();
        }
        System.out.println("Largest Entry is: "+max);
    }
}
