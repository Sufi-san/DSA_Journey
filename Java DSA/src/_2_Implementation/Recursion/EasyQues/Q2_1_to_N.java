package _2_Implementation.Recursion.EasyQues;

public class Q2_1_to_N {
    public static void main(String[] args) {
        int n = 5;
        printNum(n);
        System.out.println();
        printBoth(n);
    }

    static void printNum(int n) {
        if(n > 1) printNum(n - 1);
        System.out.println(n);
    }

    static void printBoth(int n) {
        System.out.println(n);
        if(n > 1) printBoth(n - 1);
        System.out.println(n);
    }
}
