package array;

/*
* Revision : https://leetcode.com/problems/sort-an-array/
* */
public class MergeSort {
    private static int[] arr = {8,4,3,12,25,6,13,10};
    private static int[] res = new int[arr.length];

    public static void main(String[] args) {
        int length = arr.length;
        mergeSort(0,length-1);
        for (int val:arr){
            System.out.printf("%d ",val);
        }
    }

    private static void mergeSort(int begin, int end) {
        if(begin>=end)
            return;
        int mid = (begin+end)/2;
        mergeSort(begin,mid);
        mergeSort(mid+1,end);
        merge(begin,mid,end);
    }

    private static void merge(int begin, int mid, int end) {
        int i = begin, j= mid+1, k = i;
        while (i<=mid && j<=end){
            if(arr[i]>arr[j]){
                res[k++]=arr[j];
                j++;
            }else{
                res[k++]=arr[i];
                i++;
            }
        }
        while (i<=mid)res[k++]=arr[i++];
        while (j<=end)res[k++]=arr[j++];

        for(int _i = begin; _i<=end; _i++)
            arr[_i]=res[_i];
    }


}
