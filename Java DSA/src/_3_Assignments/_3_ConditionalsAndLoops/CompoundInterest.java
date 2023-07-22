package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class CompoundInterest {
    /* Formula for Compound Interest:
        CI = [Principal*(1 + Rate/Frequency of Compounding)^(Frequency of Compounding * Number of Years)] - Principal
        (In the above formula, Percentage Rate needs to be divided by 100) !

        Basically, Compound Interest takes into account the additional interest itself while calculating next interest
        (interest earned on interest) and thus, we get an addition of both interest on Principal and interest on interest.
        Thus, Interest depends on both frequency of compounding and time in years.
        This is because, compounding can occur multiple times per single year.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double years, principal, interestRate, compInterest;
        int compFreq;
        System.out.println("Enter elements in the following order(press Enter after each entry): ");
        System.out.println("Principal Amount\nRate of Interest(%)\nFrequency of Compounding\nNumber of Years\n");
        principal = in.nextDouble();
        interestRate = in.nextDouble() / 100;
        compFreq = in.nextInt();
        years = in.nextDouble();
        compInterest = principal * Math.pow((1 + interestRate / compFreq), compFreq * years) - principal;
        System.out.printf("CI = %.3f\nTotal Amount after %.2f years: %.3f", compInterest, years, principal + compInterest);
    }
}
