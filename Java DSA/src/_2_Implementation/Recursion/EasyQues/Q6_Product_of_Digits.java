package _2_Implementation.Recursion.EasyQues;

public class Q6_Product_of_Digits {
    public static void main(String[] args) {
        int n = 193928;
        System.out.println(productOfDigits(n));
    }

    static int productOfDigits(int n) {
        if(n <= 9) return n;
        return (n % 10) * productOfDigits(n / 10);
    }
}
