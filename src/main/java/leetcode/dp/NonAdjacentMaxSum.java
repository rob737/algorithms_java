package leetcode.dp;

public class NonAdjacentMaxSum {

    public static void main(String[] args) {
        int[] arr = {4,2,6,4,3,2};
        int sum = nonAdjacentMaxSum(arr);
        System.out.println("Max non adjacent sum " + sum);
    }


    private static int nonAdjacentMaxSum(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for(int i =0; i<n; i++)
            res[i]=arr[i];
        res[1] = Math.max(arr[0],arr[1]);
        for(int i=2; i<n; i++)
            res[i]=Math.max(res[i-1],arr[i]+res[i-2]);
        return res[n-1];
    }
}
