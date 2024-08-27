package leetcode.backtrack;

public class Nqueen {
    final static int N = 4;

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        if(!checkQueen(matrix,0))
            System.out.println("It is not possible to place N queens");
        else{
            // print matrix
            for(int i=0; i<N; i++){
                for(int j=0; j<N;j++)
                    System.out.printf("%s ", matrix[i][j]);
                System.out.println();
            }
        }
    }

    private static boolean checkQueen(int[][] matrix, int col) {
        if(col>=N)
            return true;
        for(int row=0; row<N; row++){ // O(N)
            if(isCurrentPositionSafe(matrix,row,col)){ // O(N)
                matrix[row][col]=1;

                if(checkQueen(matrix,col+1))
                    return true;
                matrix[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isCurrentPositionSafe(int[][] matrix, int row, int col) {

        for(int i = col; i>=0; i--)
            if(matrix[row][i] == 1)
                return false;
        for(int i=row,j=col; i>=0 && j>=0; i--, j--)
            if(matrix[i][j] == 1)
                return false;
        for(int i =row,j=col; i<N && j>=0; i++,j--)
            if(matrix[i][j] == 1)
                return false;
        return true;
    }
}
