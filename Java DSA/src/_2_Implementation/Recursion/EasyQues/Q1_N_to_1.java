package _2_Implementation.Recursion.EasyQues;

public class Q1_N_to_1 {
    public static void main(String[] args) {
        int n = 5;
        printNum(n);
    }

    static void printNum(int n) {
        System.out.println(n);
        if(n == 1) return;
        printNum(n - 1);
    }
}
