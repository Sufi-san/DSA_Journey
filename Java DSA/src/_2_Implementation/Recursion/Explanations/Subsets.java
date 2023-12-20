package _2_Implementation.Recursion.Explanations;

import java.util.ArrayList;

public class Subsets {
    // Dealing with Permutations & Combinations
    // Subsets: Non-adjacent collections included, elements may or may not be continuous
    // Eg: [3, 5, 9] -> [3], [3, 5], [3, 9], [3, 5, 9], [5, 9], [5], [9] // Combinations: [5, 9] is same as [9, 5]
    public static void main(String[] args) {
        // Given String to create all subsets:
        String set = "abc"; // a, b, c, ab, ac, bc, abc, ""(Empty set)

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

}
