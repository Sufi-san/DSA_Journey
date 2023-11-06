package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class AverageOfN {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double sum = 0, count = 0;
        String input;
        System.out.println("Keep entering numbers, press 'X' to stop and calculate Average of all numbers: ");
        input = in.next();
        while(!input.equalsIgnoreCase("X")){
            count++;
            sum += Double.parseDouble(input);
            input = in.next();
        }
        System.out.println("Average of all entries: "+(sum/count)); // Dividing by 'double' zero does not give error.
    }
}
