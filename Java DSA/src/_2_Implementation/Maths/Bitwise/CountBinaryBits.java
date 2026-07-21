package _2_Implementation.Maths.Bitwise;

public class CountBinaryBits {
    public static void main(String[] args) {
        int num = 236;
        System.out.println("Number of binary bits for "+num+": "+countBits(num, 2));
        System.out.println("Number of bits for same number in Base5: "+countBits(num, 5));
    }

    // Naive Approach: Continuous division by 2 or right shift till number equals zero all the while counting iterations

    /* Formulaic Approach:
         As Binary Bits are basically powers of 2, we just have to check the highest power
         of 2 the number contains and add 1 to it as Binary Digits start from 2 ^ 0 (0-indexed)

         Number of Binary Bits = log2(number) + 1 = (log(number) / log(2)) + 1
         This can be done, to find the number of bits for a number in ANY number system.

         If b = base and n = number then, the general formula is:
         No. of bits = (int)(Math.log(n)/Math.log(b)) + 1

         Time Complexity = O(1) considering the 'Math.log()' method takes constant time
     */
    static int countBits(int num, int base){
        return (int)(Math.log(num)/Math.log(base)) + 1;
    }
}
