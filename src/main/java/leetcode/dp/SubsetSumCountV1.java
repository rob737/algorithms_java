package leetcode.dp;

public class SubsetSumCountV1 {
    public static void main(String[] args) {
        int[] set = {1,2,3,4};
        int target = 8;
        System.out.println("Is Subset exists : " + (ssp(set,target)>0 ? "Yes":"No"));
    }

    private static int ssp(int[] set, int target) {
        int n = set.length;
        int[][] matrix = new int[n+1][target+1];

        for(int i =0; i<=n; i++)
            matrix[i][0]=1;
        for(int j=1; j<=target; j++)
            matrix[0][j]=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=target; j++){
                if(set[i-1]>j)
                    matrix[i][j]=matrix[i-1][j];
                else
                    matrix[i][j]=matrix[i-1][j]+matrix[i-1][j-set[i-1]];
            }
        }
        return matrix[n][target];
    }
}
