package bitmap;

public class CheckSetBit {
    public static void main(String[] args) {
        // Refactor it to take input from user.
        int n = 8, k =4;
        boolean result = checkKthSetBit(n,k);
        System.out.println(result);
    }

    private static boolean checkKthSetBit(int n, int k) {
        n = n >> k-1;
        return (n&1) == 1;
    }

}
