package leetcode.stack;

import java.util.Stack;

public class NextGreaterNumber {
    public static void main(String[] args) {
        int[] arr = {12, 8, 6, 10, 7, 9, 11, 1};
        int[] result = generateNextGreaterNumber(arr);
        System.out.println("Generating Next Greater element result set");
        for (int val : result)
            System.out.printf("%s ", val);
    }

    private static int[] generateNextGreaterNumber(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
}
