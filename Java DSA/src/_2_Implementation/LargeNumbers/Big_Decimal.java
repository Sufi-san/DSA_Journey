package _2_Implementation.LargeNumbers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Big_Decimal {
    /*
        About BigDecimal: Object -> java.lang.Number -> java.math.BigDecimal
        The Big Decimal is a class similar to Big Integer but made for decimals
        It also addresses the precision problem that we face while performing operations on
        floating point numbers
     */
    public static void main(String[] args) {
        double a = 0.03, b = 0.04;
        System.out.println(a - b); // Has no set precision will contain some error
        BigDecimal a2 = BigDecimal.valueOf(a), b2 = BigDecimal.valueOf(b);
        System.out.println(a2.subtract(b2)); // Provides accurate answer with proper precision

        // Other Operations
        BigDecimal num1 = new BigDecimal("328479832467683465357.948579834");
        BigDecimal num2 = new BigDecimal("224634437827544867.342329");
        System.out.println(num1.add(num2)); // Addition
        System.out.println(num2.subtract(num1).negate()); // Subtraction and Negation
        System.out.println(num1.divide(num2, RoundingMode.FLOOR)); // Division with Rounding
        System.out.println(num1.multiply(num2)); // Multiplication
        System.out.println(num1.pow(2)); // Exponentiation

        // Constants: (Same as BigInteger)
        System.out.println(BigDecimal.ONE + ", "+BigDecimal.TWO+", "+BigDecimal.TEN+", "+BigDecimal.ZERO);
    }
}
