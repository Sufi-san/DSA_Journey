package _2_Implementation.Maths.Bitwise;

public class RightMostSetBit {
    // Find the position of right-most set-bit.
    public static void main(String[] args) {
        int num = 182;
        // 182 (Decimal) = 10110110 (Binary) Here we know that position of right most set bit is 2 (1-indexed reference)
        System.out.println(findRMSetBitPos(num));
        System.out.println(findFirstSetBitPos(num));
    }

    // My Approach: Using for loop with increasing right shift
    static int findRMSetBitPos(int num){
        if(num <= 0) return -1; // set bit does not exist
        for(int i = 0; i < 32; i++){
            /* Uncomment to see the working in output
                System.out.println(num >> i); // The integer gets divided by 2
                System.out.println(num >> i & 1); // Checks whether it is even or odd
            */
            // At one point when any closest existing set bit reaches the LSB the num will be odd
            if((num >> i & 1) == 1) return i + 1; // If odd return number of divisions performed
        }
        return -1; // set bit does not exist
    }

    // Kunal Approach: & the number with its negative counter-part (2's complement in binary gives negative)
    /*
        2's Complement = 1's Complement + 1
        Why will it work?
        A different way to look at the method to convert a number to negative counter-part (its 2's complement)
        involves going from the LSB towards the MSB without doing anything, UNTIL the FIRST SET BIT(1) is found
        and after that taking complement of all bits till MSB excluding the first set bit.
        Thus, we just reverse the process and '&' the number with its negative(2's complement) to get position of
        the FIRST SET BIT(1).

        Eg: Number = 10110110
            2's Comp = 01001001 + 1 = 01001010
            10110110 & 01001010 = 00000010 (bit mask with position of set bit found)

        However, we still just have the bit mask with the required position but not the actual position.
        But, we can get the actual position by finding log base 2 of the integer counter-part and adding 1 to it.
        It basically means that we are finding which power of 2 is 1 at, and as the powers start from 0, we add 1
        to get actual 1-indexed position.

        Eg: bitMask = 00000010 = 2 (in Decimal)
            Which power of 2 is 2 ? => (int) Math.log2(2) + 1 = 1 + 1 = 2
            Position of Right Most Set Bit = 2
     */
    static int findFirstSetBitPos(int num){
        int posInt = num & (~num + 1);
        // posInt is in Integer form, so we find which power of 2 it is
        return (int) (Math.log(posInt)/Math.log(2)) + 1; // Formula for finding log2(posInt) = ln(posInt)/ln(2)
        // +1 since, powers of 2 are 0-indexed in conversions
    }
}
