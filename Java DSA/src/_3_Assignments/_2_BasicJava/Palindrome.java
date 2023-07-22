package _3_Assignments._2_BasicJava;
import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // A Palindrome is a word or sentence, which is read the same even when reversed.
        // Empty, null or one letter Strings are also a Palindrome.
        // The problem can also be solved using two-pointer method, but here we used built-in .reverse()
        // from StringBuilder class.
        System.out.println("Enter String to check whether it is Palindrome:");
        StringBuilder check_seq = new StringBuilder(in.nextLine());
        System.out.println("Ignore Upper/Lower Case? (Type Yes or No)");
        String opt1 = in.nextLine();
        System.out.println("Ignore Spaces?(Type Yes or No)");
        String opt2 = in.nextLine();
        palindromeCheck(check_seq, opt1, opt2);
    }

    static void palindromeCheck(StringBuilder seq, String ign_case, String ign_space){
        boolean condition; // initializing boolean variable
        String cmp1, cmp2;
        if(ign_space.equalsIgnoreCase("Yes")){
            cmp1 = seq.toString().replaceAll(" ", "");
            cmp2 = seq.reverse().toString().replaceAll(" ", "");
        }else if( ign_space.equalsIgnoreCase("No")){
            cmp1 = seq.toString();
            cmp2 = seq.reverse().toString();
        }else{
            System.out.println("Please Enter appropriate values.");
            return;
        }
        if(ign_case.equalsIgnoreCase("Yes")){
            condition = cmp1.equalsIgnoreCase(cmp2);
            // .equalsIgnoreCase, ignores the case of the letters while comparing strings.
        }else if(ign_case.equalsIgnoreCase("No")){
            condition = cmp1.equals(cmp2);
        }else{
            System.out.println("Please Enter appropriate values.");
            return;
        }

        if(condition)
            System.out.println("Entered String is a Palindrome.");
        else
            System.out.println("Entered String is not a Palindrome.");
    }
}
