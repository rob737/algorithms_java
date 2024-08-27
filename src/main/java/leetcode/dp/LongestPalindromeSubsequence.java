package leetcode.dp;

public class LongestPalindromeSubsequence {
    public static void main(String[] args) {
        String input = "adceca";
        int n = input.length();
        System.out.println("Length of longest palindromic subsequence : " + LPS(input,n));
    }

    private static int LPS(String input, int n) {
        int[][] matrix = new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j<i)
                    continue;
                if(i==j)
                    matrix[i][j]=1;
                else{
                    if(input.charAt(i) != input.charAt(j))
                        matrix[i][j]=Math.max(matrix[i][j-1],matrix[i+1][j]);
                    else
                        matrix[i][j] = 2 + matrix[i+1][j-1];
                }
            }
        }
        return matrix[0][n-1];
    }
}
