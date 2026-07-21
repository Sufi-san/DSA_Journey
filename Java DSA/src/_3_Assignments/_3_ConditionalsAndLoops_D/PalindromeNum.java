package _3_Assignments._3_ConditionalsAndLoops_D;
import java.util.Scanner;
public class PalindromeNum { // Can be done by directly using String input and applying method to check String Palindrome
    // However, here we use % method.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Enter integer to check for Palindrome: ");
        num = in.nextInt();
        checkPalindrome(num);
        checkPalWithoutString(num);
    }

    static void checkPalindrome(int num){
        String str = Integer.toString(num);
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                System.out.println("Entered number is not a Palindrome.");
                return;
            }
        }
        System.out.println("Entered number is a Palindrome.");
    }

    static void checkPalWithoutString(int num){
        int oldNum = num, newNum = 0;
        while(num > 0){
            newNum = newNum * 10 + (num % 10);
            num /= 10;
        }
        if(oldNum == newNum) System.out.println("Entered number is a Palindrome.");
        else System.out.println("Entered number is not a Palindrome.");
    }
}
