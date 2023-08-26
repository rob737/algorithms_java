package revision.backtracking;

public class PowerXByN {

    public static void main(String[] args) {
        int x=2, n = 10;
        long result = computePower(x,n);
        System.out.println("x ^ n = " + result);
    }

    // Time Complexity is O(n). Can we reduce it?
    private static long computePower(int x, int n) {
        if(n <= 1)
            return x;
        return x * computePower(x,n-1);
    }

}
