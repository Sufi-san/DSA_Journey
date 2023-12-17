package _2_Implementation.Maths.Bitwise;

public class NumXOR {
    public static void main(String[] args) {
        int num = 30;
        System.out.println(simpleIterativeXOR(num));
        System.out.println(easyXOR(num));
    }

    static int simpleIterativeXOR(int num) {
        int ans = 0;
        for(int i = 1; i <= num; i++) {
            ans ^= i;
        }
        return ans;
    }

    static int easyXOR(int num) {
        /* Understanding pattern of continuous XORs before designing approach:
            0 -> 0
            1 -> 0 ^ 1 = 1
            2 -> 1 ^ 2 = 3
            3 -> 3 ^ 3 = 0
            4 -> 0 ^ 4 = 4
            5 -> 4 ^ 5 = 1
            6 -> 1 ^ 6 = 7
            7 -> 7 ^ 7 = 0
            8 -> 0 ^ 8 = 8
         */
        if(num % 4 == 0) return num;
        else if(num % 4 == 1) return 1;
        else if(num % 4 == 2) return num ^ 1;
        else return 0;
    }
}
