package _2_Implementation.Maths.Bitwise;

public class BitwiseOperators {
    // '&' is bitwise AND (everything should be true)
    // '|' is bitwise OR (any one should be true)
    // '^' is bitwise XOR (only one should be true), (we get the complement of a number 'n' for (n XOR 1))
    // '~' is bitwise Complement (turns 1 to 0 and 0 to 1)
    // '<<' is bitwise left shift (adds zeros as per number of shifts to right and shifts the existing bits to left)
    // '>>' is bitwise right shift (adds zeros as per number of shifts to left and shifts the existing bits to right)
    public static void main(String[] args) {
        System.out.println(9 & 11); // Binary: 1001 & 1011 = 1001
        System.out.println(9 | 11); // Binary: 1001 | 1011 = 1011
        System.out.println(9 ^ 11); // Binary: 1001 ^ 1011 = 0010
        System.out.println("Complement of "+ 9 +" is "+ (9 ^ 15)); // ~1001 = 1001 ^ 1111 = 0110 (6)
        // Also, any number when XORed with zero returns itself
        System.out.println("Complement of "+ 9 +" by bitwise (~) operator is "+ ~9);
        // ~1001 = 0110 (6 in decimal)
        // However, 2's complement of 10 = ~1010 + 1 = 0101 + 1 = 0110 (-10 in decimal)
        // Here instead of considering '~9' as '6' it is considered as the 2's complement of '10' that is '-10'
        // Therefore, when '~' is used, we have, ~n = -(n + 1)
        // ** (~) Tilde is further explained in 'ResetBit.java' **
        System.out.println("Left shift 2 times of "+ 37 +" is: "+ (37 << 2)); // 100101 << 2 = 10010100 (148 = 37 * 2 ^ 2)
        // So, number of left shifts on binary means product of that many powers of 2 and decimal equivalent
        System.out.println("Right shift 2 times of "+ 37 +" is: "+ (37 >> 2)); // 100101 >> 2 = 001001 (9 = (int) (37 /(2 ^ 2)))
        // So, number of right shifts on binary means division of decimal equivalent by that many powers of 2
    }
}
