package leetcode.dp;

public class CutRodProblem {
    public static void main(String[] args) {
        int[] pL = {1,2,3,4};
        int[] pP = {2,5,7,8};
        int N = 5;

        System.out.println("Maximum Profit using piece length : " + maxProfitRod(pL,pP,N));
    }

    private static int maxProfitRod(int[] pL, int[] pP, int n) {
        int m = pL.length;
        int[][] matrix = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
            matrix[i][0]=0;
        for(int j=0; j<=n;j++)
            matrix[0][j]=0;
        for(int i=1;i<=m;i++){
            for(int j=1; j<=n; j++){
                if(j<pL[i-1])
                    matrix[i][j]=matrix[i-1][j];
                else
                    matrix[i][j]=Math.max(matrix[i-1][j],matrix[i][j-pL[i-1]]+pP[i-1]);
            }
        }
        return matrix[m][n];
    }
}
