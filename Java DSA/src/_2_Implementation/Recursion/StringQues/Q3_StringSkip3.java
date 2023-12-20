package _2_Implementation.Recursion.StringQues;

import java.util.Scanner;

public class Q3_StringSkip3 {
    // Skip a String say 'app' when it's not equal to the required String say 'apple'
    // Eg: "badappappleappbdapp" -> "badapplebd"
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Main String: ");
        String str = in.nextLine().trim();
        // String str2 = str;
        System.out.println("Enter a String to remove all of its instances from the Main String: ");
        String rmStr = in.nextLine().trim();
        System.out.println("Enter a String to preserve even when it contains the String to remove: ");
        String keepStr = in.nextLine().trim();
        skipString(str, rmStr, keepStr);
    }

    static void skipString(String str, String rmStr, String keepStr) {
        StringBuilder strBuilder = new StringBuilder();
        helper(str, strBuilder, rmStr, keepStr);
    }

    static void helper(String str, StringBuilder strBuilder, String rmStr, String keepStr) {
        if(str.isEmpty() || rmStr.isEmpty() || rmStr.length() > str.length()) {
            System.out.println(strBuilder + str);
            return;
        }
        if(str.startsWith(rmStr) && !str.startsWith(keepStr)) {
            helper(str.substring(rmStr.length()), strBuilder, rmStr, keepStr);
            return;
        }
        strBuilder.append(str.charAt(0));
        helper(str.substring(1), strBuilder, rmStr, keepStr);
    }
}
