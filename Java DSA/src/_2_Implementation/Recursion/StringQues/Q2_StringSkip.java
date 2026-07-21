package _2_Implementation.Recursion.StringQues;

import java.util.Scanner;

public class Q2_StringSkip {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Main String: ");
        String str = in.nextLine().trim();
        String str2 = str;
        System.out.println("Enter a String to remove all of its instances from the Main String: ");
        String rmStr = in.nextLine().trim();
        str = skipString(str, rmStr);
        System.out.println(str);
        skipString2(str2, rmStr);
    }

    static String skipString(String str, String rmStr) {
        if(str.length() < rmStr.length() || str.isEmpty() || rmStr.isEmpty()) return str;
        String compareStr = str.substring(0, rmStr.length());
        if(!compareStr.equalsIgnoreCase(rmStr)) {
            String futureStr = skipString(str.substring(1), rmStr);
            return compareStr.charAt(0) + futureStr;
        }
        else return skipString(str.substring(rmStr.length()), rmStr);
    }

    static void skipString2(String str, String rmStr) {
        StringBuilder strBuilder = new StringBuilder();
        helper(str, strBuilder, rmStr);
    }

    static void helper(String str, StringBuilder strBuilder, String rmStr) {
        if(str.length() < rmStr.length() || str.isEmpty() || rmStr.isEmpty()) {
            System.out.println(strBuilder + str);
            return;
        }
        String compareStr = str.substring(0, rmStr.length());
        // can also use str.startsWith(rmStr) and strBuilder.append(str.charAt(0))
        // But it does not ignore case
        if(!compareStr.equalsIgnoreCase(rmStr)) {
            strBuilder.append(compareStr.charAt(0));
            helper(str.substring(1), strBuilder, rmStr);
            return;
        }
        helper(str.substring(rmStr.length()), strBuilder, rmStr);
    }
}
