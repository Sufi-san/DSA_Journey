package _2_Implementation.Recursion.Explanations;

import java.util.Arrays;

public class QuickSort {
    /*
        Quick Sort makes use of an important reference point called 'pivot'.
        It can be any element chosen from inside the search space or array

        Quick Sort also makes use of divide and conquer approach similar to that of Merge Sort
        However, it does not 'merge' the solutions, instead the concept of using 'pivot' is
        recursively applied in each subdivision and thus no extra space is required for
        'merging' the solutions together.
        Therefore, Quick Sort is also generally in-place.

        Role of Pivot:
            - After each pass, the elements which are less than pivot element are sent
              to the left of the pivot and the one greater than pivot are sent to the right
            - MAJOR POINT: After each pass, the selected 'pivot' will be at its correct position !
            - After the pivot is sorted, the rest of the array, that is 'start' to 'current pivot index - 1' and
              'current pivot index + 1' to 'end' are sent to the next function calls to find their 'pivots' and
              sort them (Recursion takes place)

        Recurrence Relation for Quick Sort:
            For an array of size 'N': [....k elements....| PIVOT element |.....(N - k - 1) elements...]
            T(N) = T(k) + T(N - k - 1) + N, 'N' because it is the time taken to place pivot at correct position.

        Different Cases:
         i) Worst Case: The largest element is selected as the pivot. (Size in next call reduced by only 1) (N - 1)
                        Here, value of 'k' will be zero
                        And, N - k - 1 = N - 0 - 1 = N - 1
                        T(N) = T(0) + T(N - 1) + N
                        Above recurrence relation can be solved by substitution to find out that,
                        T(N) = N^2 - N -> O(N^2)
            Therefore, Time Complexity in Worst Case = O(N ^ 2)
        ii) Best Case: The middle element is selected as the pivot. (Size in next call reduced by half + 1) ((N / 2) - 1)
                       Here, value of 'k' will be '(N / 2) - 1' or '(N / 2)', as pivot or mid will be excluded
                       And, N - k - 1 = N - ((N / 2) - 1) - 1 = N - (N / 2) + 1 - 1 = N - (N / 2) = N / 2
                       T(N) = T((N / 2) - 1) + T(N / 2) + N
                       The '(N / 2) - 1' can be considered '(N / 2)' due to '-1' having less significance
                       Above recurrence relation can be solved by Akra-Bazzi to find out that,
                       T(N) = N + N * log(N) -> O(N * log(N))
            Therefore, Time Complexity in Best Case = O(N * log(N))
        iii) Average Case: O(N * log(N))

        Other important notes:
        - Quick Sort is not a Stable sorting algorithm
        - It as an in-place sorting algorithm, does not take extra space
        - Unlike Arrays, Linked Lists do not have contiguous memory allocation, Merge Sort is better suited for
          linked lists while Quick Sort is preferred for Arrays.
     */
    public static void main(String[] args) {
        double[] arr = {5, 5, 4, 8, 8, 3, 1, 1, 7, 1};
        System.out.println("Original Array: "+Arrays.toString(arr));
        new QuickSort().quickSort(arr);
        System.out.println("Array after Quick Sort: "+Arrays.toString(arr)); // Original Array is sorted in-place
    }

    public void quickSort(double[] arr) {
        helper(arr, 0, arr.length - 1);
    }

    public void quickSort_noComments(double[] arr) {
        helper_noComments(arr, 0, arr.length - 1);
    }

    static void helper(double[] arr, int start, int end) {
        if(start >= end) return;
        double pivot = arr[start]; // Selecting random index element as pivot
        // start + (int)((end - start + 1) * Math.random())
        int i = start, j = end;
        System.out.println("Start = "+start+", End = "+end+", Pivot Element = "+pivot);
        // We can also use:
            /*
                while(i < j) {
                    while(arr[i] < pivot) i++;
                    while(arr[j] > pivot) j++;
                    swap(arr, i, j);
                }
                helper(arr, start, i - 1);
                helper(arr, i + 1, end);
             */
        // But it will not work when there are duplicate values inside the search space
        while(i <= j) {
            while((int)arr[i] < (int)pivot) i++;
            while((int)arr[j] > (int)pivot) j--;
            // As swapping happens before the next 'while' check, we need to ensure that (i <= j) again before swapping
            // If we do not, then there is the chance of our 'pivot' element swapping again from correct position
            if(i <= j) {
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            System.out.println(Arrays.toString(arr));
        }
        helper(arr, start, j);
        helper(arr, i, end);
    }

    static void helper_noComments(double[] arr, int start, int end) {
        if(start >= end) return;
        double pivot = arr[start + (int)((end - start + 1) * Math.random())]; // Selecting random index element as pivot
        int i = start, j = end;
        while(i <= j) {
            while((int)arr[i] < (int)pivot) i++;
            while((int)arr[j] > (int)pivot) j--;
            if(i <= j) {
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        helper_noComments(arr, start, j);
        helper_noComments(arr, i, end);
    }
}
