package _2_Implementation.Maths.Factors_Multiples;

public class ModuloProperties {
    /*
        (a + b) % m = ((a % m) + (b % m)) % m
        (a - b) % m = ((a % m) - (b % m) + m) % m
        (a * b) % m = ((a % m) * (b % m)) % m
        (a / b) % m = ((a % m) * (b-inv % m)) % m, where b-inv is a multiplicative modulo inverse

        Eg: (6 * y) % 7 = 1, then here, 'y' is the mmi (multiplicative modulo inverse) for 6

        Thus, mmi = b-inv % m means that 'b' & 'm'  are co-primes(no common factors except 1)

        (a % m) % m = a % m
        (m % m) = 0, for all positive integers
     */
    public static void main(String[] args) {
        int a = 7, b = 6, m = 8;
        System.out.println((a + b) % m +" = "+ ((a % m) + (b % m)) % m);
        System.out.println((a - b) % m +" = "+ ((a % m) - (b % m) + m) % m);
        System.out.println((a * b) % m +" = "+ ((a % m) * (b % m)) % m);
        System.out.println(a % m+" = "+(a % m) % m);
    }
}
