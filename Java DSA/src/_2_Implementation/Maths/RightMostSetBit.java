package _2_Implementation.Maths;

public class RightMostSetBit {
    // Find the position of right-most set-bit.
    public static void main(String[] args) {
        int num = 10110000; // Here we know that position of right most set bit is 5 (1-indexed)
        System.out.println(findRMSetBitPos(num));
        System.out.println(findFirstSetBitPos(SetBit.convertToBase10(num)));
    }

    // My Approach: Using for loop with increasing right shift
    /*
        Every time a right shift occurs, the decimal counter-part gets divided by 2.
        The '& 1' then checks whether it is an odd or even number after division and all odd numbers have LSB as 1.
        This is the reason why My Approach works even though 'num' is an integer and not exactly binary.
     */
    static int findRMSetBitPos(int num){
        for(int i = 0; i < 32; i++){
            /* Uncomment to see the working in output
                System.out.println(num >> i); // The integer gets divided by 2
                System.out.println(num >> i & 1); // Checks whether it is even or odd
            */
            if((num >> i & 1) == 1) return i + 1; // If odd return number of divisions performed
        }
        return -1; // set bit does not exist
    }

    // Kunal Approach: & the number with its negative counter-part (2's complement in binary gives negative)
    /*
        2's Complement = 1's Complement + 1
        Why will it work?
        A method to convert a number to negative (its 2's complement) involves going from the LSB towards the
        MSB without doing anything, UNTIL the FIRST SET BIT(1) is found and after that taking complement of
        all bits till MSB including the first set bit.
        Thus, we just reverse the process and '&' the number with its negative(2's complement) to get position of
        the FIRST SET BIT(1).
        However, we still just have the bit mask with the required position but not the actual position.
        But, we can get the actual position by finding log base 2 of the integer counter-part and adding 1 to it.
        It basically means that we are finding which power of 2 is 1 at, and as the powers start from 0, we add 1
        to get actual 1-indexed position.
     */
    static int findFirstSetBitPos(int num){
        int posInt = num & (~num + 1);
        // posInt is in Integer form, so we find which power of 2 it is
        return (int) (Math.log(posInt)/Math.log(2)) + 1; // Formula for finding log2(posInt) = ln(posInt)/ln(2)
        // +1 since, powers of 2 are 0-indexed in conversions
    }
}
