package leetcode.array;

import java.util.Arrays;

public class NextSetOfHigherNumber {
    public static void main(String[] args) {
        int[] arr = {2,8,8,8,7};
        int n = arr.length, i = n - 1, minI = -1, min = Integer.MAX_VALUE, pivot = -1;


        while (i >= 1) {
            if (arr[i - 1] < arr[i]) {
                pivot = i;
                break;
            }
            i--;
        }

        if(pivot == -1){
            System.out.println("Next higher number is not possible");
            System.exit(2);
        }


        for (int j = pivot; j < n; j++) {
            if (arr[j] < min) {
                min = arr[j];
                minI = j;
            }
        }

        swap(arr, pivot-1, minI);

        Arrays.sort(arr, pivot, n);

        System.out.println("Next largest number");
        for(int v : arr)
            System.out.print(v + " ");

    }

    private static void swap(int[] arr, int pivot, int minI) {
        int temp = arr[pivot];
        arr[pivot] = arr[minI];
        arr[minI] = temp;
    }
}
