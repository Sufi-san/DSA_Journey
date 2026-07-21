package _2_Implementation.LargeNumbers;

import java.math.BigInteger;

public class Big_Integer {
    /*
        Important Note:
            For implementation information it is better to refer to documentation for better exploration
            and understanding of the class and its objects as well as the methods involved.
            It is not something that needs to be taught to someone, as one can easily read and understand
            the documentation that provides complete overview.

        BigInteger Class: Object -> java.lang.Number -> java.math.BigInteger
            This is the class used for handling large numeric values
            It extends the Number class and implements the Comparable interface

        Range of Big Integer:

            -2 ^ (Integer.MAX_VALUE) to 2 ^ (Integer.MAX_VALUE)   {Both are exclusive}
            i.e ->   -2^((2^31) - 1) to 2 ^ ((2^31) - 1)

        If this range is crossed, Big Integer being a class, throws a null pointer exception
     */
    public static void main(String[] args) {
        // Self Exploration through trial & error:
        BigInteger bi = new BigInteger("3498984712348972418972349878"); // Storing large integers
        BigInteger bi2 = new BigInteger("23987248712384");
        System.out.println(bi.add(bi2)); // Using the add method to add 2 Big Integers
        System.out.println(bi.subtract(bi2)); // Using the subtract method to subtract from a Big Integer
        System.out.println(bi.multiply(bi2)); // Using the multiply method to multiply 2 Big Integers
        System.out.println(bi.divide(bi2)); // Using the divide method to divide Big Integer
        System.out.println(bi.remainder(bi)); // Returns the remainder and also accepts negative arguments
        System.out.println(bi.mod(bi)); // Same as remainder, but does not accept negative arguments
        System.out.println(bi2.negate()); // Turns number negative
        // .... And many other methods like bit operations, exponents and logs
        // Note: In all of above methods, the original value in Big Integer object stays intact and
        //       a new Big Integer object with new value is returned when operations are performed
        System.out.println();

        // Finding large factorials using BigInteger Objects and using StringBuffer for formatting
        int num = 1000;
        StringBuffer strB = new StringBuffer(factorial(num).toString());
        for(int i = 150; i < strB.length(); i += 150) strB.replace(i, i + 1, strB.charAt(i) + "\n");
        System.out.println(strB);
        System.out.println();

        // Exploring as per Kunal's Instructions
        // Working directly with numeric values instead of strings:
        BigInteger num1 = BigInteger.valueOf(29348327832L);
        System.out.println(num1);
        System.out.println();

        // Constants
        System.out.println(BigInteger.ONE +", "+BigInteger.TWO+", "+BigInteger.TEN+", "+BigInteger.ZERO);
        System.out.println();

        // Converting Big Integer to int or long:
        BigInteger bi3 = BigInteger.valueOf(Integer.MAX_VALUE).add(BigInteger.ONE);
        System.out.println(bi3.intValue()); // should return Integer.MIN_VALUE due to modulo typecasting
        System.out.println(bi3.longValue()); // should return Integer.MAX_VALUE + 1
        System.out.println();

        // Comparisons:
        // num1.compareTo(num2)
        // returns 1 if num1 > num2
        // returns -1 if num1 <= num2
        // returns 0 if num1 == num2
        System.out.println("bi = "+bi+", bi2 = "+bi2);
        System.out.println("bi.compareTo(bi2) = "+bi.compareTo(bi2)); // 1
        System.out.println("bi2.compareTo(bi) = "+bi2.compareTo(bi)); // -1
        System.out.println("bi2.compareTo(bi2) = "+bi2.compareTo(bi2)); // 0
    }

    static BigInteger factorial(int num) {
        // We can also use recursion, but for some large factorials (above 13000!) we encounter StackOverflow Error
        BigInteger ans = BigInteger.ONE;
        for(int i = 1; i <= num; i++) ans = ans.multiply(BigInteger.valueOf(i));
        return ans;
    }
}
