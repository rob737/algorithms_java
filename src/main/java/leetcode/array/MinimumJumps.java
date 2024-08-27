package leetcode.array;

public class MinimumJumps {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 1, 1, 2, 6, 7, 6, 8, 9};
        int len = arr.length;
        int a = arr[0], b = arr[0], jump = 0;


        for (int i = 0; i < len; i++) {

            if (i == len - 1)
                System.out.println("Minimum number of jumps " + (jump ));

            a--;
            b--;

            if(arr[i] > b)
                b=arr[i];

            if (a == 0) {
                jump++;
                a=b;
            }


        }
    }
}
