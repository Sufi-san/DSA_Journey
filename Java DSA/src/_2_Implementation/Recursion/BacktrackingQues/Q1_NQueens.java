package _2_Implementation.Recursion.BacktrackingQues;

import java.util.Arrays;
import java.util.Scanner;

public class Q1_NQueens {
    // We are given a board of N x N size, and we have to place 'N' Chess Queens on the board such that no
    // two Queens attack each other.
    /*
        How do we know it is a recursion problem?
        --> Because we are repeating the act of placing chess queens each time on a smaller version of the
            original board

        How do we know it is a backtracking problem?
        --> If an unfavourable condition occurs, we need to start from the beginning to explore new possibilities.
            For that, we need to revert the board back to its initial state before that condition occurred
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the N x N Board: (Less than or equal to 8 recommended)");
        int n = in.nextInt();
        char[][] board = new char[n][n];
        for(char[] chrArr: board) Arrays.fill(chrArr, '-');
        System.out.println("Total Possible Ways: "+retNumOfWays(board, 0));
        // Tip: Try to use boolean arrays for possible problems and if printing is required,
        //      assign different print values to 'true' and 'false' cases
    }

    // Recurrence Relation:
    // Time Complexity:
    // Space Complexity: O(N ^ 2) ... Quadratic
    static int retNumOfWays(char[][] board, int r) {
        // We can also take another variable 'queensLeft' to account for customised number of queens
        // And then we can set the below condition 'r == board.length' to 'queensLeft == 0'
        if(r == board.length) { // Means that all queens have been placed
            for(char[] chrArr: board) {
                for(char chr: chrArr) {
                    System.out.print(chr+" ");
                }
                System.out.println();
            }
            System.out.println();
            return 1;
        }
        int count = 0;
        for(int i = 0; i < board[r].length; i++) {
            if(checkIfSafe(board, r, i)) {
                board[r][i] = 'Q';
                count += retNumOfWays(board, r + 1);
                board[r][i] = '-';
            }
        }
        return count;
    }

    static boolean checkIfSafe(char[][] board, int r, int c) {
        for(int i = r - 1; i >= 0; i--) {
            if(board[i][c] == 'Q') return false;
        }
        for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        for(int i = r - 1, j = c + 1; i >= 0 && j < board[r].length; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}
