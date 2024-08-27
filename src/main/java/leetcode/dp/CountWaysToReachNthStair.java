package leetcode.dp;

public class CountWaysToReachNthStair {
    public static void main(String[] args) {
        int n = 7;
        System.out.println("Ways to reach nth stair : " + countWays(n));
    }

    private static int countWays(int n) {
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            if(i<=1)
                arr[i]=1;
            else
                arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }
}
