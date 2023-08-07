package _2_Implementation.Maths;

import static java.lang.Integer.bitCount;

public class ResetBit {
    // Reset (i)th bit. Reset means to turn bit to 0.
    public static void main(String[] args) {
        int num = 10110110, bitNum = 5;
        System.out.println(resetBitXOR(SetBit.convertToBase10(num), bitNum));
        System.out.println(resetBitCompAND(SetBit.convertToBase10(num), bitNum));
    }

    // My Approach: using simple bitMask and then num ^ bitMask
    static int resetBitXOR(int num, int bitNum){
        int bitMask = 1 << bitNum - 1;
        return SetBit.convertToBase2(num ^ bitMask);
    }

    // Kunal Approach: using complement of bitMask and then num & bitMask
    static int resetBitCompAND(int num, int bitNum){
        int bitMask = 1 << bitNum - 1;
        /*
            As we have a 32-bit JRE, java uses 32-bit binary numbers.
            When any number is less than 32-bits, the left bits remaining are automatically assumed 0
            However, when we take complement, these assumed 0s also turn to 1 !!!
         */
        // ~ is the Complement Operator.
        // with bitCount() method we check how many '1' bits exist in the binary number.
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
        return SetBit.convertToBase2(num & ~bitMask); // since we get answer in base10 form, convertToBase2 for binary
    }
}
