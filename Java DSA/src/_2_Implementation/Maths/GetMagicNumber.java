package _2_Implementation.Maths;

public class GetMagicNumber {
    /*
        Magic Number:
         The set-bits of the binary representation of a number multiplied by corresponding powers of 5
         and added together.
         Corresponding powers: starting from 1 to no. of digits in the number.
        We have to thus, find the nth magic number.
     */
    public static void main(String[] args) {
        int n = 6;
        System.out.println(findMagicNumber(n));
        System.out.println(findMagicNumber2(n));
    }

    // My Approach: Converting to binary and then using modulo to add powers of 5 for set-bit.
    static int findMagicNumber(int n){
        int nBinary = FindUniqueIn3Rep.convertToBinary(n), magicNum = 0, power = 1; // converting to binary
        while(nBinary > 0){
            // if set-bit, multiply by required power of 5 and add to answer
            magicNum += nBinary % 10 * (int) Math.pow(5, power);
            nBinary /= 10;
            power++;
        }
        return magicNum;
    }


    // Kunal Approach:
    // No Binary Conversion needed, just think of it as binary and get last digit using "n & 1".
    // Also, n = n >> 1 will discard the old LSB and place the new one and will keep doing that till n > 0
    static int findMagicNumber2(int n){
        int magicNum = 0, power = 1;
        while(n > 0){
            magicNum += (n & 1) * (int)Math.pow(5, power);
            n = n >> 1;
            power++;
        }
        return magicNum;
    }
}
