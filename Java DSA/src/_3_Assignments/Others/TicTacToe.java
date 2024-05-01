package _3_Assignments.Others;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        setBoard(board);
        boolean play = true;
        System.out.println("\n\nWelcome to Command Line Tic-Tac-Toe. (Made using Java)\n");
        System.out.println("Instructions:\n1. Player 1 & 2 will be randomly assigned 'X' or 'O' to use as their symbol.");
        System.out.println("2. Type appropriate cell value each time to fill the desired cell.");
        System.out.println("3. The player whose symbol appears 3 times consecutively in a row, column or diagonal, wins.");
        System.out.println("4. If all cells are filled and no symbol fulfills the win condition, the game is drawn.");
        System.out.println("5. You cannot fill cells that are already occupied by you or the opponent.\n");
        while(play) play = playGame(board);
        System.out.println("\nThanks for playing Command Line Tic-Tac-Toe.");
    }

    static void setBoard(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = (char)((i * 3) + j + '0' + 1);
            }
        }
    }

    static void printBoard(char[][] board) {
        String space = "\t\t";
        System.out.println(space + "    |   |   ");
        System.out.printf(space + "  %c | %c | %c \n",board[0][0], board[0][1], board[0][2]);
        System.out.println(space + "----|---|----");
        System.out.printf(space + "  %c | %c | %c \n",board[1][0], board[1][1], board[1][2]);
        System.out.println(space + "----|---|----");
        System.out.printf(space + "  %c | %c | %c \n",board[2][0], board[2][1], board[2][2]);
        System.out.println(space + "    |   |   \n");
    }

    static boolean playGame(char[][] board) {
        Scanner in = new Scanner(System.in);
        char pl1 = (Math.random() * 1 > 0.5)? 'O': 'X', pl2 = (pl1 == 'O')? 'X': 'O';
        System.out.println("Player 1: "+pl1+"\nPlayer 2: "+pl2);
        int gameOver = -1, turns = 9, player = 1;
        while(turns > 0) {
            char plSymbol = (player == 1)? pl1: pl2;
            printBoard(board);
            System.out.println("Select a cell: (Player "+player+", '"+plSymbol+"')");
            String cell = in.nextLine().trim();
            if(cell.isEmpty()) {
                System.out.println("Empty input cannot be accepted. Please try again.");
                continue;
            }
            int col = cell.charAt(0) - '0' - 1, row;
            if(cell.length() == 1 && col >= 0 && col < 9) {
                row = col / 3;
                col = col % 3;
                if(board[row][col] == 'X' || board[row][col] == 'O') {
                    System.out.println("Cell already occupied, please select a different cell.");
                    continue;
                }
                board[row][col] = plSymbol;
            }
            else {
                System.out.println("Please enter a Valid Index.");
                continue;
            }
            gameOver = checkBoard(board, row, col);
            if(gameOver != -1) break;
            player = (player == 1)? 2: 1;
            turns--;
        }
        printBoard(board);
        if(gameOver == -1) System.out.println("No Player Won. Game Drawn.");
        if(gameOver == 1) System.out.println("\nPlayer "+player+" Won the Game!!");
        setBoard(board);
        System.out.println("\nType 'P' to play again: ");
        return new Scanner(System.in).nextLine().equalsIgnoreCase("P");
    }

    static int checkBoard(char[][] board, int row, int col) {
        int matchCount = 0;
        char symbol = board[row][col];
        // Vertical Check:
        for(int i = row; i < board.length; i++) {
            if(board[i][col] == symbol) matchCount++;
            else break;
        }
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == symbol) matchCount++;
            else break;
        }
        if(matchCount == 3) return 1;
        matchCount = 0;

        // Horizontal Check:
        for(int i = col; i < board[row].length; i++) {
            if(board[row][i] == symbol) matchCount++;
            else break;
        }
        for(int i = col - 1; i >= 0; i--) {
            if(board[row][i] == symbol) matchCount++;
            else break;
        }
        if(matchCount == 3) return 1;
        matchCount = 0;

        // Left-Diagonal Check:
        for(int i = row, j = col; i < board.length && j < board[i].length; i++, j++) {
            if(board[i][j] == symbol) matchCount++;
            else break;
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == symbol) matchCount++;
            else break;
        }
        if(matchCount == 3) return 1;
        matchCount = 0;

        // Right-Diagonal Check:
        for(int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if(board[i][j] == symbol) matchCount++;
            else break;
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < board[i].length; i--, j++) {
            if(board[i][j] == symbol) matchCount++;
            else break;
        }
        if(matchCount == 3) return 1;
        return -1;
    }
}