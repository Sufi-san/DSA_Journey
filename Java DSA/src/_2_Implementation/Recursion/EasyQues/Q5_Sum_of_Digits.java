package _2_Implementation.Recursion.EasyQues;

public class Q5_Sum_of_Digits {
    public static void main(String[] args) {
        int n = 193928; // Sum of Digits is 32
        System.out.println(sumOfDigits(n));
    }

    static int sumOfDigits(int n) {
        if(n <= 9) return n;
        return (n % 10) + sumOfDigits(n / 10);
    }
}
