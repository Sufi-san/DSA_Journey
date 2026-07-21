package _2_Implementation.Recursion.Explanations;

import java.util.Scanner;

public class RecursionIntro {
    // Difficulty is a given when starting out with recursion
    // You should worry if you are not facing any difficulties. (means you are not understanding at all)
    // The difficulty is however only temporary, keep practicing and understanding

    /*
        What is Recursion?
        A function calling itself till a base case(case to stop calling) is reached.

        Role of Stack Memory: (The one which also stores primitive values and reference variables)
        All the functions calls that happen in the programming language go into the stack memory

        Note: Put a debug pointer on printNum or greet function and debug it to see everything in action.

        How function calls work in languages:
        After main() function is called.
        1. While the function does not finish executing, it will remain in stack.
           Thus, main function stays inside the stack for the whole program execution.
        2. Whenever more functions are called inside any function, they are also added
           on top of each other in stack memory based on order of execution.
        3. When a function finishes executing it is removed from the stack and the flow
           of the program is restored to where the function was called.
     */
    public static void main(String[] args) {
        // write a function that prints hello world.
        Scanner in = new Scanner(System.in);
        System.out.println("How many times to print greeting?: ");
        int times = in.nextInt();
        System.out.println("\nPrinting using a loop: ");
        for(int i = times; i > 0; i--){
            greet();
        }
        System.out.println("\nPrinting using recursion: ");
        greet(times);

        // Numbers Example:
        // write a function that takes in a number and prints it
        // print first 5 numbers: 1 2 3 4 5

        System.out.println("\nEnter a number: ");
        int num = in.nextInt();
        System.out.println("\nNumbers printed using recursion: ");
        printNum(num);
    }

    static void greet(int count){
        System.out.println("Hello World");
        count--;
        if (count > 0) {
            greet(count);
        }
    }

    static void greet(){
        System.out.println("Hello World");
    }

    static void printNum(int n){
        if(n > 1) printNum(n - 1);
        System.out.println(n);
    }

}
