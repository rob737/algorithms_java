package revision.backtracking;

public class PowerXByN {

    public static void main(String[] args) {
        int x=-2, n = 10;
//        long result = computePower(x,n);
        long result = computePowerOptimized(x,n);
        System.out.println("x ^ n = " + result);
    }

    // Time Complexity is O(n). Can we reduce it?
    private static long computePower(int x, int n) {
        if(n <= 1)
            return x;
        return x * computePower(x,n-1);
    }

    // Time Complexity is O(log N).
    private static long computePowerOptimized(int x, int n){
        if(n<=1)
            return x;
        long result = computePowerOptimized(x,n/2);
        if(n % 2 == 0)
            result = result * result;
        else
            result = x * result * result;
        return result;
    }

}
