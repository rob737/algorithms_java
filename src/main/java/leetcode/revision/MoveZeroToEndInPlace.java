package leetcode.revision;

import java.util.Arrays;

public class MoveZeroToEndInPlace {
    public static void main(String[] args) {
        int[] arr = {1,3,0,0,4,0,9};
        moveAllZeroToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveAllZeroToEnd(int[] arr) {
        int indexZero=-1,indexNonZero=0,i=0, n = arr.length;

        while(i<n){
            if(arr[i] == 0 && indexZero == -1)
                indexZero = i;
            if(arr[i]>0 && i>indexZero)
                indexNonZero = i;
            if(arr[indexNonZero]>0 && indexNonZero > indexZero && indexZero != -1){
                int temp = arr[indexZero];
                arr[indexZero] = arr[indexNonZero];
                arr[indexNonZero] = temp;
                indexZero++;
            }
            i++;
        }
    }
}
