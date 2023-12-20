package _2_Implementation.Recursion.Explanations;


import java.util.ArrayList;
import java.util.Arrays;

// https://www.scaler.com/topics/difference-between-subarray-subset-and-subsequence/ (must read to revise)
// https://www.scaler.com/topics/images/difference-between-subarray-subset-and-subsequence_thumbnail.webp

public class Subsets_Subsequence {
    // Dealing with Permutations & Combinations
    // Subsets: Non-adjacent collections included, elements may or may not be continuous
    // Eg: [3, 5, 9] -> [3], [3, 5], [3, 9], [3, 5, 9], [5, 9], [5], [9] // Combinations: [5, 9] is same as [9, 5]
    public static void main(String[] args) {
        // Given String to create all subsets:
        String set = "abc"; // a, b, c, ab, ac, bc, abc, ""(Empty set)
        int[] arr = {1, 2, 3};
        int[] duplicateArr = {1, 2, 2, 3, 2};
        /*
            In any subset, we may be taking an element or removing an element.
            This pattern of taking some elements & removing some is 'Subset Pattern'

            We can maintain a 'processed' and 'unprocessed' string.
            And we can use recursion to perform both the acts, including AND not including.
            Whenever our 'unprocessed' string becomes empty, we consider the processed one
            as a potential answer, and then we return it in some way.

            Here, we are dealing with combinations, but some part of this approach can also
            be used in dealing with permutations.
         */
        ArrayList<String> subsets = new ArrayList<>();
        getAllSubSets("", set, subsets); // passing ArrayList as a parameter
        System.out.println(subsets);
        System.out.println(getAllSubSets("", set)); // getting new ArrayList in return without passing
        System.out.println(getAllSubSetsWithASCII("", set)); // subsets also containing character ASCII values

        // Important! Conversion of Recursive Logic to Iterative Logic:
        System.out.println(getAllSubsetsIterative(set)); // getting all subsets using 'Iteration'
        System.out.println(getAllSubsetsIterativeWithASCII(set)); // getting all subsets with ASCII using 'Iteration'

        // Performing above operation on Array {1, 2, 3}, subsets like {1}, {2, 3}, {1, 3}...
        System.out.println(getAllSubsets(arr));
        System.out.println(getAllSubsetsWithRepeat(duplicateArr));
    }

    static void getAllSubSets(String processed, String unprocessed, ArrayList<String> subsets) {
        if(unprocessed.isEmpty()) {
            if(processed.isEmpty()) processed = null;
            subsets.add(processed);
            return;
        }
        getAllSubSets(processed + unprocessed.charAt(0), unprocessed.substring(1), subsets);
        getAllSubSets(processed, unprocessed.substring(1), subsets);
    }

