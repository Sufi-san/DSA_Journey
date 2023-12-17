package _2_Implementation.Maths.Bitwise;

public class PowerCalculator {
    public static void main(String[] args) {
        int base = 3, power = 8;
        System.out.println(powerMethod1(base, power));
        System.out.println(powerMethod2(base, power));
    }

    // Obvious Method:
    static int powerMethod1(int base, int power) {
        int ans = 1;
        for(int i = 0; i < power; i++){
            ans *= base;
        }
        return ans;
    }

    // Doubling base in each iteration and multiplying into base into answer when bit is 1.
    static int powerMethod2(int base, int power) {
        int ans = 1;
        while(power > 0) {
            if((power & 1) == 1) {
                ans *= base;
            }
            base *= base;
            power = power >> 1;
        }
        return ans;
    }

}
