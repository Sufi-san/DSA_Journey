package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;

public class PermutationCombination {
    // Program to find C(n,r) and P(n,r) i.e (all combinations and permutations) based on user-input data.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Value for 'n': ");
        int n = in.nextInt();
        System.out.println("Enter Value for 'r': ");
        int r = in.nextInt();
        int nPr = calcFactorial(n)/calcFactorial(n - r);
        int nCr = nPr/calcFactorial(r);
        System.out.printf("C(%d, %d) = %d, P(%d, %d) = %d", n, r, nCr, n, r, nPr);
    }

    static int calcFactorial(int x){
        x = (x != 1) ? x * calcFactorial(x-1) : x; // Using Recursion
        return x;
    }
}
