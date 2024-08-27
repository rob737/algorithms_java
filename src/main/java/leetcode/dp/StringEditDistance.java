package leetcode.dp;

public class StringEditDistance {
    public static void main(String[] args) {
        String wordOne = "sunday";
        String wordTwo = "saturday";
        System.out.println("Minimum operation to conver wordOne to wordTwo " + minOperation(wordOne, wordTwo));
    }


    private static int minOperation(String wordOne, String wordTwo) {
        int m = wordOne.length(), n = wordTwo.length();
        int[][] matrix = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    matrix[i][j] = j;
                else if (j == 0)
                    matrix[i][j] = i;
                else if (wordOne.charAt(i - 1) == wordTwo.charAt(j - 1))
                    matrix[i][j] = matrix[i - 1][j - 1];
                else
                    matrix[i][j] = 1+Math.min(matrix[i-1][j-1], Math.min(matrix[i][j-1],matrix[i-1][j]));
            }
        }
        return matrix[m][n];
    }
}
