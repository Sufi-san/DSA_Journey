package _3_Assignments._2_BasicJava_D;
import java.util.Scanner;
public class TwoPointPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Program to check whether entered string is palindrome:\n(Case/Spaces/Punctuation will be ignored)");
        System.out.println("\nEnter String to check for Palindrome: ");
        String seq = in.nextLine();
        seq = seq.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("Considering entered String as: "+seq);
        // replaceAll() accepts certain regex patterns which replace multiple selected characters from String
        // e.g: [^\\sa-zA-Z0-9], here [^...] means 'not one of the characters in:',
        // Thus, replacing every character that is not an upper or lowercase alphabet or number with empty space.
        // \\p{Punct} stands for all punctuation, \s stands for spaces (knowledge just in case)
        checkPalindrome(seq);
        checkPalindrome2(seq); // Implemented differently (using Start & End Pointer)
    }

    static void checkPalindrome(String seq){
        int len = seq.length();
        for(int i = 0; i < len/2; i++){
            if(seq.charAt(i) != seq.charAt(len - 1 - i)) {
                System.out.println("Entered String is not a Palindrome");
                return;
            }
        }
        System.out.println("Entered String is a Palindrome");
    }

    static void checkPalindrome2(String seq){
        int start = 0, end = seq.length() - 1;
        boolean isPalindrome = true;
        while(start < end){
            if(seq.charAt(start) != seq.charAt(end)){
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        if(isPalindrome) System.out.println("Entered String is a Palindrome");
        else System.out.println("Entered String is not a Palindrome");
    }
}
