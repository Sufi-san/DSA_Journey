package _3_Assignments._3_ConditionalsAndLoops_D;

import java.util.Scanner;

public class NumFactors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer to find all of its factors: ");
        int num = in.nextInt();
        printFactors(num);
    }

    static void printFactors(int num){
        int divisor = 1, count = 0;
        System.out.println("Factors of "+num+" are: ");
        while(divisor * divisor < num){
            if(num % divisor == 0){
                count += 2;
                System.out.print(" "+divisor+", "+(num / divisor)+",");
            }
            divisor++;
        }
        System.out.println("\nNumber of factors: "+count);
    }
}
