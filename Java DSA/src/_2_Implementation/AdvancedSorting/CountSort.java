package _2_Implementation.AdvancedSorting;

import java.util.Arrays;
import java.util.HashMap;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 9, 10, 17, 5, 16, 1, 8, 8, 10, 11, 12};
        int[] arr1 = Arrays.copyOf(arr, arr.length);

        System.out.println("Unsorted Array: "+Arrays.toString(arr));

        // Using another frequency array
        if(!(arr == null || arr.length <= 1)) {
            int maxNum = arr[0], minNum = Arrays.stream(arr).min().getAsInt();
            for(int num: arr) maxNum = Math.max(maxNum, num);
            int[] freqArr = new int[maxNum + 1];
            for(int num: arr) freqArr[num]++;
            for(int i = minNum, j = 0; i < freqArr.length; i++) {
                while(freqArr[i] > 0) {
                    arr[j] = i;
                    j++;
                    freqArr[i]--;
                }
            }
        }
        System.out.println("Sorted Array: (Using Frequency Array)"+Arrays.toString(arr));

        // Using HashMap:
        if(!(arr1 == null || arr1.length <= 1)) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxNum2 = Arrays.stream(arr1).max().getAsInt(), minNum2 = arr[0];
            for(int num: arr1) {
                minNum2 = Math.min(minNum2, num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for(int i = minNum2, j = 0; i <= maxNum2; i++) {
                int count = map.getOrDefault(i, 0);
                while(count > 0) {
                    arr1[j] = i;
                    j++;
                    count--;
                }
            }
        }
        System.out.println("Sorted Array (using HashMap): "+Arrays.toString(arr1));
    }
}
