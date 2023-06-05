package array;

public class PivotElementArray {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,6,5,6,8,10};
        int res = findPivotElement(arr);
        System.out.println("Pivot element is " + res);
    }

    private static int findPivotElement(int[] arr) {
        int len = arr.length;
        int mid = len/2;
        int left = findLargest(arr,0,mid);
        int right = findSmallest(arr,mid+1,len);
        int i = mid;
        while(i<len){
            if(arr[mid]>=left && arr[mid]<=right)
                return arr[mid];
            else if(arr[mid] < left)
                mid++;
            else
                mid--;
            i++;
        }
        return -1;
    }

    private static int findSmallest(int[] arr, int i, int len) {
        int min = Integer.MAX_VALUE;
        for(int j=i; j<len; j++)
            if(arr[j]<min)
                min=arr[j];
        return min;
    }

    private static int findLargest(int[] arr, int i, int mid) {
        int max = Integer.MIN_VALUE;
        for(int j=i; j<mid; j++)
            if(arr[j]>max)
                max=arr[j];
        return max;
    }
}
