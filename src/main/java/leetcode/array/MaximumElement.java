package leetcode.array;

public class MaximumElement {

    public static void main(String[] args) { // O(log n)

        int[] arr = {6, 9, 15, 25, 50, 45, 43, 41, 29, 23, 8};

        int low = 0, high = arr.length, mid, max = Integer.MIN_VALUE;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                max = arr[mid];
                break;
            }

            if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1])
                low=mid+1;

            if(arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1] )
                high = mid -1;
        }

        System.out.println("Largest element in array is " + max);

    }
}
