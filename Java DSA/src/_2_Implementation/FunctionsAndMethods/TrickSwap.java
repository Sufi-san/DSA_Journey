package _2_Implementation.FunctionsAndMethods;

// While wondering whether there was a way to swap primitive variable values using methods in Java, I came across...
public class TrickSwap {
    public static void main(String[] args) {
        int a = 6, b = 9;
        a = trickSwap(b, b = a); // can be read as a = b, b = a.
        System.out.printf("a = %d, b = %d",a ,b);
        // This method works because arguments are read from left to right in Java.
    }

    static int trickSwap(int x, int y){
        return x; // returning the old value of b to the 'a' in main function.
    }
}
