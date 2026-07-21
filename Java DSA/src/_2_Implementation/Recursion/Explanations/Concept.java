package _2_Implementation.Recursion.Explanations;

public class Concept {
    public static void main(String[] args) {
        int n = 5;
        fun(n);
    }

    static void fun(int n) {
        if(n < 1) return;
        System.out.println(n);
        n--;
        fun(n);
        /*
            Concept:
                Instead of 'n--' followed by fun(n), what if we directly do: 'fun(n--)'?
                If we do that, the Recursion will occur INFINITELY.
                Reason? Because unlike 'n = n - 1', 'n -= 1', '--n' which pass the updated
                value of 'n' to the next function call, 'n--' first sends the old value and
                then updates the value for the variable 'n' in its own function body.
                Thus, fun(--n), fun(n -= 1), fun(n = n - 1) will work normally.
         */
    }
}
