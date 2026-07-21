package _2_Implementation.StringAndStringBuilder;
import java.util.Arrays;
public class StringMethods {
    public static void main(String[] args) {
        String name = "Sufiyan";
        System.out.println(Arrays.toString(name.toCharArray())); // converts a String to character Array
        System.out.println(name.toLowerCase()); // converts all character to lowercase
        String str = "bamboozled";
        System.out.println(str.indexOf('o')); // returns index of required character if present in String LHS to RHS
        System.out.println(str.lastIndexOf('o')); // returns index required character if present in String RHS to LHS
        System.out.println(str.toUpperCase()); // converts all character to uppercase
        String tryout = "    \n\tdo re mi fa so la ti\t\n       ";
        System.out.println(tryout);
        System.out.println(tryout.strip()); // removes all spaces at the ends. (recommended way, follows unicode)
        System.out.println(tryout.trim()); // removes all spaces at the ends.
        System.out.println(Arrays.toString(tryout.strip().split(" ")));
        // .split(<regex>) creates a String array where 'regex' is the character at which elements are divided in
        // the array. (identified as different elements in the array)

        /* There are many other methods which are used as per requirement, the ones seen here are:
           ('*' stands for also a method for StringBuilder)
            .toCharArray()
            .toUpperCase()
            .toLowerCase()
            .indexOf() *
            .lastIndexOf() *
            .strip()
            .split()
            .replaceAll()
            .equalsIgnoreCase()
         */
    }
}
