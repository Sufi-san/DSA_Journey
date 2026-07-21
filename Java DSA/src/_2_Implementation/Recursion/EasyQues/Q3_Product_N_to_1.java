package _2_Implementation.Recursion.EasyQues;

public class Q3_Product_N_to_1 {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(productNto1(n)); // Factorial Program
    }

    static int productNto1(int n) {
        if(n <= 1) return 1;
        return n * productNto1(n - 1);
    }
}
