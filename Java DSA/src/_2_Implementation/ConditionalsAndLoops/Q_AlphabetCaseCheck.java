package _2_Implementation.ConditionalsAndLoops;
import java.util.Scanner;
public class Q_AlphabetCaseCheck {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter an alphabet: ");
        String alpha = s1.next();
        char alphabet = alpha.charAt(0);  // OR int alphabet = s1.next().trim().charAt(0) ,
        // trim() removes extra space at the end of the word.
        // However, by default any empty space will be ignored by java while taking character using charAt().
        if(alphabet >= 'A' && alphabet <= 'Z'){  // Unicode for Capital Letters can also be used.
            System.out.println("The alphabet belongs to uppercase.");
        }else if(alphabet >= 'a' && alphabet <= 'z'){  // Unicode for Small Letters can also be used.
            System.out.println(("The alphabet belongs to lowercase."));
        }else{
            System.out.println("The entered character was not an alphabet.");
        }
    }
}
