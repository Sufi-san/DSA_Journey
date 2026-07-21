package _2_Implementation.Recursion.MazeQues;

public class Q1_CountingPaths {
    // Given a 2D-Matrix with a goal cell, in how many ways can we reach the goal?
    // We can only move to the right or down from any cell

    public static void main(String[] args) {
        int[][] maze = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int goal = 9;
        System.out.println(retPathCount(maze, goal, 0, 0));
    }

    // Either we are going Right (c + 1) or we are going down (r + 1)
    static int retPathCount(int[][] maze, int goal, int r, int c) {
        if(r >= maze.length || c >= maze[r].length) return 0;
        if(maze[r][c] == goal) return 1;
        int count = 0;
        count += retPathCount(maze, goal, r, c + 1); // Going Right
        count += retPathCount(maze, goal, r + 1, c); // Going Down
        return count;
    }

    // In the future, when we study Dynamic Programming, once we know the number of ways from one cell to target,
    // and that particular cell is encountered again, we do not need to traverse further, as we will already know
    // the number of ways to reach target from that cell.
}
