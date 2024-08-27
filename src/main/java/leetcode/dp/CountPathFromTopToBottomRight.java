package leetcode.dp;

public class CountPathFromTopToBottomRight {
    public static void main(String[] args) {
        int m =5,n=6;
        System.out.println("Count of all paths to reach from top left to bottom right : " + allPathCount(m,n));
    }

    private static int allPathCount(int m, int n) {

        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(i==0 || j==0)
                    matrix[i][j]=1;
                else
                    matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }
}
