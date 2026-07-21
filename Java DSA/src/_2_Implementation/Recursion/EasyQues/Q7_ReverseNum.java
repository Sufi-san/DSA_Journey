package _2_Implementation.Recursion.EasyQues;

public class Q7_ReverseNum {
    static int revNumAns = 0;

    public static void main(String[] args) {
        int n = 1930521;
        System.out.println(revNum(0, n));
        System.out.println(revNum2(0, n));
        revNum3(n);
        System.out.println(revNumAns);
        System.out.println(revNum4(n));
    }

    // Way 1: (passing the incomplete answer as argument to next function body)
    static int revNum(int newNum, int n) {
        if(n <= 9) return newNum + n;
        return revNum((newNum + n % 10) * 10, n / 10);
    }

    // Way 1 with different logic:
    static int revNum2(int newNum, int n) {
        if(n <= 9) return newNum * 10 + n;
        return revNum2(newNum * 10 + (n % 10), n / 10);
    }

    // Way 2: (maintaining an external variable which will store the incomplete answer
    static void revNum3(int n) {
        revNumAns = revNumAns * 10 + n % 10;
        if(n <= 9) return;
        revNum3(n / 10);
    }

    // Way 3: (using Math.log10() to find the number of digits and find appropriate power of 10
    // to multiply the current digit with it)

    static int revNum4(int n) {
        if(n <= 9) return n;
        int digitCount = (int) Math.log10(n) + 1;
        int power = (int) Math.pow(10, digitCount - 1);
        return (n % 10) * power + revNum4(n / 10);
    }
}
