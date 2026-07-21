package _2_Implementation.Maths.Factors_Multiples;

public class EuclideanAlgo {
    /*
        gcd(a, b) = gcd(rem(b, a), a)
        Eg:
            gcd(105, 224) = gcd(rem(224, 105), 105)
                          = gcd(14, 105)
                          = gcd(rem(105, 14), 14)
                          = gcd(7, 14)
                          = gcd(rem(14, 7), 7)
                          = gcd(0, 7)
                          = 7

        Why it works?
            We know by Die-Hard example equation, gcd(105, 224) = min(105x + 224y)
            In 105x + 224y, we can use gcd(a, b) to find the factor, gcd(105, 224) = 7
            Thus, we realise the equation expression as 7(15x + 32y)

            After first iteration of gcd(), "a = 14, b = 105"
            which can be written as 14x + 105y,
            Since we know from "105x + 224y" that 'gcd = 7' and then take '7' common
            in 14x + 105y, we get 7(2x + 15y)
            As we cannot further take common factor for '2' and '15' we realise that
            gcd(14, 105) IS ALSO 7 !!
            Thus, for any given pair of numbers, the 'Euclidean Algorithm' breaks it down
            'linearly' into smaller value pairs, all of which have the same 'hcf/gcd' till
            'a' becomes zero and 'b' becomes the highest common factor itself.
     */
    public static void main(String[] args) {
        int hcf1 = iterativeGCD(3, 5);
        int hcf2 = recursiveGCD(105, 224);

        System.out.println("HCF(3, 5) = "+hcf1+", HCF(105, 224) = "+hcf2);
        System.out.println();

        // Reconfirming by iteration that whether any values of 'x' and 'y' in 'ax + by'
        // can produce the required value (minimum +ve) which will be our hcf
        dieHard(3, 5, hcf1);
        dieHard(224, 105, hcf2);
    }

    // The Euclidean Algorithm
    static int iterativeGCD(int a, int b) {
        while(a != 0){
            System.out.println("a = "+a+", b = "+b);
            int temp = a;
            a = b % a;
            b = temp;
        }
        System.out.println("a = "+a+", b = "+b);
        System.out.println("iterativeGCD Ended.\n");
        return b;
    }

    static int recursiveGCD(int a, int b) {
        System.out.println("a = "+a+", b = "+b);
        if(a == 0) {
            System.out.println("recursiveGCD Ended.\n");
            return b;
        }
        return recursiveGCD(b % a, a);
    }

    static void dieHard(int a, int b, int cf) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        // Above line of code make sure that 'a' is of equal or lesser value to 'b'
        // for the iteration to work successfully

        int x = 1, y = 1;
        System.out.println("x = "+x+", y = "+y);
        while(a * x - b * y != cf && x <= b) {
            x++;
            if(a * x - b * y > cf) y++;
            System.out.println("x = "+x+", y = "+y);
            System.out.println("a * x - b * y = "+(a * x - b * y));
        }
        System.out.println("Die Hard ended.\n");
    }
}
