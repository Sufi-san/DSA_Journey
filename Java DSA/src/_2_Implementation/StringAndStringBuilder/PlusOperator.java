package _2_Implementation.StringAndStringBuilder;
import java.util.ArrayList;
public class PlusOperator {
    // Operator Overloading: operator gives more functionalities
    /*
       In C/C++, Python we can decide what each operator does by modifying it, we can use Operator Overloading on
       any of the basic operators + - * / etc.
       In Java only Plus operator is modified(intentionally overloaded) and performs overloading however, neither
       Plus operator nor any other operator can be further modified by users.
     */
    public static void main(String[] args) {
        System.out.println('a' + 'b'); // char converted to int value and added.
        System.out.println("a" + "b"); // simple concatenation of two strings.
        System.out.println((char)('a' + 3)); // returns 100 by first int calculation, and then 100 is type-casted to character 'd'.
        System.out.println(1 + "b"); // int converted to string using Wrapper Class Integer and then concatenated with b.
        System.out.println('a' + "b"); // char converted to string using Wrapper Class Character and then concatenated with b.
        /* Internal Working:
        System.out.println(Integer.toString(1) + "b");
        System.out.println(Character.toString('a') + "b"); */

        System.out.println("Sufiyan" + new ArrayList<>());
        /* One-Line Answer to all doubts:
            If object(non-primitives) is not string, java converts it to string and then concatenates/prints.
           Condition:
            There should exist at least one string expression between multiple operands for concatenation.
            e.g:  System.out.println(new ArrayList<>() + new ArrayList<>());  will not work, give error.
                  but,
                  System.out.println(new ArrayList<>() +" "+ new ArrayList<>()); will work,
         */
    }
}
