package _2_Implementation.Recursion.EasyQues;

public class Q9_CountZeros {
    public static void main(String[] args) {
        int n = 102002050;
        System.out.println(zeroCount(n));
    }

    // Using Helper function and checking each digit for zero, one-by-one:
    static int zeroCount(int n) {
        return helper(n, 0);
    }
    static int helper(int n, int count) {
        if(n == 0) return count;
        if(n % 10 == 0) count++;
        return helper(n / 10, count);
    }
}
