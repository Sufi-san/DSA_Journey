package _2_Implementation.Recursion.PatternsNSortQues;

public class Q2_Triangle2 {
    public static void main(String[] args) {
        int n = 4;
        printTriangle2(n);
    }

    static void printTriangle2(int n) {
        helper(n, 0, 0);
    }

    static void helper(int n, int row, int col) {
        if(row == n) return;
        if(col == 2 * n) {
            System.out.println();
            helper(n, row + 1, 0);
            return;
        }
        if(col >= n - row && col <= n + row) System.out.print("* ");
        else System.out.print("  ");
        helper(n, row, col + 1);
    }
}
