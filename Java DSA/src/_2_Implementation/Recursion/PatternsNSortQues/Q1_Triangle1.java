package _2_Implementation.Recursion.PatternsNSortQues;

public class Q1_Triangle1 {
    public static void main(String[] args) {
        int n = 4;
        printTriangle(n);
        printTriangle1b(n);
    }

    static void printTriangle(int n) {
        helper(n, 0);
    }

    static void helper(int n, int count) {
        if(n == 0) return;
        if(count < n) {
            System.out.print("* ");
            helper(n, count + 1);
            return;
        }
        System.out.println();
        helper(n - 1, 0);
    }

    static void printTriangle1b(int n) {
        helper1b(n, 0);
    }

    // Key Observation: Inside a function, we can perform action and then make a recursive call, or we can
    //                  make a recursive call first, reach the end and then perform action
    //                  In case of Patterns, if used correctly, this can be used to invert the generated pattern
    static void helper1b(int n, int count) {
        if(n == 0) return;
        if(count < n) {
            helper1b(n, count + 1);
            System.out.print("* ");
            return;
        }
        helper1b(n - 1, 0);
        System.out.println();
    }
}
