package leetcode.dp;

public class LCS {
    public static void main(String[] args) {
        String arrayOne = "ABCDEF", arrayTwo = "AEDNEK";
        System.out.println("Length of LCS is " + LCSProblem(arrayOne,arrayTwo));
    }

    private static int LCSProblem(String arrayOne, String arrayTwo) {
        int m = arrayOne.length(), n = arrayTwo.length();
        int[][] matrix = new int [m+1][n+1];
        for(int i =1; i<=m ; i++){
            for(int j=1; j<=n; j++){
                if(arrayOne.charAt(i-1) == arrayTwo.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }else{
                    matrix[i][j] = Integer.max(matrix[i][j-1],matrix[i-1][j]);
                }
            }
        }
        return matrix[m][n];
    }
}
