package _2_Implementation.Recursion.ArrayQues;

import java.util.ArrayList;

public class Q2_Q3_LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 18, 2, 1, 18, 9, 10, 18, 11, 18, 18, 12, 95, 34, 0, 18};
        int target = 18;
        ArrayList<Integer> targetIndices = new ArrayList<>();
        boolean targetExists = checkTargetInArr(0, arr, target); // checks if target element exists
        System.out.println(targetExists);
        if(targetExists) {
            System.out.println(returnTargetIndex(0, arr, target)); // return first Index of target
            getAllTargetIndices(0, arr, target, targetIndices); // save all required Indices in ArrayList
            System.out.println("All Indices in Array where target is present: "+targetIndices);
        }
    }

    static boolean checkTargetInArr(int index, int[] arr, int target) {
        if(index == arr.length) return false;
        return (arr[index] == target) || checkTargetInArr(index + 1, arr, target);
    }

    static int returnTargetIndex(int index, int[] arr, int target) {
        if(index == arr.length) return -1;
        if(arr[index] == target) return index;
        return returnTargetIndex(index + 1, arr, target);
    }

    static void getAllTargetIndices(int index, int[] arr, int target, ArrayList<Integer> targetIndices) {
        if(index == arr.length) return;
        if(arr[index] == target) targetIndices.add(index);
        getAllTargetIndices(index + 1, arr, target, targetIndices);
    }
}
