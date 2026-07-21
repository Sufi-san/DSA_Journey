package _2_Implementation.Recursion.StringQues;

import java.util.Scanner;

public class Q3_StringSkip2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Main String: ");
        String str = in.nextLine().trim();
        String str2 = str;
        System.out.println("Enter a String to preserve in the Main String: ");
        String keepStr = in.nextLine().trim();
        str = skipString(str, keepStr);
        System.out.println(str);
        skipString2(str2, keepStr);
    }

    static String skipString(String str, String keepStr) {
        if(str.length() < keepStr.length() || str.isEmpty() || keepStr.isEmpty()) return "";
        String compareStr = str.substring(0, keepStr.length());
        if(compareStr.equalsIgnoreCase(keepStr)) {
            String futureStr = skipString(str.substring(keepStr.length()), keepStr);
            return compareStr + futureStr;
        }
        else return skipString(str.substring(1), keepStr);
    }

    static void skipString2(String str, String keepStr) {
        StringBuilder strBuilder = new StringBuilder();
        helper(str, strBuilder, keepStr);
    }

    static void helper(String str, StringBuilder strBuilder, String keepStr) {
        if(str.length() < keepStr.length() || str.isEmpty() || keepStr.isEmpty()) {
            System.out.println(strBuilder.toString());
            return;
        }
        String compareStr = str.substring(0, keepStr.length());
        // can also use str.startsWith(keepStr) and strBuilder.append(str.charAt(0))
        // But it does not ignore case
        if(compareStr.equalsIgnoreCase(keepStr)) {
            strBuilder.append(compareStr);
            helper(str.substring(keepStr.length()), strBuilder, keepStr);
            return;
        }
        helper(str.substring(1), strBuilder, keepStr);
    }
}
