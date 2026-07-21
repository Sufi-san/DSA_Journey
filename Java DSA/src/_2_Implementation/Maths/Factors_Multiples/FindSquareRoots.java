package _2_Implementation.Maths.Factors_Multiples;

public class FindSquareRoots {
    public static void main(String[] args) {
        int num = 27, precision = 7;

        // Roots for perfect squares
        System.out.println(findSqrt(num));
        System.out.println(findSqrt2(num));

        // Roots for imperfect squares with precision:
        System.out.println(findSqrtWithPrec(num, precision));
        String precisionStr = "%." + precision + "f";
        System.out.printf(precisionStr, findSqrtWithPrec2(num, precision));
    }

    // Naive Approach:
    static long findSqrt(int num) {
        int ans = 0;
        while(ans * ans < num) ans++;
        if(ans * ans != num) ans--;
        return ans;
    }

    // Using Binary Search:
    static long findSqrt2(int num) {
        long start = 0, end = num, mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(mid * mid > num) {
                end = mid - 1;
            }
            else if(mid * mid < num) {
                start = mid + 1;
            }
            else return mid;
        }
        return (mid * mid > num)? mid - 1: mid;
    }

    static double findSqrtWithPrec(int num, int precision) {
        double ans = 0, divisor = 1;
        for(int i = 0; i <= precision; i++) {
            while((ans / divisor) * (ans / divisor) < num) {
                ans++;
            }
            if((ans / divisor) * (ans / divisor) != num) ans--;
            divisor *= 10;
            ans *= 10;
        }
        return ans / divisor;
    }

    /*
        We can also consider the numbers appearing after point as a whole instead of digit-by-digit
        and find appropriate precision by dividing appropriately by powers of precision and incrementing
        count by 1 in each iteration.
        But that takes a very long time for larger inputs.
        Eg: for precision = 4 = n, we can search for a 4-digit num between 0 - 9999, Complexity: O(10^n)
            or we can search for single digit between 0 - 9, 4 times. Complexity: n * 10 = O(n)

        However, in binary search both approaches are valid. They have the same time complexity.
        Eg: for precision = 4 = n, we can apply binary search to find 4-digit num between 0 - 9999
            Complexity: log(10^n) = n * log10 = O(n)
            or we can search for single digit between 0 - 9, by binary search 4 times.
            Complexity: n * log10 = O(n)

        But, kunal didn't use the binary search approach for finding the precision digits and just found
        the main integer using binary search and the count method for finding rest of the digits.
     */

    static double findSqrtWithPrec2(int num, int precision) {
        double root = findSqrt2(num), incr = 0.1;
        for(int i = 1; i <= precision; i++) {
            while(root * root <= num) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return root;
    }
}
