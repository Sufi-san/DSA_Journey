package _2_Implementation.Recursion.Explanations;

public class FibonacciNumbers {
    // Find nth Fibonacci Number
    public static void main(String[] args) {
        int num = 46;  // Turns erroneous starting from 47
        int ans = findFibonacci(num, 0, 1);
        System.out.println(ans);
        System.out.println(findFibonacci(num));
    }

    // What I did:
    /*
        Recursive Tree: Linear Structure
     */
    static int findFibonacci(int n, int a, int b){
        if(n > 1){
            return findFibonacci(n - 1, b, a + b); // Head Recursion?
        }
        if(n < 1) return a;
        return b;
    }

    // Kunal Approach
    /*
          Recursive Tree: Linear Recurrence but Multiple Branches
     */
    static int findFibonacci(int n){ // 1 Variable in argument
        if(n > 1){ // 3 Variable in the body
            // 2 Variable being returned (int)
            return findFibonacci(n - 1) + findFibonacci(n - 2); // Sum of fibonacci of previous 2 terms
        }
        // 2 Variable being returned (int)
        return n; // Return 0 or 1 if n is 0 or 1 respectively
    }
    /* CAUTION:
        The above method is very INEFFICIENT.
        The problem however, can be solved by using Dynamic Programming along with Recursion.
        The time complexity is (Golden Ratio ^ n). (Golden Ratio = (1 + sqrt(5))/2) [Covered in detail in Complexity Lecture]
     */
}
