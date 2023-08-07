package _2_Implementation.Recursion;

public class OptimizedFibonacci {
    public static void main(String[] args) {
        System.out.println("Enter nth term to display corresponding Fibonacci Number: ");
        int num = 0;
        while(num <= 71){ // method 1, works well till 71, method 2 works well till 92
            System.out.println(findFibo(num)+" "+findFibo2(num));
            num++;
        }
    }

    static long findFibo(int n){
        // Using the formula derived by solving Recurrence Relation f(n) = f(n - 1) + f(n - 2)
        // Derived formula is f(n) = 1/sqrt(5) * {[(1+sqrt(5))/2]^n - [(1-sqrt(5))/2]^n}
        double root5 = Math.sqrt(5);
        double term1 = Math.pow((1 + root5)/2, n);
        double term2 = Math.pow((1 - root5)/2, n);
        return (long) ((1/root5) * (term1 - term2));
    }

    static long findFibo2(int n){ // using simple Iteration
        long a = 0, b = 1, temp;
        for(int i = 0; i < n; i++){
            temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }
}
