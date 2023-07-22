package _3_Assignments._2_BasicJava;
import java.util.Scanner;
public class TwoPointPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Program to check whether entered string is palindrome:\n(Case/Spaces/Punctuation will be ignored)");
        System.out.println("\nEnter String to check for Palindrome: ");
        String seq = in.nextLine();
        seq = seq.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // replaceAll() accepts certain regex patterns which replace multiple selected characters from String
        // e.g: [^\\sa-zA-Z0-9], here [^...] means 'not one of the characters in:',
        // Thus, replacing every character that is not an upper or lowercase alphabet or number with emptyspace.
        // \\p{Punct} stands for all punctuation.
        // System.out.println(seq);
        checkPalindrome(seq);
    }

    static void checkPalindrome(String seq){
        int len = seq.length();
        if(len == 0 || seq.equals(" ")) {
            System.out.println("Entered String is a Palindrome.");
            return;
        }
        for(int i = 0; i < len/2; i++){
            if(seq.charAt(i) != seq.charAt(len - 1 - i)) {
                System.out.println("Entered String is not a Palindrome");
                return;
            }
        }
        System.out.println("Entered String is a Palindrome");
    }
}
