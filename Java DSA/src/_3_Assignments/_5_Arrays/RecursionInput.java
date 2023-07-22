package _3_Assignments._5_Arrays;
import java.util.Scanner;
import java.util.Arrays;

public class RecursionInput {
    public static void main(String[] args) {
        int[] arr = new int[3];
        arr = takeInput(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    static int[] takeInput(int[] arr, int index){  // Taking Array Input using Recursion
        Scanner in = new Scanner(System.in);
        if(index < arr.length){
            arr[index] = in.nextInt();
            return takeInput(arr, index + 1);
        }
        else
            return arr;
    }
}
