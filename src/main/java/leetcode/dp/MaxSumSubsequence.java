package leetcode.dp;

public class MaxSumSubsequence {
    public static void main(String[] args) {
        int[] arr = {4,6,2,3,8,4,6};
        int n = arr.length;
        int _res = calculateMaxSum(arr,n);
        System.out.println("Maximum Increasing subsequence sum " + _res);
    }

    private static int calculateMaxSum(int[] arr, int n) {
        int [] res = new int[n];
        for(int i=0; i<n; i++)
            res[i]=arr[i];
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>=arr[j])
                    res[i]=Math.max(res[i], res[j]+arr[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
            if(max<res[i])
                max=res[i];
        return max;
    }
}
