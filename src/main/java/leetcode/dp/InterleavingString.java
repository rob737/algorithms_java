package leetcode.dp;

public class InterleavingString {
    public static void main(String[] args) {
        String X = "abc";
        String Y = "xyz";
        String S = "axybcz";
        System.out.println("Is S interleaving of X and Y : " + isInterleaving(X,Y,S));
    }

    private static boolean isInterleaving(String x, String y, String s) {
        int m = x.length();
        int n = y.length();
        if(m+n != s.length())
            return false;
        boolean[][] matrix = new boolean[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 && j==0)
                    matrix[i][j]=true;
                else if(i!=0 && j!=0 && (x.charAt(i-1) == s.charAt(i+j-1) || y.charAt(j-1) == s.charAt(i+j-1))){
                    matrix[i][j]=matrix[i-1][j]||matrix[i][j-1];
                }
                else if(i!=0 && x.charAt(i-1)==s.charAt(i+j-1))
                    matrix[i][j]=matrix[i-1][j];
                else if(j!=0 && y.charAt(j-1) == s.charAt(i+j-1))
                    matrix[i][j]=matrix[i][j-1];
            }
        }
        return matrix[m][n];
    }
}
