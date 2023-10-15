package revision.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str = "ABCDEF", ptr = "AEDNEK";
        System.out.println("LCS length is : " + calculateLCSLength(str,ptr));
    }

    private static int calculateLCSLength(String str, String ptr) {
        /*
        * Pattern is basically simple, go bottom up and compare each character b/w str and ptr.
        * If character matches then include it in count else take maximum between (i-1,j) and (i, j-1)
        * */

        int m = str.length(), n = ptr.length();
        int[][] lcsCountArr = new int[m+1][n+1];

        for(int i=0; i<=m; i++)
            lcsCountArr[i][0] = 0;
        for(int j=0; j<=n ; j++)
            lcsCountArr[0][j] = 0;





        return 0;
    }
}
