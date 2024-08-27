package leetcode.dp;

public class Knapsack {
    public static void main(String[] args) {
        int [] wt = {1,3,4,5};
        int [] val = {10,40,50,70};
        int max_value_procured = findMaxValue(wt,val);
        System.out.println("Maximum value that can be generated : " + max_value_procured);
    }

    private static int findMaxValue(int[] wt, int[] val) {
        int W = 8;
        int m = wt.length;
        int[][] matrix = new int[m+1][W+1];

        for(int i=0; i<=m; i++)
            matrix[i][0]=0;
        for(int j=0; j<=W; j++)
            matrix[0][j]=0;
        for(int i=1; i<=m; i++){
            for(int j=1;j<=W;j++){
                if(j>=wt[i-1])
                    matrix[i][j]=Math.max(matrix[i-1][j],val[i-1]+matrix[i-1][j-wt[i-1]]);
                else
                    matrix[i][j]=matrix[i-1][j];
            }
        }
        return matrix[m][W];
    }
}
