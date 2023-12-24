package _2_Implementation.Recursion.BacktrackingQues;

import java.util.Scanner;

public class Q2_NKnights {
    // Similar concept to that of NQueens, but we have Knights here instead of Queens
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Size of Board: ");
        int n = in.nextInt();
        boolean[][] board = new boolean[n][n];
        System.out.println("Total Number of Ways: "+retNumWays(board, 0, 0, n));
        System.out.println("Total Number of Ways (Pure Recursion): "+retNumWays2(board, 0, 0, n));
    }

    static int retNumWays(boolean[][] board, int r, int c, int knightsLeft) {
        if(knightsLeft == 0) {
            display(board);
            return 1;
        }
        if(r == board.length) return 0;
        int count = 0;
        for(int i = c; i < board[r].length; i++) {
            if(isSafe(board, r, i)) {
                board[r][i] = true;
                count += retNumWays(board, r, i + 1, knightsLeft - 1);
                board[r][i] = false;
            }
        }
        count += retNumWays(board, r + 1, 0, knightsLeft);
        return count;
    }

    // Kunal Approach: Pure Recursion
    static int retNumWays2(boolean[][] board, int r, int c, int knightsLeft) {
        if(knightsLeft == 0) return 1;
        int count = 0;
        if(r == board.length) return 0;
        if(c == board[r].length) {
            count += retNumWays2(board, r + 1, 0, knightsLeft);
            return count;
        }
        if(isSafe(board, r, c)) {
            board[r][c] = true;
            count += retNumWays2(board, r, c + 1, knightsLeft - 1);
            board[r][c] = false;
        }
        count += retNumWays2(board, r, c + 1, knightsLeft);
        return count;
    }

    static boolean isSafe(boolean[][] board, int r, int c) {
        boolean isSafeSlot = true;
        if(r > 0) {
            if(c > 1) isSafeSlot = !board[r - 1][c - 2];
            if(c < board.length - 2) isSafeSlot = isSafeSlot && !board[r - 1][c + 2];
        }
        if(r > 1) {
            if(c > 0) isSafeSlot = isSafeSlot && !board[r - 2][c - 1];
            if(c < board.length - 1) isSafeSlot = isSafeSlot && !board[r - 2][c + 1];
        }
        return isSafeSlot;
    }

    static void display(boolean[][] board) {
        for(boolean[] row: board) {
            for(boolean hasPiece: row) {
                if(hasPiece) System.out.print("K ");
                else System.out.print("- ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
