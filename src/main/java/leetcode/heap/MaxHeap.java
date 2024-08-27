package leetcode.heap;

public class MaxHeap {
    public static void main(String[] args) {
        int [] arr = {3,5,9,6,4,20,10,12,19,18,2,8};
        int n = arr.length;
        buildHeap(arr,n);
        printHeap(arr);
    }

    private static void printHeap(int[] arr) {
        for (int val: arr) {
            System.out.printf("%s ", val);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        int index = (n-1)/2;
        for(int i = index; i>=0; i--)
            heapify(arr,n,i);
    }

    private static void heapify(int[] arr,int n, int base) {
        int largest = base;
        int left = 2*largest + 1;
        int right = 2*largest + 2;

        if(left<n && arr[left]>arr[largest])
            largest = left;
        if(right<n && arr[right]>arr[largest])
            largest = right;

        if(largest != base){
            int swap = arr[base];
            arr[base] = arr[largest];
            arr[largest] = swap;
            heapify(arr,n,largest);
        }
    }
}
