package _3_Assignments._3_ConditionalsAndLoops_D;
import java.util.Scanner;

public class FutureInvestment {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double invAmount, rate, changeAmount, startAmount;
        int option, duration;
        String period;
        System.out.println("Enter Investment Amount: ");
        invAmount = startAmount = in.nextDouble();
        System.out.println("Select Investment Period:\n1. Year\n2. Month\n3. Week\n4. Day");
        option = in.nextInt();
        switch (option){
            case 1 -> period = "Year";
            case 2 -> period = "Month";
            case 3 -> period = "Week";
            case 4 -> period = "Day";
            default -> period = "Unit";
        }
        System.out.printf("Enter Number of %ss in Investment Plan: \n", period);
        duration = in.nextInt();
        for(int i = 0; i < duration; i++){
            System.out.printf("\nEnter %% increment/decrement value for %s %d: (use negative numbers for decrement)\n", period, i+1);
            rate = in.nextDouble()/100;
            changeAmount = invAmount * rate;
            invAmount += changeAmount;
            System.out.printf("Investment value after %d %s: %.3f\n", i+1, period, invAmount);
        }
        String event = (invAmount >= startAmount)? "Profit" : "Loss";
        System.out.printf("\n\nAmount after %d %ss: %.3f\n%s: %.3f ", duration, period, invAmount, event, (invAmount - startAmount));
    }
}
