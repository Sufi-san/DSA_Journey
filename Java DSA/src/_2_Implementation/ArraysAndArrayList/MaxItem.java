package _2_Implementation.ArraysAndArrayList;
import java.util.Arrays;

public class MaxItem {
    public static void main(String[] args) {
        int[] arr = {1,93,23,99,18};
        int max = max(arr);
        System.out.println("In the array: "+Arrays.toString(arr));
        System.out.println(max+" is the maximum element.");
    }
    static int max(int[] arr){
        int maximum = arr[0];  // Initializing maximum with assumption that first array element is maximum
        for(int element1: arr){
                if(element1 >= maximum){
                   maximum = element1;
                }
        }
        return maximum;
    }
}
