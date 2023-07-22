package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;

public class CalculateCGPA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int semCount;
        double cgpa = 0;
        System.out.println("How many semesters?: ");
        semCount = in.nextInt();
        for(int i = 0; i < semCount; i++){
            System.out.println("Enter Sem "+(i+1)+" Score: ");
            cgpa += in.nextDouble();
        }
        System.out.println("Your current CGPA is: "+cgpa/semCount);
    }
}
