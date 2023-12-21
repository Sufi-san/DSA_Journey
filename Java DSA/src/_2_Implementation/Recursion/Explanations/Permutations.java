package _2_Implementation.Recursion.Explanations;

import java.util.ArrayList;

public class Permutations {
    /*
        Permutations mean the number of ways of arrangement of a particular sequence
        Eg: "abc" has permutations such as: abc, bac, bca, cba, cab, acb
            If N = Number of characters or items,
            and R = Number of characters or items the arrangement will contain.
            Then,
            Total Number of permutations = N! / (N - R)!
            Now, in our case 'N' will always be equal to 'R'
            Therefore, Total permutations = N! / (N - N)! = N! / 0! = N!
            Here, as length of "abc" is '3', No. of Permutations = 3! = 3 x 2 = 6
     */
    public static void main(String[] args) {
        String str = "ab";
        findAllPermutations(str); // Printing the ArrayList with valid Permutations
        System.out.println(findAllPermutations2("", str)); // Returning the ArrayList with valid Permutations
        System.out.println("Finding Number of Permutations using the method itself: ");
        System.out.println("No. of Permutations = "+findPermCount(0, str));
    }

    static void findAllPermutations(String str) {
        ArrayList<String> ans = new ArrayList<>();
        helper(ans, "", str);
        System.out.println(ans);
        System.out.println("Size of List = "+ans.size()+" = "+str.length()+"! = "+findFact(str.length()));
    }

    // In permutations, the number of recursive calls is variable
    // Here, number of recursive calls = Size of processed string + 1
    static void helper(ArrayList<String> mainAns, String p, String up) {
        if(up.isEmpty()) {
            mainAns.add(p); // OR we can exclude mainAns ArrayList from parameter and simply print 'p'
            return;
        }
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i); // p.substring(0, 0) will return an empty string!
            String s = p.substring(i); // short for: p.substring(i, p.length())
            helper(mainAns, f + up.charAt(0) + s, up.substring(1));
        }
    }

    static ArrayList<String> findAllPermutations2(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> newPerm = new ArrayList<>();
            newPerm.add(p);
            return newPerm;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i); // short for: p.substring(i, p.length())
            ans.addAll(findAllPermutations2(f + up.charAt(0) + s, up.substring(1)));
        }
        return ans;
    }

    // Finding number of permutations using the findFact() method is like using the formula
    // to find the number of available answers
    static int findFact(int num) {
        if(num <= 1) return 1;
        else return num * findFact(num - 1);
    }

    // Instead we can modify the method that returns the permutations itself to get the count of
    // total possible permutations
    static int findPermCount(int pLen, String up) { // Here pLen will note the length of the processed String only
        if(up.isEmpty()) return 1;
        int count = 0;
        for(int i = 0; i <= pLen; i++) {
            count += findPermCount(pLen + 1, up.substring(1));
        }
        return count;
    }
}
