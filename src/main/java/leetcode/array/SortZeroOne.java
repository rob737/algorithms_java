package leetcode.array;

public class SortZeroOne { // O(n) and O(1) space
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortArray(arr);
        System.out.println("Array sorted in liner time complexity");
        for(int val : arr)
            System.out.print(" " + val + " ");
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void sortArray(int[] arr) {
        int front = 0, curr = 0, rear = arr.length - 1;

        while (curr <= rear) {
            if (arr[curr] == 2) {
                swap(arr,curr,rear);
                rear--;
            }
            if(arr[curr] == 0){
                swap(arr,curr,front);
                front++;
            }
            curr++;
        }
    }
}
