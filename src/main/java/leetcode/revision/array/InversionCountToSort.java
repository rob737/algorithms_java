package leetcode.revision.array;

import java.util.Arrays;

public class InversionCountToSort {
    // Logic is same as merge sort.
    public static void main(String[] args) {
        int[] arr = {9,1,6,4,5};
        System.out.println(mergeSortAndCount(arr,0,arr.length-1));
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int invCount = 0;
        if(left < right){
            int mid = (left + right)/2;
            invCount += mergeSortAndCount(arr,left,mid);
            invCount += mergeSortAndCount(arr,mid+1,right);
            invCount += mergeSort(arr,left,mid,right);
        }
        return invCount;
    }

    private static int mergeSort(int[] arr, int l, int mid, int r) {
        int[] left = Arrays.copyOfRange(arr,l,mid+1);
        int[] right = Arrays.copyOfRange(arr,mid+1,r+1);

        int i=0,j=0,k=l,swaps=0;

        while(i< left.length && j < right.length){
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                // This is the trick here which is based on the premise that
                // in sorted array if element at i > element at j then
                // number of swaps required would be the count of numbers
                // from mid to ith index.
                swaps += (mid+1)-(l+i);
            }
        }
        while(i< left.length)
            arr[k++] = left[i++];
        while(j<right.length)
            arr[k++] = right[j++];
        return swaps;
    }
}
