package bitmap;

/*
* To find two distinct numbers, we need to divide the given array into two groups.
* since, in xor, set bit at a point implies different bits.
*
* */
public class FindTwoOdds {
    public static void main(String[] args) {
        int[] arr = {4,3,4,4,4,5,5};
        int result = findXor(arr);
        int brianKerninghamAlgorithm = result & ~(result - 1);
    }

    private static int findXor(int[] arr) {
        int result = 0;
        for(int val : arr)
            result=result^val;
        return result;
    }
}