    static ArrayList<String> getAllSubSets(String processed, String unprocessed) {
        if(unprocessed.isEmpty()) {
            if(processed.isEmpty()) processed = null;
            ArrayList<String> subsets = new ArrayList<>();
            subsets.add(processed);
            return subsets;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> subsets1 = getAllSubSets(processed + ch, unprocessed.substring(1));
        ArrayList<String> subsets2 = getAllSubSets(processed, unprocessed.substring(1));
        subsets1.addAll(subsets2); // Same as for(String str: subsets2) subsets1.add(str);
        return subsets1;
    }

    // In below approach we also find combinations using ASCII values of the characters:
    // Eg: "abc" -> a, b, c, 97, 98, 99,
    //              ab, ac, a98, a99, 9798, 9799, 97b, 97c
    //              bc, b99, 98c, 9899
    //              abc, 97bc, 9798c, 97b99, a9899, a98c, ab99, 979899
    //              null
    // For this we can simply add one more recursive call, where we once take the ascii value of character
    static ArrayList<String> getAllSubSetsWithASCII(String processed, String unprocessed) {
        if(unprocessed.isEmpty()) {
            if(processed.isEmpty()) processed = null;
            ArrayList<String> subsets = new ArrayList<>();
            subsets.add(processed);
            return subsets;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> subsets1 = getAllSubSetsWithASCII(processed + ch, unprocessed.substring(1));
        ArrayList<String> subsets2 = getAllSubSetsWithASCII(processed, unprocessed.substring(1));
        ArrayList<String> subsets3 = getAllSubSetsWithASCII(processed + (int)ch, unprocessed.substring(1));
        subsets1.addAll(subsets2);
        subsets1.addAll(subsets3);
        return subsets1;
    }

    static ArrayList<String> getAllSubsetsIterative(String set) {
        ArrayList<String> subsets = new ArrayList<>();
        // The approach is same, but we just consider the first case of rejection and acceptance,
        // and follow it with acceptance cases only
        subsets.add("");
        for(int i = 0; i < set.length(); i++) {
            int prevSubsets = subsets.size();
            for(int j = 0; j < prevSubsets; j++) {
                subsets.add(subsets.get(j) + set.charAt(i));
            }
        }
        subsets.set(0, null); // optional step, if you want to represent "" empty space as 'null'
        return subsets;
    }

    static ArrayList<String> getAllSubsetsIterativeWithASCII(String set) {
        ArrayList<String> subsets = new ArrayList<>();
        subsets.add("");
        for(int i = 0; i < set.length(); i++) {
            int prevSubsets = subsets.size();
            for(int j = 0; j < prevSubsets; j++) {
                subsets.add(subsets.get(j) + set.charAt(i));
            }
            // Now considering ASCII value of 'set.charAt(i)' with the same subset
            for(int j = 0; j < prevSubsets; j++) {
                subsets.add(subsets.get(j) + (int)set.charAt(i));
            }
        }
        subsets.set(0, null); // optional step, if you want to represent "" empty space as 'null'
        return subsets;
    }

    static ArrayList<ArrayList<Integer>> getAllSubsets(int[] arr) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        // The approach is same, but we just consider the first case of rejection and acceptance,
        // and follow it with acceptance cases only
        subsets.add(new ArrayList<>());
        for(int num: arr) {
            int prevSubsets = subsets.size();
            for(int j = 0; j < prevSubsets; j++) {
                ArrayList<Integer> newSubset = new ArrayList<>(subsets.get(j));
                newSubset.add((num));
                subsets.add(newSubset);
            }
        }
        return subsets;
    }
    // For above algorithm:
    // Time Complexity: O(N * (2 ^ N))
    // Space Complexity: O((2 ^ N) * N) , where '2 ^ N' is total subsets and 'N' is space taken by each subset

    static ArrayList<ArrayList<Integer>> getAllSubsetsWithRepeat(int[] arr) {
        /*
         We can deduce the logic that, if a duplicate is found, we need to add it to only the subsets of
         the previous step. Eg: for {1, 2, 2}, we get {{}, {1}, {2}, {1, 2}} till the first '2'
         Now, we know as the next '2' is duplicate, we add to only the previous newly created subsets {{2}, {1, 2}}
         Therefore, we get {{}, {1}, {2}, {1, 2}, {2, 2}, {1, 2, 2}
         However, there is a catch!! How will know at the number of subsets, generated after the 'previous' duplicate
         in a case like, {2, 1, 2} ???
         Therefore, we again deduce that duplicates need to stay together, hence we first sort the array
        */

        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int prevSubsets = 0;
        for(int i = 0; i < arr.length; i++) {
            int startIndex = (i > 0 && arr[i] == arr[i - 1])? prevSubsets: 0;
            prevSubsets = subsets.size();
            for(int j = startIndex; j < prevSubsets; j++) {
                ArrayList<Integer> newSubset = new ArrayList<>(subsets.get(j));
                newSubset.add((arr[i]));
                subsets.add(newSubset);
            }
        }
        return subsets;
        // No major change in time or space complexity.
        // In this case, the generated subsets cannot be called 'subsequences' as the original sequence.
        // is not maintained in the generated subsets due to sorting performed in original array.
    }
}
