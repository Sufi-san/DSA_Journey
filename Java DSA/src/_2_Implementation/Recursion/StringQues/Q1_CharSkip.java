package _2_Implementation.Recursion.StringQues;

import java.util.Scanner;

public class Q1_CharSkip {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = in.nextLine().trim();
        String str2 = str;
        System.out.println("Enter a Character to remove all of its instances from the string: ");
        char chr = in.nextLine().trim().charAt(0);

        System.out.println("By Approach 1: (Passing Answer String in argument)");
        str = skipChar(str, chr);
        System.out.println(str);

        System.out.println("By Approach 2: (Creating answer variable in function body)");
        str2 = skipChar2(str2, chr);
        System.out.println(str2);
    }

    // Approach 1
    static String skipChar(String str, char chr) {
        StringBuilder strBuilder = new StringBuilder();
        return helper(str, strBuilder, chr); // Passing strBuilder (answer String) in function body
    }

    static String helper(String str, StringBuilder strBuilder, char chr) {
        if(str.isEmpty()) return strBuilder.toString();
        char strChr = str.charAt(0);
        if(!Character.toString(strChr).equalsIgnoreCase(Character.toString(chr))) strBuilder.append(strChr);
        return helper(str.substring(1), strBuilder, chr);
    }

    // Approach 2: Creating and returning answer string each time recursive call ends
    static String skipChar2(String str, char chr) {
        if(str.isEmpty()) return "";
        char strChr = str.charAt(0);
        String futureStr = skipChar2(str.substring(1), chr);
        if(!Character.toString(strChr).equalsIgnoreCase(Character.toString(chr))) return strChr + futureStr;
        else return futureStr;
    }
}
