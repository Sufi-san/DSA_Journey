package _2_Implementation.Maths;

public class PascalRowSum {
    // Aim is to find the sum of all numbers in nth row of the Pascal's Triangle
    public static void main(String[] args) {
        int num = 5;
        System.out.printf("Sum of Row %d of Pascal's Triangle: %d", num, findPascalRowSum(num));
        System.out.printf("\nSum of Row %d of Pascal's Triangle (Kunal Approach): %d", num, findPascalRowSum2(num));
    }

    // My Approach: As number of rows increase, sum for next row is the double of the sum previous row.
    static int findPascalRowSum(int rowNum){
        return (int) Math.pow(2, rowNum);
    }

    /* Kunal Approach:
         Same but uses left shift (as number of binary left shifts means number of times multiplied by 2)
         and powers of 2 have only MSB as 1 in binary...
         Kunal also mentioned something about Combinations, C(n, 0) + C(n, 1) + ... + C(n, n) = 2^n, while deriving the
         formula
     */
    static int findPascalRowSum2(int rowNum){
        return (1 << rowNum);
    }
}
