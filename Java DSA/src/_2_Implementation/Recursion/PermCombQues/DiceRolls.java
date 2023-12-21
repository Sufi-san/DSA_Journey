package _2_Implementation.Recursion.PermCombQues;

import java.util.ArrayList;
import java.util.List;

public class DiceRolls {
    public static void main(String[] args) {
        System.out.println(waysForTargetSum(0, 4));
        System.out.println(waysForTargetSum2(0, 4));
        printWaysForTargetSum("", 4);
        System.out.println(waysForTargetSumRetAL("", 5));
        int faces = 3; // Dice with custom number of faces
        System.out.println(customFacesTargetSum(faces, "", 5));
    }

    // My Approach:
    static int waysForTargetSum(int cs, int ts) { // cs is Current Sum & ts is Target Sum
        if(cs == ts) {
            return 1;
        }
        int count = 0;
        for(int i = 1; i <= 6; i++) { // as we have imagined 'dice-rolls' we have numbers 1 to 6 to add
            if(cs + i <= ts) count += waysForTargetSum(cs + i, ts);
        }
        return count;
    }

    // Kunal Approach:
    // 'p' is current Sum while 'diff' is distance between sum and current value
    static int waysForTargetSum2(int p, int diff) {
        if(diff == 0) return 1;
        int count = 0;
        for(int i = 1; i <= 6 && i <= diff; i++) { // Now we do not need 'if' condition as we never exceed limits
            count += waysForTargetSum2(p + i, diff - i);
        }
        return count;
    }

    // Printing the ways:
    static void printWaysForTargetSum(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            printWaysForTargetSum(p + i, target - i);
        }
    }

    // Returning Number of Ways as ArrayList:
    static List<String> waysForTargetSumRetAL(String p, int target) {
        if (target == 0) {
            List<String> newWay = new ArrayList<>();
            newWay.add(p);
            return newWay;
        }
        List<String> allWays = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            allWays.addAll(waysForTargetSumRetAL(p + i, target - i));
        }
        return allWays;
    }

    static List<String> customFacesTargetSum(int faces, String p, int target) {
        if (target == 0) {
            List<String> newWay = new ArrayList<>();
            newWay.add(p);
            return newWay;
        }
        List<String> allWays = new ArrayList<>();
        for (int i = 1; i <= faces && i <= target; i++) {
            allWays.addAll(customFacesTargetSum(faces, p + i, target - i));
        }
        return allWays;
    }

}
