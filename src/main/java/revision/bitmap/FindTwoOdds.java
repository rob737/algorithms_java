package revision.bitmap;

public class FindTwoOdds {
    public static void main(String[] args) {
        int[] arr = {2,4,7,9,2,4};
        int xorResult = findXor(arr);
        printDistinctNumbers(arr,xorResult);
    }

    private static void printDistinctNumbers(int[] arr, int xorResult) {
        int rightMostBitSetNumber = xorResult & ~(xorResult - 1);
        int first = 0, second = 0;
        for (int val : arr) {
            if ((val & rightMostBitSetNumber) !=0)
                first ^= val;
            else
                second ^= val;
        }
        System.out.println("First : " + first + " Second : " + second);
    }

    private static int findXor(int[] arr) {
        int result = 0;
        for(int val : arr)
            result=result^val;
        return result;
    }
}
