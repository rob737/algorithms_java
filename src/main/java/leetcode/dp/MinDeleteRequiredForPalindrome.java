package leetcode.dp;


public class MinDeleteRequiredForPalindrome {
    public static void main(String[] args) {
        String input = "abacdbeaba";
        int n = input.length();
        int result = n-LPS(input,n);
        System.out.println("Minimum Deleting required : " + result);
    }

    private static int LPS(String input, int n) {

        int[][] matrix = new int[n][n];

        for(int i=n-1; i>=0 ; i--){
            for(int j =0; j<n; j++){
                if(j<i)
                    continue;
                if(j==i)
                    matrix[i][j] = 1;
                else{
                    if(input.charAt(i) == input.charAt(j))
                        matrix[i][j] = 2 + matrix[i+1][j-1];
                    else
                        matrix[i][j] = Math.max(matrix[i][j-1],matrix[i+1][j]);
                }
            }
        }

        return matrix[0][n-1];
    }
}
