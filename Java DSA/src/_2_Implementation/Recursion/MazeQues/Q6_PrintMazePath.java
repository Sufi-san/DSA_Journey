package _2_Implementation.Recursion.MazeQues;

import java.util.Arrays;

public class Q6_PrintMazePath {
    // Here we have to actually visualize the path by printing the maze matrix once target is reached
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        // Here, if a cell holds a number other than '0' that means it is visited
        printPathMat("", maze, 0, 0, 1);
    }

    static void printPathMat(String p, int[][] maze, int r, int c, int count) {
        if(r == maze.length - 1 && c == maze[r].length - 1) {
            maze[r][c] = count;
            System.out.println(p);
            for(int[] row: maze) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
            maze[r][c] = 0; // Not really necessary as this will always change (in every call guaranteed)
            return;
        }
        if(maze[r][c] > 0) return;
        maze[r][c] = count; // Simpler way to mark visited cell for each recursion call
        if(c < maze[r].length - 1) printPathMat(p + "R", maze, r, c + 1, count + 1);
        if(r < maze.length - 1) printPathMat(p + "D", maze, r + 1, c, count + 1);
        if(c > 0) printPathMat(p + "L", maze, r, c - 1, count + 1);
        if(r > 0) printPathMat(p + "U", maze, r - 1, c, count + 1);
        maze[r][c] = 0; // Simpler way to revert the change after recursion call has ended (BACKTRACK)
    }
}
