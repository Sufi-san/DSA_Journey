package _2_Implementation.Recursion.EasyQues;

// Link to question on Leetcode: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

public class Q10_Leetcode1342 {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {14, 8, 123};
        for(int num: nums) {
            System.out.println(obj.numberOfSteps(num));
        }
    }
}

class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    static int helper(int num, int steps) {
        if(num == 0) return steps;
        num = ((num & 1) == 1)? num - 1: num / 2;
        steps++;
        return helper(num, steps);
    }
}
