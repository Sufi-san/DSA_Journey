package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class SelectedSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Keep Entering integers, Input zero to stop.");
        String inp = in.nextLine();
        int num, sumNeg = 0, sumEven = 0, sumOdd = 0;
        while(!inp.equals("0")){
            try {  // Exception Handling
                num = Integer.parseInt(inp);
            }
            catch (Exception e){
                System.out.println(e+"\nPlease enter integers only.");
                continue;
            }
            if(num > 0 && num % 2 == 0)
                sumEven += num;
            else if(num > 0)
                sumOdd += num;
            else
                sumNeg += num;
            inp = in.nextLine();
        }
        System.out.printf("""
                
                Sum of Negative number: %d
                Sum of Positive Even Numbers: %d
                Sum of Positive Odd Numbers: %d""", sumNeg, sumEven, sumOdd);  // Text Block
    }

}
