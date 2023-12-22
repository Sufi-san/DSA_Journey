package _2_Implementation.Recursion.MazeQues;

import java.util.ArrayList;

public class Q5_IncludingAllPaths {
    // Now we can go in any 4 directions !! (Up, Down, Left, Right)
    // However, we cannot go back to an old cell.
    /*
        Problem Faced:
            Stack Overflow, When 'Up' and 'Left' are directly added to the possible moves inside the maze,
            We return to an earlier cell which forms a complete loop by starting the same process
            again from initial conditions.

        A Solution:
            Once a cell is visited, mark it as 'visited' by turning it to 'false'
            when the recursion call ends, turn that particular cell back to 'true'
            so that future paths can be explored correctly by future recursive calls.
            The concept is similar to obstacle problem.

            Note: This is NOT Backtracking, we are just marking visited cells.
     */
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        System.out.println(getPathCount(maze, 0, 0));
        System.out.println(getPathsAL("", maze, 0, 0));
    }

    static int getPathCount(boolean[][] maze, int r, int c) {
        if(r == maze.length - 1 && c == maze[r].length - 1) return 1;
        if(!maze[r][c]) return 0;
        int count = 0;
        if(c < maze[r].length - 1) {
            maze[r][c] = false;
            count += getPathCount(maze, r, c + 1);
            maze[r][c] = true;
        }
        if(r < maze.length - 1) {
            maze[r][c] = false;
            count += getPathCount(maze, r + 1, c);
            maze[r][c] = true;
        }
        if(c > 0) {
            maze[r][c] = false;
            count += getPathCount(maze, r, c - 1);
            maze[r][c] = true;
        }
        if(r > 0) {
            maze[r][c] = false;
            count += getPathCount(maze, r - 1, c);
            maze[r][c] = true;
        }
        return count;
    }

    static ArrayList<String> getPathsAL(String p, boolean[][] maze, int r, int c) {
        if(r == maze.length - 1 && c == maze[r].length - 1) {
            ArrayList<String> newPath = new ArrayList<>();
            newPath.add(p);
            return newPath;
        }
        if(!maze[r][c]) return new ArrayList<>();
        ArrayList<String> allPaths = new ArrayList<>();
        if(c < maze[r].length - 1) {
            maze[r][c] = false;
            allPaths.addAll(getPathsAL(p + "R", maze, r, c + 1));
            maze[r][c] = true;
        }
        if(r < maze.length - 1) {
            maze[r][c] = false;
            allPaths.addAll(getPathsAL(p + "D", maze, r + 1, c));
            maze[r][c] = true;
        }
        if(c > 0) {
            maze[r][c] = false;
            allPaths.addAll(getPathsAL(p + "L", maze, r, c - 1));
            maze[r][c] = true;
        }
        if(r > 0) {
            maze[r][c] = false;
            allPaths.addAll(getPathsAL(p + "U", maze, r - 1, c));
            maze[r][c] = true;
        }
        return allPaths;
    }
}
