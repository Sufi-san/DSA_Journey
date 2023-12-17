package _2_Implementation.Recursion.EasyQues;

public class Q4_Sum_N_to_1 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(sumNto1(n));
    }

    static int sumNto1(int n) {
        if(n <= 1) return n;
        return n + sumNto1(n - 1);
    }
}
