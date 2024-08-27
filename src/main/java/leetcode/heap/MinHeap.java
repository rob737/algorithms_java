package leetcode.heap;

public class MinHeap {
    public static void main(String[] args) {
        int [] arr = {3,5,9,6,4,20,10,12,19,18,2,8};
        buildMinHeap(arr,arr.length);
        printMinHeap(arr);
    }

    private static void printMinHeap(int[] arr) {
        for (int val: arr) {
            System.out.printf("%d ", val);
        }
    }

    private static void buildMinHeap(int[] arr, int length) {
        int start = (length-1)/2;
        for(int i = start; i>=0; i--)
            heapify(arr,length,i);
    }

    private static void heapify(int[] arr, int n, int i) {
        int min = i;
        int left = 2*min+1;
        int right = 2*min+2;

        if(left<n && arr[left]<arr[min])
            min=left;
        if(right<n && arr[right]<arr[min])
            min=right;
        if(min!=i){
         int swap = arr[i];
         arr[i]=arr[min];
         arr[min]=swap;
         heapify(arr,n,min);
        }
    }
}
