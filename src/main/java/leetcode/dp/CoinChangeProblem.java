package leetcode.dp;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int[] coins = {2,3,4};
        int target = 6;
        System.out.println("Distinct ways to accumulate target amount : " + countDistinctWays(coins,target));
    }

    private static int countDistinctWays(int[] coins, int target) {
        int m = coins.length;
        int[][] matrix = new int[m+1][target+1];
        for(int i=0; i<=m; i++)
            matrix[i][0]=1;
        for(int j=1; j<=target; j++)
            matrix[0][j]=0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=target; j++){
                if(j<coins[i-1])
                    matrix[i][j]=matrix[i-1][j];
                else
                    matrix[i][j]=matrix[i-1][j]+matrix[i][j-coins[i-1]];
            }
        }

        return matrix[m][target];
    }
}
