package _3_Assignments.Others;
import java.util.Arrays;
import java.util.Scanner;
public class TransposeMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Dimension for N X N Matrix: ");
        int matSize = in.nextInt();
        int[][] myMat = new int[matSize][matSize];
        System.out.println("Enter the elements of the Matrix: ");
        for(int i = 0; i < matSize; i++){
            for(int j = 0; j < matSize; j++){
                myMat[i][j] = in.nextInt();
            }
        }
        System.out.println("Original Matrix Input:\n");
        for(int[] element: myMat){
            System.out.println(Arrays.toString(element));
        }
        transposeMatrix(myMat);
        System.out.println("Matrix after transpose:\n");
        for(int[] element: myMat){
            System.out.println(Arrays.toString(element));
        }
    }

    static void transposeMatrix(int[][] myMat){
        int temp;

        for(int i = 0; i < myMat.length; i++){
            for(int j = myMat.length-1; j > i; j--){
                temp = myMat[i][j];
                myMat[i][j] = myMat[j][i];
                myMat[j][i] = temp;

            }
        }
    }
}
