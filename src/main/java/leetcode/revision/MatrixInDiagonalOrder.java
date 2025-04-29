package leetcode.revision;

public class MatrixInDiagonalOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };
        printMatrixInDiagonalOrder(matrix);
    }

    private static void printMatrixInDiagonalOrder(int[][] matrix) {
        int n = matrix[0].length, m = matrix.length,i=0,j=0;
        for(int k=0; k<m; k++){
            i=k;j=0;
            while(j<=k && i>=0){
                System.out.printf(matrix[i][j]+" ");
                j++;i--;
            }
            System.out.println();
        }
        for(int k=1; k<n; k++){
            i=m-1;j=k;
            while(j<n && i>=0){
                System.out.printf(matrix[i][j]+" ");
                i--;j++;
            }
            System.out.println();
        }
    }
}
