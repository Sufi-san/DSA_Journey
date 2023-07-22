package _2_Implementation.Searching.BinarySearch;

class Leetcode410{
    public static void main(String[] args) {
        Solution obj = new Solution();
        int answer = obj.splitArray(new int[]{7, 8, 8, 8, 6}, 4);
        System.out.println(answer);
    }
}

class Solution {
    public int splitArray(int[] nums, int k) {
        int start = arrayMax(nums); // condition when k is nums.length
        int end = arraySum(nums); // condition when k is 1, hence range found
        int ans = start;
        while(start != end){
            int sum = 0, pieces = 1, mid = start + (end - start) / 2;
            for(int element: nums){
                sum += element;
                if(sum > mid){  // If the sum exceeds target sum (mid), then break sub array.
                    sum = element;
                    pieces++;
                }
            }
            if(pieces > k){ // If number of pieces exceeds required sub-arrays(k)
                start = mid + 1;
            }
            else{
                end = mid;
            }
            ans = end;
        }
        return ans;
    }

    int arraySum(int[] arr){
        int sum = 0;
        for(int element: arr){
            sum += element;
        }
        return sum;
    }

    int arrayMax(int[] arr){
        int max = 0;
        for(int element: arr){
            max = Math.max(max, element);
        }
        return max;
    }
}
