package _3_Assignments._3_ConditionalsAndLoops;

import java.util.Scanner;

public class BattingAverage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of successful hits: ");
        int batHits = in.nextInt();
        System.out.println("Enter number of at-bats:");
        int atBats = in.nextInt();
        System.out.printf("Batting Average: %.1f", batHits / (double)atBats);
    }
}
