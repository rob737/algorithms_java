package test;

import java.util.Arrays;

public class MergeSort {

    private static int[] result;

    public static void main(String[] args) {
        int[] input = {34,1,2,67,8,21,5};
        sortUsingMergeSort(input);
        System.out.print(Arrays.toString(input));
    }

    private static void sortUsingMergeSort(int[] input) {
        int len = input.length;
        result = new int[len];
        int mid = len/2, begin = 0, end = len -1;
        mergeSort(input,begin,mid);
        mergeSort(input,mid+1,end);
        mergeElements(input,begin,mid,end);
    }

    // 34,1,2,67,8,21,5
    private static void mergeSort(int[] input, int begin, int end) {
        if(begin >= end)
            return;

        int mid = (begin + end)/2;
        mergeSort(input,begin,mid);
        mergeSort(input,mid+1,end);
        mergeElements(input,begin,mid,end);
    }

    private static void mergeElements(int[] input, int begin, int mid, int end) {
        int i =begin, j = mid +1, k=begin;
        while(i<= mid && j<=end){
            if(input[i] <= input[j]){
                result[k++] = input[i++];
            }else {
                result[k++] = input[j++];
            }
        }
        while(i<=mid)
            result[k++]=input[i++];
        while(j<=end)
            result[k++]=input[j++];

        if (end + 1 - begin >= 0) System.arraycopy(result, begin, input, begin, end + 1 - begin);
    }
}
