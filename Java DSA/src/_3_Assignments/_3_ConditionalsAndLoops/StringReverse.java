package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
import java.lang.StringBuilder;

public class StringReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String to be reversed: ");
        String str = in.nextLine();
        StringBuilder strBuilder = new StringBuilder(str);
        str = strBuilder.reverse().toString();
        System.out.println("Reversed String: "+str);
    }
}
