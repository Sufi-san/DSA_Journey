package _2_Implementation.Recursion.Explanations;

import java.util.Arrays;

public class MergeSort {
    /*
        Divide the Array into 2 parts
        These parts will be sorted separately and then merged together into one
        This process can be done Recursively

        Details:
           At Level 1 (Single Array) -> size N = 1 * N = N
           Level 2 (2 Arrays) -> size N/2 + size N/2 = 2 * N / 2 = N
           Level 3 (4 Arrays) -> size N/4 + size N/4 + size N/4 + size N/4 = 4 * N / 4 = N
           .
           .
           .
           Now, as N is following the trend of being divided by (Current Level - 1) power of 2
           we can say that for the last level, say 'k', it will form '2^(k - 1)' arrays of size 'N/(2^(k - 1))'
           .
           .
           Level k (2^(k - 1) Arrays) -> size N/2^(k - 1) + size N/2^(k - 1) + ...
           = (2 ^ (k - 1)) * N / (2 ^ (k - 1)) = N
           Hence, we know that at every level, collective size of arrays = N
           Using this we can find the number of 'Levels'
           We know that, at the last level the size of collected arrays will be N !!
           This means the total time required to traverse & compare all sets of 2 small arrays
           and create a new array of size 'N' will also be 'N' time.

           For level 1, N was divided (Level - 1) times by 2. N / (2 ^ 0)
           For level 2, N was divided (level - 1) times by 2. N / (2 ^ 1)
           Similarly for level k, N is divided (level - 1) times by 2. N / (2 ^ (k - 1))
           At the last level, the size of each small array will become '1'
           Using that logic we can say.
           At last level k, size of small arrays = 1 = N / (2 ^ (k - 1))
           Thus, size of small arrays = 1 is only possible when 'N' divides ITSELF
           Therefore,
                    N = 2 ^ (k - 1)
                    log2(N) = (k - 1)log2(2)
                    log2(N) = k - 1
                    k = log2(N) + 1

           Hence, number of times 'N' will be divided = k times = log2(N) + 1 times
           Thus,
                Time Complexity = Number of levels of division of N * Time required at each level
                                = (log2(N) + 1) * N
                                = Nlog2(N) + N
                                = O(N * log(N))

           Time Complexity: O(N * log(N))
           As 'N' will always be divided, irrespective of whether it is already sorted,
           time complexity will stay the same for 'Worst', 'Best' or 'Average' cases

           The size of array required to combine 2 small arrays of the current level, will
           be the largest at 'Level 1' as it will need to combine 2 arrays of size N/2.
           To fit 2 arrays of N/2 size into a single array, size of that single array
           = N/2 + N/2 = N
           Therefore, the algorithm requires 'N' maximum space to combine the largest subdivisions

           Space Complexity = O(N)

     */
    public static void main(String[] args) {
        // A double data type array is used here, because I wanted to check whether Merge Sort is a Stable Sorting Algo
        // The class MergeSort is used in 'StableUnstableSort' and the type of the array passed is 'double[]'
        // If all the 'double[]' are replaced with 'int[]' and the input array is changed accordingly,
        // the code will still run without errors and perform merge sort successfully
        double[] arr = {5, 4, 3, 2, 1};
        System.out.println("Sorted Array: "+Arrays.toString(new MergeSort().recursiveMergeSort(arr)));
        System.out.println("Original Array: "+Arrays.toString(arr)); // Original Array is not sorted.
        voidMergeSort(arr, 0, arr.length - 1); // Same as recursive merge sort, but changes original array instead of returning new one
        System.out.println("Original Array Sorted: "+Arrays.toString(arr)); // Original Array is sorted.
        // None of the above algorithms, sort the array in-place.
    }

    public double[] recursiveMergeSort(double[] arr) {
        return helper(arr);
    }

    static double[] helper(double[] arr) {
        if(arr.length < 2) return arr; // Required to check if array is empty or contains only 1 element
        int mid = (arr.length - 1) / 2;
         /*
             We need to pass two smaller copies of the array, so we need to create 2 new arrays.
             The size of these new arrays will be determined by the 'mid' of the 1 large array
             Size of first array will be value of (mid + 1) and size of second one will be (arr.length - (mid + 1))
             The elements of the large array will then be appropriately entered in each array
             All of this process is however, simplified by using 'Arrays.copyOfRange(arr, start, end)'
             We are using 'mid + 1' and 'arr.length' as the last index because .copyOfRange() excludes the last
             index while considering the range to be copied
          */
        double[] arr1 = helper(Arrays.copyOfRange(arr, 0, mid + 1));
        double[] arr2 = helper(Arrays.copyOfRange(arr, mid + 1, arr.length));
        return combineArr(new double[arr1.length + arr2.length], arr1, arr2, 0, 0, 0);
    }

    static double[] combineArr(double[] mainArr, double[] arr1, double[] arr2, int i, int j, int k) {
        // Kunal did not use recursion, instead he used simple iteration using while loops for merging.
        // I have also created an 'iterative' combineArr() renamed to 'merge()' below
        if(i == arr1.length && j == arr2.length) return mainArr; // End condition
        if (i == arr1.length) {
            mainArr[k] = arr2[j];
            return combineArr(mainArr, arr1, arr2, i,  j + 1, k + 1);
        }
        else if(j == arr2.length) {
            mainArr[k] = arr1[i];
            return combineArr(mainArr, arr1, arr2, i + 1, j, k + 1);
        }
        else {
            if ((int)arr1[i] <= (int)arr2[j]) {
                mainArr[k] = arr1[i];
                return combineArr(mainArr, arr1, arr2, i + 1, j, k + 1);
            } else {
                mainArr[k] = arr2[j];
                return combineArr(mainArr, arr1, arr2, i, j + 1, k + 1);
            }
        }
    }

    // The merge sort that modifies the original array instead of returning a new one
    static void voidMergeSort(double[] arr, int start, int end) {
        if(end <= start) return;
        int mid = start + (end - start) / 2;
        voidMergeSort(arr, start, mid);
        voidMergeSort(arr, mid + 1, end);
        merge(arr, start, end);
    }

    static void merge(double[] arr, int start, int end) {
        double[] combinedArr = new double[end - start + 1];
        int mid = start + (end - start) / 2;
        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= end) {
            if((int)arr[i] <= (int)arr[j]) {
                combinedArr[k] = arr[i];
                i++;
            }
            else {
                combinedArr[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid) {
            combinedArr[k] = arr[i];
            i++;
            k++;
        }
        while(j <= end) {
            combinedArr[k] = arr[j];
            j++;
            k++;
        }
        for(int x = start, y = 0; x <= end; x++) {
            arr[x] = combinedArr[y];
            y++;
        }
    }
}
