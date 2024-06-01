package _2_Implementation.SqrtDecomposition;

import java.util.Arrays;

public class SqrtDec {
    public static void main(String[] args) {
        int[] nums = {15, 18, 44, 11, 91, 24, 58, 19, 78, 90, 41, 29, 58, 27, 72};
        System.out.println("Original Array: "+Arrays.toString(nums));
        int[] processed = preprocess(nums); // Getting the processed array
        System.out.println("Processed chunks: "+Arrays.toString(processed));

        int[][] queries = {{2, 12}, {3, 5}, {11, 7}, {7, 9}, {6, 13}};
        ansQuery(queries, nums, processed);

        // Updating the array and chunks
        arrayUpdate(4, 19, nums, processed);
        arrayUpdate(7, 25, nums, processed);
        arrayUpdate(9, 51, nums, processed);
        System.out.println("Updated Array: "+Arrays.toString(nums));
        System.out.println("Updated Chunks: "+Arrays.toString(processed));
        ansQuery(queries, nums, processed);
    }

    static int[] preprocess(int[] nums) {
        double sqrt =  Math.sqrt(nums.length); // To divide the array into chunks of square root size
        int[] processed = new int[(int)Math.ceil(nums.length / sqrt) + 1];
        // As we need equal elements in all chunks and no original element should be left out,
        // we take 'ceil' of the division

        for(int i = 0; i < processed.length; i++) {
            int sum = 0, start = i * (int) sqrt, end = start + (int)sqrt;
            // 'start' is found by conversion of the chunk's index by multiplying square root value
            // 'end' is simply the current index plus number of required elements in chunk (the square root).

            for(int j = start; j < end; j++) sum += (j < nums.length)? nums[j]: 0; // Accounts for extra elements
            processed[i] = sum; // Entering data in chunks array
        }
        return processed;
    }

    static void ansQuery(int[][] queries, int[] nums, int[] chunks) {
        for(int[] query: queries) {
            System.out.println("Query Range: "+Arrays.toString(query));
            System.out.println("Result: "+ansQuery(query, nums, chunks)); // Answering Queries in less time
            // Each query will take O(sqrt(N)) time
        }
    }

    static long ansQuery(int[] query, int[] nums, int[] chunks) {
        long sum = 0;
        if(nums.length == 0) return 0;
        int start = query[0], end = query[1], sqrt = (int)Math.sqrt(nums.length);
        if(start < 0 || start > nums.length || end < 0 || end > nums.length || end < start) {
            System.out.println("Out of Range");
            return 0;
        }
        while(start % sqrt != 0) { // Keep adding elements till we are not at the start of a chunk
            sum += nums[start];
            start++;
        }
        while((start + sqrt - 1) <= end) { // Keep adding chunk values till 'end' is not inside current chunk
            int index = (start + sqrt - 1) / sqrt;
            sum += chunks[index];
            start += sqrt;
        }
        while(start <= end) { // Keep adding elements till the 'end' index inside current chunk is not reached
            sum += nums[start];
            start++;
        }
        return sum;
    }

    static void arrayUpdate(int index, int newVal, int[] nums, int[] chunks) {
        if(index < 0 || index >= nums.length) {
            System.out.println("Index "+index+" Out of Range.");
            return;
        }
        int chunkInd = index / (int)Math.sqrt(nums.length);
        chunks[chunkInd] = chunks[chunkInd] - nums[index] + newVal;
        nums[index] = newVal;
    }
}
