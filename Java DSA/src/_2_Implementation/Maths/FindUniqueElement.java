package _2_Implementation.Maths;

import java.util.ArrayList;

public class FindUniqueElement {
    // Inside a given array, only 1 number appears once, rest all numbers appear twice. Find unique number.

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 2, 1, 3, 6, 4};
        System.out.println(findByBruteForce(arr));
        System.out.println(findBySort(arr));
        System.out.println(findByXOR(arr)); // Most Optimal among others
    }

    static int findByBruteForce(int[] arr){
        if (arr.length < 1) return -1;
        ArrayList<Integer> possibleAns = new ArrayList<>();
        possibleAns.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(possibleAns.contains(arr[i])){
                possibleAns.remove((Integer) arr[i]); // Removal by Object
            }
            else{
                possibleAns.add(arr[i]);
            }
        }
        return (possibleAns.isEmpty())? -1: possibleAns.get(0); // .isEmpty() is same as .size() == 0
    }

    static int findBySort(int[] arr){
        if (arr.length < 1) return -1;
        insertionSort(arr);
        for(int i = 0; i < arr.length; i++){
            if(i < arr.length - 1 && arr[i] != arr[i + 1]){
                return arr[i];
            }
            else i++;
        }
        return arr[arr.length - 1];
    }

    static int findByXOR(int[] arr){
        if(arr.length < 1) return -1;
        int ans = arr[0]; // can also start with ans = 0 and iterate through whole array
        for(int i = 1; i < arr.length; i++){
            ans ^= arr[i];
        }
        return ans;
    }

    static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                }
                else{
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
