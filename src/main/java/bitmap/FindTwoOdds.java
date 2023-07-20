package bitmap;

/*
* To find two distinct numbers, we need to divide the given array into two groups.
* since, in xor, set bit at a point implies different bits.
*
* */
public class FindTwoOdds {
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,3,1};
        int result = findXor(arr);
        // This will give me number that has only rightmost bit set.
        int rightMostSetBit = result & ~(result - 1);
        findOddOccurring(arr,rightMostSetBit);
    }

    /*
    * Logic : rightmost set bit in result implies that
    * one number will have that bit as 1 and other number must have that bit as 0.
    *
    * */
    private static void findOddOccurring(int[] arr, int rightMostSetBit) {
        int first=0,second=0;
        for(int val : arr){
            // This will filter out number that has rightmost bit set as the result.
            if((val & rightMostSetBit) == 1)
                first=first^val;
            else
                second=second^val;
        }
        System.out.println("Two odd occurring numbers are : " + first + " , " + second);
    }

    private static int findXor(int[] arr) {
        int result = 0;
        for(int val : arr)
            result=result^val;
        return result;
    }
}
