package _3_Assignments._4_FunctionsAndMethods;

import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = in.nextInt();
        checkEligibility(age);
    }

    static void checkEligibility(int age){
        if(age >= 18){
            System.out.println("You are eligible to vote.");
        }
        else{
            System.out.println("You are not eligible to vote.");
        }
    }
}
