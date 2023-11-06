package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class SelectedSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Keep Entering integers, Input zero to stop.");
        int sumNeg = 0, sumEven = 0, sumOdd = 0, inp = -1;
        while(inp != 0){
            try {  // Exception Handling
                inp = in.nextInt();
            }
            catch (Exception e){
                System.out.println(e+"\nPlease enter integers only.");
                in.next(); // This line is necessary to consume invalid input and avoid infinite loop
                // Because once an exception occurs the 'try' block will not execute again and the lopp continues from
                // the point of failure.
                continue;
            }
            if(inp < 0)
                sumNeg += inp;
            else if(inp % 2 == 0)
                sumEven += inp;
            else
                sumOdd += inp;
        }
        System.out.printf("""
                
                Sum of Negative number: %d
                Sum of Positive Even Numbers: %d
                Sum of Positive Odd Numbers: %d""", sumNeg, sumEven, sumOdd);  // Text Block
    }

}
