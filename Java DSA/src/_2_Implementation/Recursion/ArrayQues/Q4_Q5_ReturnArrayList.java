package _2_Implementation.Recursion.ArrayQues;

import java.util.ArrayList;

public class Q4_Q5_ReturnArrayList {
    public static void main(String[] args) {
        int[] arr = {3, 18, 2, 1, 18, 9, 10, 18, 11, 18, 18, 12, 95, 34, 0, 18};
        int target = 18;
        // Aim is to directly get an ArrayList as a return value from the function
        System.out.println(returnTargetIndicesAL(arr, target));

        // Aim is to get an ArrayList of all target indices without ever passing AL as an argument
        System.out.println(returnAL_NoArgAL(0, arr, target));
    }

    static ArrayList<Integer> returnTargetIndicesAL(int[] arr, int target) {
        return helper(0, arr, target, new ArrayList<>());
    }

    static ArrayList<Integer> helper(int index, int[] arr, int target, ArrayList<Integer> list) {
        if(index == arr.length) return list;
        if(arr[index] == target) list.add(index);
        return helper(index + 1, arr, target, list);
    }

    /*
        In the below function returnAL_NoArgAL, we are never passing an ArrayList as an argument.
        At each recursive function call, create a new Integer ArrayList, say 'indexAL'.
        If currently passed index is equal to array length, we return the empty 'indexAL'.
        If not then, we check if the currently passed index of the array contains the target.
        In case of success, the 'indexAL' will ALWAYS contain a single index number.
        If not, it will ALWAYS stay empty. (size = 0, isEmpty = true)
        Now we will get the Resultant ArrayList, say 'allIndices' from the next (future) function call.
        If our 'indexAL' is NOT empty, we add the found index number to the 'allIndices'
        We then pass this updated 'allIndices' to the previous function call, thus successfully completing recursion.

        Note: indexAL will be NEW for each function call but, 'allIndices' is actually the 'indexAL' of the LAST
              function (LEAF Node) passed upwards as a 'return value' and updated inside each call accordingly.
     */
    static ArrayList<Integer> returnAL_NoArgAL(int index, int[] arr, int target) {
        ArrayList<Integer> indexAL = new ArrayList<>();
        if(index == arr.length) return indexAL;
        if(arr[index] == target) indexAL.add(index);
        ArrayList<Integer> allIndices = returnAL_NoArgAL(index + 1, arr, target);
        if(!indexAL.isEmpty()) allIndices.add(0, indexAL.get(0));
        // simply using add(indexAL.get(0)) will result in a descending order of indices
        /*
            We can also use indexAL.addAll(allIndices) to keep the output list sorted as well.
            In this case, we will return the originally created 'new ArrayList' that is 'indexAL'
            The code after creating and assigning list to 'allIndices' would then be:

                indexAL.addAll(allIndices);
                return indexAL;
         */
        return allIndices;
    }
}
