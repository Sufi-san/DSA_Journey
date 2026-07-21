package _3_Assignments._3_ConditionalsAndLoops_D;
import java.util.Scanner;
import java.lang.StringBuilder;

public class StringReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String to be reversed: ");
        String str = in.nextLine();
        StringBuilder strBuilder = new StringBuilder(str);
        System.out.println("Reversed String: "+strBuilder.reverse());
        System.out.println("Using Two Pointer method: "+strReverse(str));
    }

    static String strReverse(String str){
        StringBuilder strBuilder = new StringBuilder(str);
        int start = 0, end = str.length() - 1;
        while(start < end){
            char temp = strBuilder.charAt(start);
            strBuilder.setCharAt(start, strBuilder.charAt(end));
            strBuilder.setCharAt(end, temp);
            start++;
            end--;
        }
        return new String(strBuilder);  // another way to convert any object to String using String() constructor
        // What I mostly use is strBuilder.toString()
    }
}
