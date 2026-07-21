package _2_Implementation.FunctionsAndMethods;
import java.util.Arrays;
public class VarArgs {  // when we do not know the number of inputs, Variable Arguments.
    public static void main(String[] args) {
        unknownArgs(12.34,34.56,78.90,10.29);
        unknownLast(24, 45, 787, 786, 586, 869);
    }

    static void unknownArgs(double ...v){   // Internally, input is accepted into an array.
        System.out.println(Arrays.toString(v));
        System.out.println(v[0]); // Accessing single element, similar to arrays.
    }

    static void unknownLast(int a, int b, int ...v) { // Variable arguments must always be at the end
        System.out.println(a+" "+b+" "+Arrays.toString(v));
    }
}
