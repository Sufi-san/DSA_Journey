package _2_Implementation.Maths.Bitwise;

public class FindIfPowerOf2 {
    // Find whether given number is a power of 2 or not
    public static void main(String[] args) {
        int num = 0;
        System.out.printf("Is %d a power of 2?: %b", num, findIfPowerOf2(num));
        System.out.printf("\nIs %d a power of 2?: %b", num, findIfPowerOf2_Kunal(num));
        System.out.printf("\nIs %d a power of 2?: %b", num, findIfPowerOf2_Kunal2(num));
    }

    // For a number to be a power of 2, only its MSB must be 1.
    /* Naive Approach:
        If num = 0, return false
        Perform right shift in a loop while number is greater than zero
        Check the last digit each time by using num & 1.
        If '1' is found more than once, the number is not a pure power of 2, return false
        If loop ends successfully return true
     */
    /* My Approach:
        If n = number, we can check whether (log(n)/log(2)) is a whole number or not.
     */
    static boolean findIfPowerOf2(int num){
        double numLog2 = (Math.log(num)/Math.log(2));
        return (numLog2 - (int) numLog2) == 0;
    }

    /* Kunal Approach: (Exception, does not work for 0)
        We know that ONLY a power of 2 can be written as its binary form's complement + 1
        (i.e. same 2's complement)
        Thus, if num = power of 2 given,
        then if num & (~num + 1) == num, then given number is a power of 2, else it is not a power of 2

        Example:
        10110:
        10110 & (01001 + 1) = 10110 & 01010 = 00010 != 10110, thus not a power of 2
        10000:
        10000 & (01111 + 1) = 10000 & 10000 = 10000 = 10000, thus it is a power of 2

     */
    static boolean findIfPowerOf2_Kunal(int num){
        if (num == 0) return false;
        return (num & (~num + 1)) == num;
    }

    // Kunal Approach in a different way:
    /*
        if num & (num - 1)  == 0, because if num is a power of 2, then num - 1 will be complement of that number
        Example:

        10000:
        10000 = 1111 + 1, hence, 10000 - 1 = 1111
        Now, 10000 & (10000 - 1) = 10000 & 01111 = 00000, hence 10000 is a power of 2

        11010:
        11010 - 1 = 11010 + 11111 = 111001
        Now, 11010 & (11010 - 1) = 011010 & 111001 = 011000 != 0, hence 11010 is not a power of 2
     */
    static boolean findIfPowerOf2_Kunal2(int num){
        if (num == 0) return false;
        return (num & (num - 1)) == 0;
    }
}
