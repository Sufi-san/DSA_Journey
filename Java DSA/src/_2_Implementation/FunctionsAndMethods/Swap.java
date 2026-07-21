package _2_Implementation.FunctionsAndMethods;

public class Swap {
    public static void main(String[] args) {
        int m = 30;
        int n = 56;
        System.out.println("Before Swap: m = "+m+", n = "+n);
        swap(m,n);  // Will not swap in main function as only value is passed.
        // In above case i.e. for primitive data types, always a copy of the value is passed.
        // In this case, the copy is used to create another literal, which the variables in function point to.
        // However, for complex or non-primitive data types, we pass by value OF the reference variable(actual reference).
        System.out.println("In main function, After Swap: m = "+m+", n = "+n);
    }

    static void swap(int m, int n) {  // In Java there is no Pass by Reference.
        int temp;
        temp = m;
        m = n;
        n = temp;
        System.out.println("In swap function, After Swap: m = "+m+", n = "+n);
    }
}
