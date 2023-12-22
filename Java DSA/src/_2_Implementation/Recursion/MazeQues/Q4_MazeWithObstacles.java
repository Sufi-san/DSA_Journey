package _2_Implementation.Recursion.MazeQues;

import java.util.ArrayList;
import java.util.List;

public class Q4_MazeWithObstacles {
    // Here there will appear cells that are blocked, ones which we cannot use to travel
    public static void main(String[] args) {
        int[][] maze = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}; // 0 stands for obstacle, 1 means no obstacle
        // A boolean array can also be used
        System.out.println(retPathCount(maze, 0, 0));
        System.out.println(retPathsAL("", maze, 0, 0)); // List of paths
        System.out.println(retPathsAL2("", maze, 0, 0)); // List of paths by applying logic differently
    }

    static int retPathCount(int[][] maze, int r, int c) {
        // maze[r][c] == 0 checks whether cell contains obstacle
        if(r >= maze.length || c >= maze[r].length || maze[r][c] == 0) return 0;
        if(r == maze.length - 1 && c == maze[r].length - 1) return 1;
        int count = 0;
        count += retPathCount(maze, r, c + 1); // Going Right
        count += retPathCount(maze, r + 1, c); // Going Down
        count += retPathCount(maze, r + 1, c + 1); // Going Diagonally
        return count;
    }

    static List<String> retPathsAL(String p, int[][] maze, int r, int c) {
        if(r >= maze.length || c >= maze[r].length || maze[r][c] == 0) return new ArrayList<>();
        if(r == maze.length - 1 && c == maze[r].length - 1) {
            List<String> newPath = new ArrayList<>();
            newPath.add(p);
            return newPath;
        }
        List<String> allPaths = new ArrayList<>();
        allPaths.addAll(retPathsAL(p + "R", maze, r, c + 1)); // Going Right
        allPaths.addAll(retPathsAL(p + "D", maze, r + 1, c)); // Going Down
        allPaths.addAll(retPathsAL(p + "X", maze, r + 1, c + 1)); // Going Diagonally
        return allPaths;
    }

     static List<String> retPathsAL2(String p, int[][] maze, int r, int c) {
         if(maze[r][c] == 0) return new ArrayList<>();
         if(r == maze.length - 1 && c == maze[r].length - 1) {
             List<String> newPath = new ArrayList<>();
             newPath.add(p);
             return newPath;
         }
         List<String> allPaths = new ArrayList<>();
         if(c < maze[r].length - 1) {
             allPaths.addAll(retPathsAL2(p + "R", maze, r, c + 1)); // Going Right
         }
         if(r < maze.length - 1) {
             allPaths.addAll(retPathsAL2(p + "D", maze, r + 1, c)); // Going Down
         }
         if(r < maze.length - 1 && c < maze[r].length - 1) {
             allPaths.addAll(retPathsAL2(p + "X", maze, r + 1, c + 1)); // Going Diagonally
         }
         return allPaths;
     }
}
