package _2_Implementation.Maths.Bitwise;

public class FindBit {
    // Find (i)th bit of a number.
    public static void main(String[] args) {
        int num = 128, bitNumber = 8; // num = 128 in decimal = 10000000 in binary
        System.out.println(findBit(num, bitNumber));
        System.out.println(findBit2(num, bitNumber));
    }

    // My Approach: using right shift and then & 1
    static int findBit(int num, int bitNumber){
        return (num >> bitNumber - 1) & 1; // First bringing required bit to last place and using & 1 to return it.
    }

    // Kunal Approach: creating a bitmask using left shift and then check if num & bitMask > 0.
    /*
        The approach works by checking whether the returned binary number is greater than 0.
        For example: If num = 10110110
        If required bit = 5,
            bitMask = 1 << (5 - 1) = 1 * (2 to power 4) = 16 = 10000 (in binary, thus adding 4 zeros to right)
            Thus, ans = num & bitMask = 10110110 & 10000 = 10000 = 16
            Since, 16 > 0, required bit i.e. the bit number 5 is '1'
        If required bit = 4,
            bitMask = 1 << (4 - 1) = 1 * (2 to power 3) = 8 = 1000 (in binary, thus adding 3 zeros to right)
            Thus, ans = num & bitMask = 10110110 & 1000 = 0000 = 0
            Since, 0 is not > 0, required bit i.e. the bit number 4 is '0'
     */
    static int findBit2(int num, int bitNumber){
        int bitMask = 1 << bitNumber - 1;  // as the empty spaces will all be filled with zeros.
        convertToBinary(num & bitMask); // The "num & bitMask" will return answer in decimal form
        return ((num & bitMask) > 0)? 1: 0; // If the required bit is 0, whole bitMask = 0 else it is greater than 0
    }

    static void convertToBinary(int num){
        int i = 0, binary = 0, temp = num;
        while(temp > 0){
            int remainder = temp % 2;
            binary += remainder * (int)Math.pow(10, i);
            temp /= 2;
            i++;
        }
        System.out.println("Binary Form of "+num+": "+binary);
    }
}
