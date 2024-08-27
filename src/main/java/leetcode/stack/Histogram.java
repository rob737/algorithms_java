package leetcode.stack;

import java.util.Stack;

/*This is a HARD level problem*/
public class Histogram {

    private static int max_area=0;
    private static final int width = 1;

    public static void main(String[] args) {
        int [] arr = {6,2,5,4,5,1,6};
        int n = arr.length;
        findHistogram(arr,n);
        System.out.printf("Max area is : %s ", max_area);
    }

    private static void findHistogram(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int tp;
        int max_area_temp;
        int i = 0;

        while(i<n){
            if(s.isEmpty() || arr[s.peek()] <= arr[i] )
                s.push(i++);
            else {
                tp = s.peek();
                s.pop();
                max_area_temp = arr[tp] * (s.isEmpty() ? i : i-(s.peek() + width));
                if(max_area < max_area_temp)
                    max_area = max_area_temp;
            }
        }

        while (!s.isEmpty()) {
            tp = s.peek();
            s.pop();
            max_area_temp = arr[tp] * (s.isEmpty() ? i : i-(s.peek() + width));
            if(max_area < max_area_temp)
                max_area = max_area_temp;
        }
    }
}
