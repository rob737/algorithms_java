package leetcode.revision.array;

import java.util.Arrays;

public class KSmallestElement {
    public static void main(String[] args) {
        int[] arr = {54,26,93,17,77,31,44,20,55};
        int n=arr.length;
        int result = findKthSmallestElement(arr,0,n-1);
        System.out.println("Kth element is " + result);
    }

    private static int findKthSmallestElement(int[] arr, int begin, int end) {
        int k=5;
        int pivot = arr[end],i=begin,j=begin,pivotIndex=end;

        while(i<=pivotIndex){
            if(arr[i]<=pivot){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
            i++;
        }

        System.out.println(Arrays.toString(arr));
        pivotIndex = j-1;

        if(pivotIndex == k)
            return arr[pivotIndex];

        if(k < pivotIndex){
            // traverse left side of pivot Index
            return findKthSmallestElement(arr,0,pivotIndex-1);
        }else {
            // traverse right side of pivot Index
           return findKthSmallestElement(arr,pivotIndex+1,end);
        }

    }
}
