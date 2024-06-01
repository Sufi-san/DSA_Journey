package _3_Assignments.Others;

public class MatDet {
    public static void main(String[] args) throws Exception{
        int[][] mat = {{-82, 27, 96, -85, 77},
                {12, 88, 99, 91, 87},
                {88, 10, 92, 15, -67},
                {52, -98, 98, 75, 47},
                {-88, 9, 77, 92, 46}};
        System.out.println(getDet(mat));
    }

    static long getDet(int[][] mat) throws Exception{
        if(mat.length == 0) throw new Exception("Empty Matrix");
        for (int[] row : mat) if (mat.length != row.length) throw new Exception("Not a Square Matrix");
        if(mat.length == 1) return mat[0][0];
        long ans = 0;
        for(int i = 0; i < mat.length; i++) {
            int[][] newMat = new int[mat.length - 1][mat.length - 1];
            for(int j = 1; j < mat.length; j++) {
                for(int k = 0, l = 0; k < mat.length; k++) {
                    if(k == i) continue;
                    newMat[j - 1][l] = mat[j][k];
                    l++;
                }
            }
            long det = mat[0][i] * getDet(newMat);
            ans = (i % 2 == 0)? ans + det: ans - det;
        }
        return ans;
    }
}
