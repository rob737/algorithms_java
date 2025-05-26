package leetcode.revision;

import java.util.*;

public class SubarrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {6,3,-2,5,-3,7,-6,-1,4};
        printSubArrayWithSumZero(arr);
    }

    private static void printSubArrayWithSumZero(int[] arr) {
        int n = arr.length,sum=0;
        HashMap<Integer, Queue<Integer>> sumHash = new HashMap();

        for(int i = 0; i<n; i++){
            sum+=arr[i];
            if (sumHash.get(sum) == null) {
                Queue<Integer> indices = new LinkedList<>();
                indices.add(i);
                sumHash.put(sum, indices);
            } else {
                System.out.printf("Sub array with Zero sum found between %d,%d",sumHash.get(sum).poll()+1,i);
                System.out.println();
                sumHash.get(sum).add(i);
            }
        }
    }
}
