package leetcode.revision.array;

public class MatrixRotation {
    static int N =4;
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,12,13},
                {14,15,16,17}
        };
        rotateMatrixBy90(matrix);
        printRotatedMatrix(matrix);
    }

    private static void printRotatedMatrix(int[][] matrix) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.printf(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rotateMatrixBy90(int[][] matrix) {
        for(int i=0; i<N/2; i++){
            for(int j=i; j<N-i-1;j++){
                int temp = matrix[j][N-i-1];
                matrix[j][N-i-1] = matrix[i][j];
                matrix[i][j] = matrix[N-j-1][i];
                matrix[N-j-1][i] = matrix[N-i-1][N-j-1];
                matrix[N-i-1][N-j-1] = temp;
            }
        }
    }
}
