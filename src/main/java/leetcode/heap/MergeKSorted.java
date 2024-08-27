package leetcode.heap;

class MinHeapNode {
    int element;
    int i;
    int j;

    MinHeapNode(int ele, int i, int j){
        this.element = ele;
        this.i = i;
        this.j = j;
    }
};

public class MergeKSorted {
     MinHeapNode[] heap_arr;
     int heapSize;

     MergeKSorted(MinHeapNode[] arr, int size){
         heapSize = size;
         heap_arr = arr;
         int i = (heapSize - 1)/2;
         while (i>=0){
             minHeapify(i);
             i--;
         }
     }

    private void minHeapify(int i) {
         int left = 2*i+1;
         int right = 2*i+2;

         int smallest = i;

         if(left < heapSize && heap_arr[left].element <= heap_arr[smallest].element)
             smallest = left;
         if(right < heapSize && heap_arr[right].element <= heap_arr[smallest].element)
             smallest = right;
         if(smallest != i){
             swap(heap_arr,i,smallest);
             minHeapify(smallest);
         }
    }

    private void swap(MinHeapNode[] arr, int i, int smallest) {
         MinHeapNode temp = arr[i];
         arr[i] = arr[smallest];
         arr[smallest]=temp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{2,4,6,8},{0,9,10,11}};
        System.out.println("Merged sorted array is :: ");
        mergeKSortedArrays(matrix,matrix.length);
    }

    private static void mergeKSortedArrays(int[][] matrix, int k) {
         MinHeapNode[] hArr = new MinHeapNode[k];
         int resultSize =0;
         for(int i =0; i<matrix.length;i++){
             MinHeapNode node = new MinHeapNode(matrix[i][0],i,1);
             hArr[i]=node;
             resultSize += matrix[i].length;
         }
         MergeKSorted mergeKSorted = new MergeKSorted(hArr,k);
         int[] result = new int[resultSize];

         for(int i =0; i<resultSize; i++){
             MinHeapNode root = hArr[0];
             result[i]=root.element;
             if(root.j < matrix[root.i].length)
                 root.element = matrix[root.i][root.j++];
             else
                 root.element = Integer.MAX_VALUE;
             mergeKSorted.replaceMin(root);
         }
         printArray(result);
    }

    private static void printArray(int[] result) {
        for(int i : result)
         System.out.print(i + " ");
        System.out.println();
    }

    private void replaceMin(MinHeapNode root) {
         heap_arr[0] = root;
         minHeapify(0);
    }

}
