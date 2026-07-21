package _2_Implementation.Maths.Bitwise;

public class FindSinglePositive {
    // This question also provides better understanding for "FindUniqueElement"
    // In given array, only 1 positive number appears once, rest all have their negative counterpart once in the array.
    public static void main(String[] args) {
        int[] arr = {-2, 3, 2, 4, -5, 5, -4};
        System.out.println(findByAddition(arr));
    }

    static int findByAddition(int[] arr){
       if(arr.length < 1) return -1;
       int sum = 0;
       for(int num: arr){
           sum += num;
       }
       return sum;
    }
}
