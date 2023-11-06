package _2_Implementation.Searching.LinearSearch;
import java.util.Arrays;

public class ExcludedProduct {
    // Given array {a, b, c, d} we have to return {b * c *d, a * c * d, a * b * d, a * b * c}
    /* Naive or Brute Force approach will take O(N^2) time:
        The approach will be to run an outer loop to traverse through all elements
        And an inner loop to find product of all elements excluding the element at current outer loop index
        At the end of the inner loop, the product will be stored at the appropriate index and returned as a new array.
        This approach takes O(N) extra space as well, since we return a new array, as modifying the original array
        may lead to corrupted data for next iteration.
     */
    /* A further optimized approach will take O(N) time:
        We run two loops (linear searches).
        The first loop will calculate and store the overall product of all elements in the array
        The second loop will again iterate through all elements but this time, it will replace them
        The replacement will be the quotient of a division, the overall product divided by element at current index
        This method also only takes O(1) extra space as we are just modifying the original array and there is no
        corruption of data affecting the next result.
     */
    public static void main(String[] args) {
        int[] arr1 = {5, 7, 1, 4, 9};
        System.out.println("By Naive Approach: "+Arrays.toString(naiveMethod(arr1)));
        System.out.println("By Better Approach: "+Arrays.toString(betterMethod(arr1)));
    }

    static int[] naiveMethod(int[] arr){
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int excluded_product = 1;
            for(int j = 0; j < arr.length; j++){
                excluded_product = (j != i)? excluded_product * arr[j]: excluded_product;
            }
            ans[i] = excluded_product;
        }
        return ans;
    }

    static int[] betterMethod(int[] arr){
        int tot_product = 1;
        for(int element: arr){
            tot_product *= element;
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = tot_product/arr[i];
        }
        return arr;
    }
}
