package leetcode.stack;

import java.util.Stack;

/** This is a hard level problem **/
public class MaxRectangleBinaryMatrix {
    private static int max_area=0;

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 1; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (matrix[i][j] == 1)
                    matrix[i][j] += matrix[i - 1][j];
        for(int i = 0; i<rows; i++)
            calculateMaxArea(matrix[i]);

        System.out.printf("Maximum calculated area : %s", max_area);
    }

    private static void calculateMaxArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int curr_area = 0,i=0;
        int n = arr.length;

        while(i<n){
            if(stack.isEmpty() || arr[stack.peek()] <= arr[i])
                stack.push(i++);
            else{
                int top = stack.pop();
                curr_area = arr[top] * (stack.isEmpty() ? i : i-(stack.peek()+1));
                if(curr_area>max_area)
                    max_area = curr_area;
            }
        }

        while (!stack.isEmpty()) {
            int tp = stack.peek();
            stack.pop();
            curr_area = arr[tp] * (stack.isEmpty() ? i : i-(stack.peek() + 1));
            if(max_area < curr_area)
                max_area = curr_area;
        }


    }
}
