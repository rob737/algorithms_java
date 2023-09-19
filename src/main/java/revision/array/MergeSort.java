package revision.array;

public class MergeSort {
    private static int[] result;

    public static void main(String[] args) {
        int[] arr = {8,4,3,12,25,6,13,10};
        int n = arr.length;
        result = new int[n];
        mergeSort(arr,0,n-1);
        System.out.println("Merge Sorted Array");
        for(int val : result)
            System.out.print(val + " ");
    }

    private static void mergeSort(int[] arr, int begin, int end) {
        // This is a critical condition.
        /* if(begin>= mid) doesn't work because comparing begin with mid leads to bypass of computation in 2nd half of the array.
        * */
        if(begin >= end)
            return;
        int mid = (begin+end)/2;

        // No need to store return value as current value of begin, mid, end will correspond to atomic value.
        mergeSort(arr,begin,mid);
        mergeSort(arr,mid+1,end);

        merge(arr,begin,mid,end);
    }

    private static void merge(int[] arr, int begin, int mid, int end) {
        int k = begin, j = mid+1, start = begin;

        while (begin <= mid && j <= end){

            if(arr[begin] <= arr[j]){
                result[k++] = arr[begin++];
            }else{
                result[k++] = arr[j++];
            }
        }

        while (begin<=mid)
            result[k++]=arr[begin++];

        while (j <= end)
            result[k++]=arr[j++];

        // Copying back to original array is a necessary step as it implies that subset is sorted.
        for(int i = start; i<= end; i++)
            arr[i] =result[i];

    }
}
