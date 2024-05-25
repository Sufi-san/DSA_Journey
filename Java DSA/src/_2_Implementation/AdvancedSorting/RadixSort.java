package _2_Implementation.AdvancedSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {523, 729, 425, 4, 28, 29, 729, 88, 100, 145, 444, 0};
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int maxNum = arr[0];

        // Sorting using List of Linked Lists for counts
        List<List<Integer>> list = new ArrayList<>();
        for(int num: arr) maxNum = Math.max(maxNum, num);
        for(int i = 0; i < 10; i++) list.add(new LinkedList<>()); // Initializing Linked Lists
        int digits = (int) (Math.log(maxNum) / Math.log(10)) + 1;

        for(int i = 0; i < digits; i++) {
            int divisor = (int) Math.pow(10, i), mod = divisor * 10;
            for(int num: arr) {
                list.get(num % mod / divisor).add(num);
            }
            int j = 0;
            for(List<Integer> numList: list) {
                while(!numList.isEmpty()) {
                    arr[j] = numList.remove(0);
                    j++;
                }
            }
        }
        System.out.println("Sorted Array (List of Linked Lists): "+ Arrays.toString(arr));


        // Sorting using simple integer count array
        for(int i = 0; i < digits; i++) {
            int n = arr1.length;
            int divisor = (int) Math.pow(10, i), mod = divisor * 10;
            int[] counts = new int[10];
            int[] output = new int[n];

            System.out.println("\nOriginal Array: "+Arrays.toString(arr1));

            Arrays.fill(counts, 0); // To reset the in-between cumulative sums inside count array

            // Normally counting frequency using current 10 powers:
            for(int num: arr1) counts[num % mod / divisor]++;
            System.out.println("Initial Count Array: "+Arrays.toString(counts));

            // Taking cumulative sum for counts:
            for(int j = 1; j < 10; j++) counts[j] += counts[j - 1];
            System.out.println("Cumulative Count Array: "+Arrays.toString(counts));

            // Creating current sorted order in 'output' array:
            for(int j = n - 1; j >= 0; j--) {
                int index = arr1[j] % mod / divisor;
                output[counts[index] - 1] = arr1[j]; // -1 due to 0-indexed nature of arrays
                counts[index]--; // decrementing for correct future placements of elements with same digit
            }
            System.out.println("Output Array: "+Arrays.toString(output));

            // Updating original array with current result:
            System.arraycopy(output, 0, arr1, 0, n);
        }
        System.out.println("\nSorted Array (using simple count array): "+Arrays.toString(arr1));
    }
}
