package _2_Implementation.Basic;
import java.util.Scanner;
public class Input {
    public static void main(String[] args) {
        // Basically, System.in corresponds to keyboard input, while System.out corresponds to display in cmd window
        Scanner tk_input = new Scanner(System.in);  // Again System Class is used, part of OOP
        // Here 'tk_input' is a variable, which is now an object of Scanner Class
        /* System.out.println("Enter your name: ");
         String user_name = tk_input.next();  // Will take only one word String input, no import required for String Class
         System.out.println("Hello, "+user_name); */
        System.out.println("Enter your full name: ");
        String full_name = tk_input.nextLine();  // Accepts input from the full line, along with spaces
        System.out.printf("Hello, "+full_name);
    }
}
