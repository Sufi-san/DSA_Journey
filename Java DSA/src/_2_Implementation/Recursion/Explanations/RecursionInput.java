package _2_Implementation.Recursion.Explanations;
import java.util.Scanner;
import java.util.Arrays;

public class RecursionInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[3];
        takeInput(arr, 0, in);
        System.out.println(Arrays.toString(arr));
    }

    static int[] takeInput(int[] arr, int index, Scanner in){  // Taking Array Input using Recursion
        if(index < arr.length){
            arr[index] = in.nextInt();
            return takeInput(arr, index + 1, in);
        }
        return arr;
    }
}
