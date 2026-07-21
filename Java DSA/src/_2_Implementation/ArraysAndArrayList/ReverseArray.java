package _2_Implementation.ArraysAndArrayList;
import java.util.Arrays;
public class ReverseArray {
    public static void main(String[] args) {
       int[] arr = {34,56,78,99,100,34,88};
       System.out.println("Normal Array: "+Arrays.toString(arr));
       reverseArray(arr);
       System.out.println("Reversed Array: "+Arrays.toString(arr));
       reverseArray2(arr); // nullifying the reversal effect by reversing again
       System.out.println("Reversed Again: "+Arrays.toString(arr));
    }

    static void reverseArray(int[] array){ // method 1: run loop array.length/2 times
        for (int i = 0; i < array.length/2; i++) {
            SwapArray.swap(array, i, (array.length - 1 - i));  // No import needed as class file is in same package.
        }
    }

    static void reverseArray2(int[] array){ // method 2: two-pointer method
        int low = 0, high = array.length - 1;
        while(low < high){
            SwapArray.swap(array, low, high);
            low++;
            high--;
        }
    }
}
