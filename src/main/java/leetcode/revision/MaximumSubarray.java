package leetcode.revision;

/*
* This is an implementation of Kadane's Algorithm.
* */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-5,6,-7,1,4,-2,16};
        findMaximumSubArray(arr);
    }

    private static void findMaximumSubArray(int[] arr) {
        int intermediateSum=0, resultSum=0, n=arr.length, startIndex=0, endIndex=0;

        for(int i=0; i<n; i++){
            intermediateSum = intermediateSum + arr[i];

            // This is the point at which it decides the new beginning index of sub array.
            if(intermediateSum < arr[i]) {
                intermediateSum = arr[i];
                startIndex = i;
            }

            if(intermediateSum > resultSum) {
                resultSum = intermediateSum;
                endIndex = i;
            }
        }

        System.out.println("Maximum subarray value : " + resultSum);
        System.out.printf("SubArray starts at %d & ends at %d",startIndex,endIndex);
    }
}
