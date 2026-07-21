package _2_Implementation.Recursion.EasyQues;

public class Q8_PalindromeNum {
    public static void main(String[] args) {
        int n = 12321;
        System.out.println(isPalindrome(n));
        System.out.println(isPalindrome2(n));
    }

    // Way 1: Checking if it is equal to its reverse
    static boolean isPalindrome(int n) {
        return n == Q7_ReverseNum.revNum4(n);
    }

    // Way 2: Kind of like two pointer method, checks equality of first and last digit of number in each call
    // In case of true, removes the first and last digit before passing to the next call
    static boolean isPalindrome2(int n) {
        if(n <= 9) return true;
        int digitCount = (int) Math.log10(n) + 1;
        int power = (int) Math.pow(10, digitCount - 1);
        return (n / power == n % 10) && isPalindrome2(n % power / 10);
    }
}
