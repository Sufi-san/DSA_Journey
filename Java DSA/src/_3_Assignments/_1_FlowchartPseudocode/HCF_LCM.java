package _3_Assignments._1_FlowchartPseudocode;
import java.util.Scanner;
import java.util.ArrayList;


public class HCF_LCM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two whole numbers: ");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        ArrayList<Integer> fact1 = new ArrayList<Integer>();
        ArrayList<Integer> fact2 = new ArrayList<Integer>();
        ArrayList<Integer> cf = new ArrayList<Integer>();
        fact1 = findFactor(num1);
        fact2 = findFactor(num2);
        System.out.println("Factors of "+num1+": "+fact1);
        System.out.println("Factors of "+num2+": "+fact2);
        int hcf = findHCF(fact1, fact2);
        System.out.println("HCF = "+hcf);
        int lcm = num1 * num2 / hcf;
        System.out.println("LCM = "+lcm);
    }

    static ArrayList<Integer> findFactor(int num){
        int digit = 1;
        int org_num = num;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(digit <= org_num){
            if(org_num%digit == 0){
                num /= digit;
                result.add(digit);
            }
            digit++;
        }
        return result;
    }

    static int findHCF(ArrayList<Integer> fact1, ArrayList<Integer> fact2){
        ArrayList<Integer> max = new ArrayList<Integer>();
        max = fact2;
        if(fact1.size() > max.size()){
            max = fact1;
        }
        for(int i = max.size() - 1; i >= 0; i--){
            int num = max.get(i);
            if(fact1.contains(num) && fact2.contains(num)){
                return num;
            }
        }
        return 1;
    }
}
