package _3_Assignments._3_ConditionalsAndLoops_D;

import java.util.Scanner;

public class EuclideanDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] point1 = new double[2], point2 = new double[2];
        System.out.println("Enter X-Coordinate of First Point: ");
        point1[0] = in.nextDouble();
        System.out.println("Enter Y-Coordinate of First Point: ");
        point1[1] = in.nextDouble();
        System.out.println("Enter X-Coordinate of Second Point: ");
        point2[0] = in.nextDouble();
        System.out.println("Enter Y-Coordinate of Second Point: ");
        point2[1] = in.nextDouble();
        System.out.printf("Given Points: A(%.2f, %.2f) & B(%.2f, %.2f)\n", point1[0], point1[1], point2[0], point2[1]);
        System.out.println("Distance between Point A & B: "+calcDistance(point1, point2));
    }

    static double calcDistance(double[] point1, double[] point2){
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }
}
