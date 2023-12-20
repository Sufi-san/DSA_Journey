package _2_Implementation.Sorting;

import java.util.Arrays;

public class HybridSort {

    // These are the algorithms used by the 'internal' sorting algorithms provided by the particular language
    // Hybrid Sorting algorithms are a collection different types of sorting algorithms (insertions, quick, heap, merge)
    // These are used inside internal sort methods based on what kind of data needs to be sorted.
    // Mostly requires use of 'Merge Sort' + 'Insertion Sort (Works well for partially sorted data)'

    public static void main(String[] args) {
        int[] arr = {25, 62, 16, 61, 73, 1, 62, 0, 19};
        Arrays.sort(arr); // Internal sorting algorithm used by .sort()
        System.out.println(Arrays.toString(arr));
    }
}
