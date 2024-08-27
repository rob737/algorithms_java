package leetcode.dp;

public class SubsetPartition {
    public static void main(String[] args) {
        int [] arr = {2,3,4,6,2};
        int n = arr.length;
        int sum = 0;
        for(int val:arr)
            sum+=val;
        boolean[][] matrix = new boolean[n+1][(sum/2)+1];
        for(int i=0; i<=n; i++)
            matrix[0][i]=true;
        for(int j=1;j<=sum/2;j++)
            matrix[1][j]=false;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum/2;j++){
                if(j>=arr[i-1])
                    matrix[i][j]=matrix[i-1][j-arr[i-1]];
                else
                    matrix[i][j]=matrix[i-1][j];
            }

        }
        System.out.println(matrix[n][sum/2]);

    }

}
