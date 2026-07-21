package _2_Implementation.Maths.Bitwise;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

public class SetBit {
    // Set (i)th bit. Set means to turn bit to 1.
    public static void main(String[] args) {
        int num = 10110110, bitNum = 7;
        System.out.println(setBit(num, bitNum));
    }

    static int setBit(int num, int bitNum){
        int bitMask = 1 << bitNum - 1; // creating bitMask
        // even though num is an integer, we have to assume it as binary and hence convert it to integer
        num = convertToBase10(num);
        // as bitwise operations happen on binary values, 'num' and 'bitMask' will first convert to binary and then
        // OR operation will take place, however, the result returned itself will get converted to decimal
        // As we again want to see the binary representation, we reconvert the decimal to binary and then return it.
        return convertToBase2(num | bitMask);
    }

    static int convertToBase10(int num) {
        int i = 0, integer = 0, temp = num;
        while (temp > 0) {
            int remainder = temp % 10;
            integer += remainder * (int) Math.pow(2, i);
            temp /= 10;
            i++;
        }
        return integer;
    }

    static int convertToBase2(int num) {
        return parseInt(toBinaryString(num));
    }
}
