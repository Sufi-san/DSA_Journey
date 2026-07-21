package _2_Implementation.Maths.Factors_Multiples;

public class NewtonRaphson {
    public static void main(String[] args) {
        int num = 10800, precision = 3;
        double ans = newtRaph(num, precision);
        double ans2 = newtRaph2(num, precision);
        String ansStr = "%." + precision + "f";
        System.out.printf(ansStr, ans);
        System.out.printf("\n"+ansStr, ans2);
        System.out.printf("\n"+ansStr, Math.sqrt(num)); // The standard method
    }

    // My approach after understanding the formula from other sources
    static double newtRaph(int num, int precision) {
        double root = num, x = 0, errorLimit = 1/(Math.pow(10, precision)), error = errorLimit + 1;
        while(root * root > num && error > errorLimit) {
            x = root;
            root = x - (x * x - num) / (2 * x); // Applying the formula
            error = x - root; // Checking error
            // System.out.println(root);
        }
        return x;
    }

    // Using the form of the formula that Kunal mentioned.
    // Time Complexity: O(logN * F(N)) where F(N) = cost of calculating f(n)/f'(n) with 'n' digit precision
    static double newtRaph2(int num, int precision) {
        double root = num, x = 0, errorLimit = 1/(Math.pow(10, precision)), error = errorLimit + 1;
        while(root * root > num && error > errorLimit) {
            x = root;
            root = (x + num / x) / 2; // Applying the formula
            error = x - root; // Checking error
            // System.out.println(root);
        }
        return x;
    }
}
