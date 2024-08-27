package leetcode.dp;

public class WildcardPatternMatching {
    public static void main(String[] args) {
        String word = "abcknabt";
        String pattern = "a?c*t";
        System.out.println("Does pattern cover word ? " + isPatternMatch(word,pattern));
    }

    private static boolean isPatternMatch(String word, String pattern) {
        int m = pattern.length();
        int n = word.length();
        boolean[][] matrix = new boolean[m+1][n+1];
        matrix[0][0]=true;
        for(int i=1; i<=m; i++){
            for(int j=1;j<=n;j++){
                if(i==j && (word.charAt(j-1)==pattern.charAt(i-1) || pattern.charAt(i-1)=='?' ||
                        pattern.charAt(i-1)=='*'))
                    matrix[i][j]=matrix[i-1][j-1];
                else if(pattern.charAt(i-1)=='*'||word.charAt(j-1)==pattern.charAt(i-1))
                    matrix[i][j]=matrix[i][j-1]||matrix[i-1][j];
            }
        }
        return matrix[m][n];
    }
}
