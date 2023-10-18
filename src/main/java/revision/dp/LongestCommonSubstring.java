package revision.dp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str="ABABC", ptr="BABCA";
        System.out.println("Longest Common Substring : " + computeLongestCommonSubstring(str,ptr));
    }

    private static int computeLongestCommonSubstring(String str, String ptr) {
        int m = str.length(), n = ptr.length(), maxLen = 0;
        int[][] lcs = new int[m+1][n+1];

        /*
        * This is also not needed as by default int matrix value is assigned to 0.
        * */
        /*for(int i=0; i<=m; i++)
            lcs[i][0] = 0;
        for(int j=0; j<=n; j++)
            lcs[0][j] = 0;*/

        for(int i=1; i<=m ; i++)
            for(int j=1; j<=n; j++){
                if(str.charAt(i-1) == ptr.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                    maxLen = Math.max(maxLen, lcs[i][j]);
                }
            }
        return maxLen;
    }
}
