package leetcode.revision.array;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {8,4,3,12,25,6,13,10};
        int [] result = new int [arr.length];
        sortArrayUsingMergeSort(arr,0,arr.length-1,result);
        System.out.println(Arrays.toString(arr));

    }

    private static void sortArrayUsingMergeSort(int[] arr, int begin, int end, int[] result) {
        int mid = (begin + end)/2;
        if(begin >= end)
            return;

        sortArrayUsingMergeSort(arr,begin,mid,result);
        sortArrayUsingMergeSort(arr,mid+1,end,result);
        merge(arr,begin,mid,end,result);
    }

    private static void merge(int[] arr, int begin, int mid, int end, int[] result) {
        int i = begin, j=mid+1, k=begin;
        while(i<= mid && j<=end){
            if(arr[i]<=arr[j])
                result[k++]=arr[i++];
            else
                result[k++]=arr[j++];
        }

        while(i<=mid)
            result[k++]=arr[i++];
        while(j<=end)
            result[k++]=arr[j++];

        for(int _i=begin; _i<=end; _i++)
            arr[_i] = result[_i];
    }
}
