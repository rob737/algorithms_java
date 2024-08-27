package leetcode.stack;

import java.util.Stack;

public class MinStack {
    // create a stack that supports getMin() in O(1) time.
    public static void main(String[] args) {
        int [] arr = {6,3,4,2,8,7};
        int minEle = arr[0];
        Stack<Integer> stack = new Stack<>();
        // push operation
        int curr = -1;
        for(int i =0; i<arr.length;i++){
            curr = arr[i];
            if(curr<=minEle) {
                stack.push(2*curr - minEle);
                minEle = curr;
            }else
                stack.push(curr);
        }

        // pop operation
        while (!stack.isEmpty()){
            if(stack.peek() < minEle){
                System.out.printf("Min Ele currently is : %s ", minEle);
                minEle = 2*minEle - stack.pop();
            }else {
                System.out.printf("Min Ele currently is : %s", minEle);
                stack.pop();
            }
        }

    }
}
