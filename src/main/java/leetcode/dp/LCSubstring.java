package leetcode.dp;

public class LCSubstring {
    public static void main(String[] args) {
        String first = "ABABC";
        String second = "BABCA";
        System.out.println("Length of longest common substring : " + computeLcSub(first,second));
    }

    /*
    * Transform string into 2D matrix representation
    * */
    private static int computeLcSub(String first, String second) {
        int maxLen = 0;
        int m = first.length(), n = second.length();
        int matrix[][] = new int[m+1][n+1];
        for(int i =1; i<=m; i++){ // ABABC
            for(int j=1; j<=n;j++){ // BABCA
                if(first.charAt(i-1) == second.charAt(j-1)){
                    matrix[i][j]=1+matrix[i-1][j-1];
                    if(matrix[i][j]>maxLen)
                        maxLen=matrix[i][j];
                }
            }
        }
        return maxLen;
    }
}
