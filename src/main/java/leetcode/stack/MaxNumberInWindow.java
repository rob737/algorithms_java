package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxNumberInWindow {
    public static void main(String[] args) {
        int[] array = {8,6,10,7,5,17,14,87,15};
        int k =3;
        maxInSubArray(array,array.length,k);
    }

    private static void maxInSubArray(int[] array, int n, int k) {
        Deque<Integer> Qi = new LinkedList<>();
        int i;
        for(i=0;i<k;i++){
            while (!Qi.isEmpty() && array[i] >= array[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }
        for(;i<n;++i){
            System.out.println(array[Qi.peek()] + " ");
            while (!Qi.isEmpty() && Qi.peek() <= i-k)
                Qi.removeFirst();
            while (!Qi.isEmpty() && array[i]>=array[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }
        System.out.println(array[Qi.peek()] + " ");
    }
}
