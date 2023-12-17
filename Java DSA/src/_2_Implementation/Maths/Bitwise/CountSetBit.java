package _2_Implementation.Maths.Bitwise;

public class CountSetBit {
    public static void main(String[] args) {
        int num = 511; // 512 that is 1000000000, will require only one iteration in second method
        System.out.println(Integer.toBinaryString(num));
        System.out.println(countSetBit(num));
        System.out.println(countSetBit2(num));
        System.out.println(countSetBit3(num));
    }

    // Basic Method:
    static int countSetBit(int num) {
        int count = 0, iteration = 0;
        while(num > 0){
            System.out.printf("Iterations: %d\n", ++iteration);
            if((num & 1) == 1) count++;
            num = num >> 1;
        }
        return count;
    }

    // Using 2's complement logic from 'RightMostSetBit' and finding the highest power of 2 by log to generate bitMask.
    static int countSetBit2(int num) {
        int count = 0, iteration = 0;
        while(num > 0) {
            System.out.printf("Iterations: %d\n", ++iteration);
            int bitPos = num & (~num + 1); // Found bitMask containing '1' at the place of right-most set-bit
            // Skipping all bits from right including right-most set-bit
            // Here, ~num + 1 is also '-num' that is the 2's comp or negative of the actual number
            num = num >> (int) (Math.log(bitPos) / Math.log(2)) + 1;
            count++;
        }
        return count;
    }

    // Other way using same logic:
    static int countSetBit3(int num) {
        int count = 0, iteration = 0;
        while(num > 0) {
            System.out.printf("Iterations: %d\n", ++iteration);
            num = num - (num & -num);
            // If num = 10110, -num = 01010, num & -num = 10110 & 01010 = 00010 (Right-most set-bit)
            // Now, num - (num & -num) =  10110 - 00010 = 10100 (Right-most set-bit removed)
            count++;
        }
        return count;
    }
}
