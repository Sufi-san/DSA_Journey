package _3_Assignments._5_Arrays;

public class Leetcode14 {
    public static void main(String[] args){
        int[][] indices = {{0, 1}, {1, 1}};
        int count = oddCells(2, 3, indices);
        System.out.println(count);
    }
    // My First Solution:
    static int oddCells(int m, int n, int[][] indices) {
        int oddCount = 0, row, col;
        int[][] myMat = new int[m][n];
        for (int[] index : indices) {
            row = index[0];
            col = index[1];
            for (int j = 0; j < m; j++) {
                myMat[j][col]++;
            }
            for (int k = 0; k < n; k++) {
                myMat[row][k]++;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                oddCount = (myMat[i][j] % 2 == 0)? oddCount: oddCount + 1;
            }
        }
        return oddCount;
    }

    /* Simple & Efficient solution:
    static int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];

        for(int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int ans = 0;
        int oddCol = 0;
        for(int i = 0; i < n; i++) {
            if(col[i] % 2 != 0)
                oddCol++;
        }
        for(int i = 0; i < m; i++) {
            if(row[i] % 2 == 0) ans += oddCol;
            else ans += (n - oddCol);
        }
        return ans;
     */
}
