package revision.array;

import java.util.ArrayList;
import java.util.List;

/*
* Move all zeros to the end without sorting and maintaining relative position of other elements.
* */
public class MoveAllZero {

    public static void main(String[] args) {
        int [] input = {1,3,0,0,4,0,9};
        moveZeroToEnd(input);
        System.out.println("Result after modifying.");
        for(int val : input)
        System.out.println(val);
    }






    private static void moveZeroToEnd(int[] input) {
        /*
        * I think, we can use 2 pointer technique here.
        * first pointer will track index of element 0 and second will
        * be used to swap non-zero element with 0.
        * */
        int front=0,rear=1;
        int n = input.length;

        while (rear < n){
            if(input[front]!=0)
                front++;



            if(front < rear && input[front] == 0 && input[rear]!=0){
                int temp = input[front];
                input[front] = input[rear];
                input[rear] = temp;
            }
            rear++;
        }
    }

}
