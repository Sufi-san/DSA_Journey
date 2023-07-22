package _3_Assignments._2_BasicJava;

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter whole number to check for even or odd: ");
        int num = in.nextInt();
        if(num % 2 == 0)
            System.out.println(num+" is even.");
        else
            System.out.println(num+" is odd.");
    }
}
