package _3_Assignments.Others;
import java.util.Scanner;
import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Dimension for N X N Matrix: ");
        int matSize = in.nextInt();
        int[][] myMat = new int[matSize][matSize];
        System.out.println("Enter the elements of the Matrix: ");
        for(int i = 0; i < matSize; i++){
            for(int j = 0; j < matSize; j++){
                System.out.printf("Mat[%d][%d]: ",i+1,j+1);
                myMat[i][j] = in.nextInt();
            }
        }
        System.out.println("\nOriginal Matrix Input:");
        for(int[] element: myMat){
            System.out.println(Arrays.toString(element));
        }
        rotateMatrix(myMat);
        System.out.println("\nMatrix after Rotating 90 degrees:");
        for(int[] element: myMat){
            System.out.println(Arrays.toString(element));
        }
    }

    static void rotateMatrix(int[][] myMat){
        int temp;
        int lastIndex = myMat.length - 1;

        // Swapping Rows with the trend: 1 <-> n, 2 <-> n-1, ... where 'n' is the last row.
        for(int i = 0; i < myMat.length/2; i++){
            for(int j = 0; j < myMat.length; j++){
                temp = myMat[i][j];
                myMat[i][j] = myMat[lastIndex - i][j];
                myMat[lastIndex - i][j] = temp;
            }
        }
        /*
        // Result of Swapping:
        System.out.println("\nHalfway Through:");
        for(int[] element: myMat){
            System.out.println(Arrays.toString(element));
        }
        */

        // Simple Matrix Transpose:
        for(int i = 0; i < myMat.length; i++){
            for(int j = myMat.length-1; j > i; j--){
                temp = myMat[i][j];
                myMat[i][j] = myMat[j][i];
                myMat[j][i] = temp;
            }
        }
    }
}
