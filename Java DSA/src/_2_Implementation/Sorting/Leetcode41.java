package _2_Implementation.Sorting;

import java.util.*;
public class Leetcode41 {
    // Aim is to return the smallest positive integer missing from the array

    public static void main(String[] args) {
        int[] nums = new int[]{6, -4, 4, 9, 1, 3, -8, 2, -9, 0, 8, 5};
        int index = 0;
        while(index < nums.length){
            int correct = nums[index] - 1;
            if(correct < nums.length && nums[index] > 0 && nums[index] != nums[correct]){
                int temp = nums[index];
                nums[index] = nums[correct];
                nums[correct] = temp;
            }
            else{
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
        boolean isMissing = true;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                System.out.println(i + 1); // when using function this is returned
                isMissing = false;
                break;
            }
        }
        if(isMissing) System.out.println(index + 1); // when using function this is returned
    }
}


