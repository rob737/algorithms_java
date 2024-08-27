package leetcode.heap;

public class StreamMedian {
    public static void main(String[] args) {
        int n = 6;
        int[] a = {12,4,5,3,8,7};
        int[] minHeap = new int[n];
        int[] maxHeap = new int[n];
        int minHeapSize = 0;
        int maxHeapSize = 0;
        Float currentMedian  = 0.0F;

        for(int i =0; i<a.length; i++){
            if(a[i]<currentMedian){
                maxHeap[maxHeapSize++]=a[i];
                if(maxHeap[maxHeapSize-1]>maxHeap[0]){
                    swap(maxHeap,maxHeapSize-1,0);
                }
            }else{
                minHeap[minHeapSize++]=a[i];
                if(minHeap[minHeapSize-1]<minHeap[0]){
                    swap(minHeap,minHeapSize-1,0);
                }
            }
            if(Math.abs(maxHeapSize-minHeapSize)>1){
                //logic
                if(maxHeapSize>minHeapSize){
                    swap(maxHeap,maxHeapSize-1,0);
                    minHeap[minHeapSize++]=maxHeap[--maxHeapSize];
                    swap(minHeap,0,minHeapSize-1);
                    buildMaxHeap(maxHeap,maxHeapSize);
                }else{
                    swap(minHeap,minHeapSize-1,0);
                    maxHeap[maxHeapSize++]=minHeap[--minHeapSize];
                    swap(maxHeap,0,maxHeapSize-1);
                    buildMinHeap(minHeap,minHeapSize);
                }
            }
            if(maxHeapSize == minHeapSize){
                currentMedian = Float.valueOf((float) ((minHeap[0]+maxHeap[0])/2.0));
            }else if(maxHeapSize > minHeapSize){
                currentMedian = Float.valueOf(maxHeap[0]);
            }else {
                currentMedian = Float.valueOf(minHeap[0]);
            }
            System.out.println("current median : " + currentMedian);
        }
    }

    private static void buildMinHeap(int[] minHeap, int minHeapSize) {
        int depth = (minHeapSize-1)/2; // last parent
        for(int i = depth; i>=0 ; i--){
            minHeapify(minHeap,i,minHeapSize);
        }
    }

    private static void minHeapify(int[] minHeap, int i, int minHeapSize) {
        int left = 2*i+1;
        int right = 2*i+2;

        int smallest = i;

        if(left<minHeapSize && minHeap[left]<minHeap[smallest])
            smallest = left;
        if(right<minHeapSize && minHeap[right]<minHeap[smallest])
            smallest = right;
        if(smallest != i){
            swap(minHeap,i,smallest);
            minHeapify(minHeap,smallest,minHeapSize);
        }
    }

    private static void buildMaxHeap(int[] maxHeap, int maxHeapSize) {
        int depth = (maxHeapSize-1)/2; // last parent
        for(int i = depth; i>=0 ; i--){
            maxHeapify(maxHeap,i,maxHeapSize);
        }
    }

    private static void maxHeapify(int[] maxHeap, int i, int maxHeapSize) {
        int left = 2*i+1;
        int right = 2*i+2;

        int largest = i;

        if(left<maxHeapSize && maxHeap[left]>maxHeap[largest])
            largest = left;
        if(right<maxHeapSize && maxHeap[right]>maxHeap[largest])
            largest = right;
        if(largest != i){
            swap(maxHeap,i,largest);
            minHeapify(maxHeap,largest,maxHeapSize);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if(i==j)
            return;
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
