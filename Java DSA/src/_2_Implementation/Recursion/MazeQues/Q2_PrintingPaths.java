package _2_Implementation.Recursion.MazeQues;

public class Q2_PrintingPaths {
    public static void main(String[] args) {
        int[][] maze = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int goal = 9;
        printPaths("", maze, goal, 0, 0); // Printing answers by actually traversing paths
        System.out.println();
        printPaths2("", 3, 3); // Printing by exploring permutations
    }

    static void printPaths(String path, int[][] maze, int goal, int r, int c) {
        if(r >= maze.length || c >= maze[r].length) return;
        if(maze[r][c] == goal) System.out.println(path);
        printPaths(path + "R", maze, goal, r, c + 1);
        printPaths(path + "D", maze, goal, r + 1, c);
    }

    /*
        Here, we imagine going from '3' to '1' for both rows and columns in the maze matrix
        and the target will be reached when row and column both are equal to 1.
        Now, we know that it will start from (3, 3).
        Thus, we stop when we reach r(row) = 1 AND c(column) = 1 which is our target (1, 1).
        Initially row and column will be '3'.
        We have a String 'p' that will note down the path to the target.
        Each time we recursively decrement either the 'row' value or 'col' value by 1.
        When 'row' is decremented, we append 'D' to the 'p' String
        When 'col' is decremented, we append 'R' to the 'p' String
        As the size of the matrix doesn't allow to go below 1, that is row or column cannot be less than 1,
        we make a check each time before decrementing the value of row or column that is whether row - 1
        or column - 1 is greater than '0'
        In this way we once go DOWN or go RIGHT from all instances and find all available paths which are
        accordingly printed when we reach the target
     */
    static void printPaths2(String p, int r, int c) {
        if(r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if(c - 1 > 0) printPaths2(p + "R", r, c - 1);
        if(r - 1 > 0) printPaths2(p + "D", r - 1, c);
    }
}
