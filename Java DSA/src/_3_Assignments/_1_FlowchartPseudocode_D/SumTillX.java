package _3_Assignments._1_FlowchartPseudocode_D;
import java.util.Scanner;

public class SumTillX {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sum = 0;
        String input;
        System.out.println("Enter numbers(Press Enter after each entry) and press X to Stop:");
        while(true){
            input = in.nextLine();
            if(input.equals("X") || input.equals("x"))
                break;
            else{
                double num = Double.parseDouble(input);
                sum += num;
            }
        }
        System.out.println("Sum of all entered numbers is: "+sum);
    }
}
