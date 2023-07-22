package _3_Assignments._1_FlowchartPseudocode;
import java.util.Scanner;

public class PrintTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number to print table: ");
        double num = in.nextDouble();
        int c = 1;
        while(c <= 10){
            System.out.println(num+" X "+c+" = "+(num * c));
            c++;
        }
    }
}
