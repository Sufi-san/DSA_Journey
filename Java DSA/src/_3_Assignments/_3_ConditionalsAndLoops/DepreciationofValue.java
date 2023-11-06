package _3_Assignments._3_ConditionalsAndLoops;

import java.util.Scanner;

public class DepreciationofValue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double percOfDep, orgVal;
        int depNum;
        System.out.println("Enter Original Value: ");
        orgVal = in.nextDouble();
        System.out.println("Enter Depreciation Percentage: ");
        percOfDep = in.nextDouble();
        System.out.println("Enter number of Depreciation: ");
        depNum = in.nextInt();
        System.out.println("Value after Depreciation: "+calcDepreciation(orgVal, percOfDep, depNum));
    }
    static double calcDepreciation(double value, double depPerc, int count){
        for(int i = 0; i < count; i++){
            value -= value * depPerc /100;
        }
        return value;
    }
}
