package _2_Implementation.Maths.Bitwise;

import static java.lang.Integer.bitCount;

public class ResetBit {
    // Reset (i)th bit. Reset means to turn bit to 0.
    public static void main(String[] args) {
        int num = 10110110, bitNum = 5;
        System.out.println(resetBitCompAND(SetBit.convertToBase10(num), bitNum));
    }

    // Kunal Approach: using complement of bitMask and then num & bitMask
    static int resetBitCompAND(int num, int bitNum){
        int bitMask = 1 << bitNum - 1;
        /*
            The size of an int in Java is completely independent of the 32-bitness or 64-bitness of a JDK.
            It is always 4 bytes = 32 bits = −2,147,483,648 to 2,147,483,647. If you want a 64-bit integer,
            use a long , which is always 64 bits = 8 bytes.
            When any int occupies less than 32-bits, the left bits remaining are automatically assumed 0
            However, when we take complement, these assumed 0s also turn to 1 !!!
            This however, does not affect the usual behavior of bitwise operators.
         */
        // ~ is the Complement Operator.
        // with bitCount(), a pre-defined method, we check how many '1' bits exist in the binary number.
        System.out.println(bitCount(~bitMask)+" "+bitCount(num & ~bitMask));
        /*
            What happened in num & ~bitMask ??
            Answer:
                    num = 10110110 (in binary), (bits remaining from 32 to the left assumed 0)
                    bitMask = 1 << 5 - 1 = 16 = 10000 (in Binary), (bits remaining from 32 to the left assumed 0)
                    Thus, (IN 32-bit BINARY FORMAT)
                      bitMask = 00000000000000000000000000010000 , bitCount(bitMask) = 1
                          num = 00000000000000000000000010110110 , bitCount(num) = 5
                     ~bitMask = 11111111111111111111111111101111 , bitCount(~bitMask) = 31
               num & ~bitMask = 00000000000000000000000010100110 , bitCount(num & ~bitMask) = 4
         */
        System.out.println(SetBit.convertToBase2(num ^ bitMask)); // num ^ bitMask will also work
        return SetBit.convertToBase2(num & ~bitMask); // since we get answer in base10 form, convertToBase2 for binary
    }
}
