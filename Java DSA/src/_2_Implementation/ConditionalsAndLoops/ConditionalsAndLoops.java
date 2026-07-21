package _2_Implementation.ConditionalsAndLoops;
import java.util.Scanner;
public class ConditionalsAndLoops {
    public static void main(String[] args) {
        /* How to know whether to use while or for loop?
            It is based on preference. However,
            we generally run while loop when we
            don't know how many times the loop will run

            How to know when to use while or do-while?
            In do-while, the loop will run at least once.
         */
        Scanner s1 = new Scanner(System.in);
        // Example of if-else and (else if)
        System.out.println("Enter your age: ");
        int age = s1.nextInt();
        if(age >= 18){
            System.out.println("You have the right to vote.");
        }else{
            System.out.println("You don't have the right to vote.");
        }
        System.out.println();
        // Example of while-loop
        System.out.println("Printing even numbers from 0 to 10: ");
        int num = 0;
        while(num < 11){
            System.out.print(" "+num);
            num += 2;
        }
        System.out.println();
        // Example of for-loop
        System.out.println("Printing even numbers from 11 to 20:");
        for (int num2 = 12; num2 < 21; num2 += 2) {
                System.out.print(" "+num2);
        }
        System.out.println();
        // Example for do-while loop
        System.out.println("Printing even numbers from 21 to 30:");
        int num3 = 22;
        do{
            System.out.print(" "+num3);
            num3 += 2;
        }while(num3 < 31);
    }
}
