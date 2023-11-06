package _2_Implementation.Basic;
import java.util.Scanner;

//IMP Link: https://bytesofgigabytes.com/IMAGES/java/typeConversionJava/CompatibleDataTypes.png
// Automatic conversion happens in order: byte -> short -> int -> long -> float -> double
/* char and boolean exceptions: (tested in Java 11)

    char is automatically converted to int, long, float and double.
    char can be converted to byte or short but requires typecasting. (due to default 'int' conversion)
    byte, short, int, long, float, double can also be converted to char they too require typecasting. (float & double get rounded-off)

    nothing can be directly converted to boolean or from boolean.
    for such conversions, ternary operators are required.
    e.g:
    boolean b = true or boolean b = false;
    int x = b ? 1 : 0; // gives 1 for true and 0 for false
    to convert other data types to boolean we use logical operators.
    e.g:
    int x = 42;
    boolean b = (x == 42); // sets value for boolean 'b' as true.

 */
public class TypeConversion_Casting {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        // When few conditions are met, automatic type conversions take place
        // 1) The two data types should be compatible. eg: int converted to float
        System.out.println("Enter a number: ");
        float var = s1.nextFloat();  // If integer is given, it gets converted to float
        System.out.println(var);

        // 2) The destination type should be greater than the source type. eg: float cannot be automatically converted to int
        // TypeCasting: Narrowing Conversion (to convert into different data type even when condition is not fulfilled)
        int num = (int)(var); // Float variable type-casted into integer
        System.out.println(num);
        /* Note: Only Floating point 'literals' cannot get converted to integers without typecasting however,
                 if a float or double value is to be generated from an expression evaluation, it can get converted
                 to int automatically without typecasting !! (The expression itself should not contain float/double
                 variables/literals.)
                 e.g:
                 int num = s1.nextFloat(); or int num = 45.6;   (will generate errors)
                 int num = 456/10;  (will not generate errors and value of 'num' will be 45)
                 int num = 456/10.0; (will generate errors)
         */

        // Automatic type promotion in expressions
        byte byt = (byte)(num); // will return (num % 256)
        char chr= (char) 65633; // will return (65633 % 65536)
        short a = 40;
        byte b = 6;
        byte c = 40;
        int x = (a * c) + b; // java automatically converts byte or short evaluations(eg: (a*c)) to int (no typecasting needed)
        System.out.println("Byt = "+byt+", x = "+x+", chr = "+chr);

        int alpha = 'A';  // As java follows unicode, 'A' will return 65;
        System.out.println(alpha);
        /* Rules for promotion:
        All the byte,short and character values are promoted to integer
        If one of the operands is long, whole operation returns long, same for float and double.
         */

        // Great Example:
        byte _byte = 100;
        short _short = 456;
        int _int = 1000;
        char _char = 'a';
        float _float = 78.97f;
        long _long= 4500000L;
        double _double = 345678.98756;
        double result = (_byte*_float) + (_double / _int) - (_long/_char) + (_short);
        // even though, '_long/_char' should return a double or float value, due to the rule only long type is returned.
        // to make it return the exact double value, we will need typecasting i.e. ((double) long/_char).
        // thus, for above expression we have float + double - long + short = double
        // IMP (type determining for evaluations): 1) double > float > long > int, 2) all char, short and byte = int
        System.out.println((_byte*_float) +" + "+ (_double / _int) +" - "+ (_long/_char)+" + "+(_short));
        System.out.println((_long/_char)+ " is of type "+(((Object)(_long/_char)).getClass().getSimpleName()));
        System.out.println(result);


    }
}
