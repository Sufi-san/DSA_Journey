package _2_Implementation.Recursion.MazeQues;

import java.util.ArrayList;
import java.util.List;

public class Q3_DiagonalPaths {
    // Same maze conditions of going from (3, 3) to (1, 1) from previous problem
    public static void main(String[] args) {
        System.out.println(countPathsWithDiag(3, 3));
        System.out.println(printPathsWithDiag("", 3, 3)); // 'X' will stand for going Diagonally
    }

    static int countPathsWithDiag(int r, int c) {
        if(r == 1 && c == 1) return 1;
        int count = 0;
        if(r > 1) count += countPathsWithDiag(r - 1, c);
        if(c > 1) count += countPathsWithDiag(r, c - 1);
        if(r > 1 && c > 1) count += countPathsWithDiag(r - 1, c - 1);
        return count;
    }

    static List<String> printPathsWithDiag(String p, int r, int c) {
        if(r == 1 && c == 1) {
            List<String> newPath = new ArrayList<>();
            newPath.add(p);
            return newPath;
        }
        List<String> allPaths = new ArrayList<>();
        if(r > 1) allPaths.addAll(printPathsWithDiag(p + "D", r - 1, c));
        if(c > 1) allPaths.addAll(printPathsWithDiag(p + "R", r, c - 1));
        if(r > 1 && c > 1) allPaths.addAll(printPathsWithDiag(p + "X", r - 1, c - 1));
        return allPaths;
    }
}
