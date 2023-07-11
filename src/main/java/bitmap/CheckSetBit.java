package bitmap;

public class CheckSetBit {
    public static void main(String[] args) {
        // Refactor it to take input from user.
        int n = 8, k =4;
        boolean result = checkKthSetBit(n,k);
        System.out.println(result);
    }

    /*
    * Time complexity :  θ(1) since any number n will be represented as 32 or 64 bit architecture.
    * Auxiliary Space complexity : θ(1)
    * */
    private static boolean checkKthSetBit(int n, int k) {
        n = n >> k-1;
        return (n&1) == 1;
    }

}
