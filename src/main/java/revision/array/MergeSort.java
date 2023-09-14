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
        int mid = (begin+end)/2;
        if(begin >= mid)
            return;

        // No need to store return value as current value of begin, mid, end will correspond to atomic value.
        mergeSort(arr,begin,mid);
        mergeSort(arr,mid+1,end);

        merge(arr,begin,mid,end);
    }

    private static void merge(int[] arr, int begin, int mid, int end) {
        int k = begin, j = mid+1;

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

    }
}
