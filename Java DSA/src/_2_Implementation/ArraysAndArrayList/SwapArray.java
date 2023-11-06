package _2_Implementation.ArraysAndArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class SwapArray {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int[] arr = {1,3,4,7,11};
        System.out.println("Array before swapping: "+Arrays.toString(arr));
        System.out.println("Enter 2 indices to swap elements: ");
        System.out.print("Index 1: ");
        int index1 = s1.nextInt();
        System.out.print("Index 2: ");
        int index2 = s1.nextInt();
        swap(arr, index1, index2);
        System.out.println("Array after swapping: "+Arrays.toString(arr));
    }

    static void swap(int[] array, int i1, int i2){
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}
