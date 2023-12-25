package _2_Implementation.Recursion.BacktrackingQues;

// Link to the question: https://leetcode.com/problems/sudoku-solver/

// Note: When a can affect future answers or choices, we use backtracking

// This file contains two solution methods
/*
 Solution 1: Uses an integer type board1 matrix along with a boolean return type function to know when to stop backtracking
 Solution 2: Uses a character type board1 matrix along with a void return type function and static class variable to
             know when to stop backtracking
 */
// The problem can also be solved by passing only the board, and checking out the first cell that is empty
// (contains '.' or zero) and apply the 1-9 for-loop on it followed by recursively passing the board again.

import java.util.Arrays;

public class Q3_LeetcodeSudoSolve {

    static boolean isSolved = false;

    public static void main(String[] args) {
        // Solution 1:
        int[][] board1 = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 0},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if(sudokuSolver(board1, 0, 0)) display(board1);

        // Solution 2:
        char[][] board2 = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        sudokuSolver(board2, 0, 0);
        display(board2);
        isSolved = false; // So that we can solve for the next unsolved input
    }

    // Time Complexity: O(9 ^ (n ^ 2))
    // Space Complexity: O(n ^ 2)

    static boolean sudokuSolver(int[][] board, int r, int c) {
        if(r == board.length) return true;
        if(c == board[r].length) return sudokuSolver(board, r + 1, 0);
        boolean isSolved = false;
        if(board[r][c] == 0) {
            for(int i = 1; i <= 9 && !isSolved; i++) {
                board[r][c] = i;
                if(isValid(board, r, c)) isSolved = sudokuSolver(board, r, c + 1);
            }
            if(!isSolved) board[r][c] = 0;
            return isSolved;
        }
        return sudokuSolver(board, r, c + 1);
    }

    static boolean isValid(int[][] board, int r, int c) {
        return smallMatScan(board, r, c) && rowScan(board, r, c) && colScan(board, r, c);
    }

    static boolean smallMatScan(int[][] board, int r, int c) {
        // Here, size of problem is fixed as 9, therefore we are taking '3' as the divisor in modulo operation
        // If we want to make it more general we can take (int)Math.sqrt(board.length)
        int startRow = r - r % 3, startCol = c - c % 3;
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(i == r && j == c) continue;
                if(board[r][c] == board[i][j]) return false;
            }
        }
        return true;
    }

    static boolean rowScan(int[][] board, int r, int c) {
        for(int i = 0; i < board.length; i++) {
            if(i == c) continue;
            if(board[r][i] == board[r][c]) return false;
        }
        return true;
    }

    static boolean colScan(int[][] board, int r, int c) {
        for (int i = 0; i < board.length; i++) {
            if (i == r) continue;
            if (board[i][c] == board[r][c]) return false;
        }
        return true;
    }

    static void display(int[][] board) {
        for(int[] row: board) System.out.println(Arrays.toString(row));
        System.out.println();
    }

    static void sudokuSolver(char[][] board, int r, int c) {
        if(r == board.length) {
            isSolved = true;
            return;
        }
        if(c == board[r].length) {
            sudokuSolver(board, r + 1, 0);
            return;
        }
        if(board[r][c] == '.') {
            for(int i = 1; i <= 9; i++) {
                board[r][c] = (char)(i + '0');
                if(isValid(board, r, c)) sudokuSolver(board, r, c + 1);
                if(isSolved) return;
            }
            board[r][c] = '.';
            return;
        }
        sudokuSolver(board, r, c + 1);
    }

    static boolean isValid(char[][] board, int r, int c) {
        return smallMatScan(board, r, c) && rowScan(board, r, c) && colScan(board, r, c);
    }

    static boolean smallMatScan(char[][] board, int r, int c) {
        int startRow = r - r % 3, startCol = c - c % 3;
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(i == r && j == c) continue;
                if(board[r][c] == board[i][j]) return false;
            }
        }
        return true;
    }

    static boolean rowScan(char[][] board, int r, int c) {
        for(int i = 0; i < board.length; i++) {
            if(i == c) continue;
            if(board[r][i] == board[r][c]) return false;
        }
        return true;
    }

    static boolean colScan(char[][] board, int r, int c) {
        for (int i = 0; i < board.length; i++) {
            if (i == r) continue;
            if (board[i][c] == board[r][c]) return false;
        }
        return true;
    }

    static void display(char[][] board) {
        for(char[] row: board) System.out.println(Arrays.toString(row));
        System.out.println();
    }
}
