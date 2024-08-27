package leetcode.array;

public class TwoNonRepeatingNumbers {

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 2, 4};

        int result = 0;

        for (int val : arr)
            result = val ^ result;

        int x = result, count = 0;

        // first LSB which is set.
        /*while ((x & 1) != 1) {
            count++;
            x = x >> 2;
        }*/

        int lsb = x & ~(x-1);
        int firstNum = 0, secondNum = 0;
        // separate into two arrays
        /*int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        int temp = 2 ^ count;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & temp) == 1)
                left[i] = arr[i];
            else right[i] = arr[i];
        }



        for (int i = 0; i < left.length; i++)
            firstNum = firstNum ^ left[i];

        for (int i = 0; i < right.length; i++)
            secondNum = secondNum ^ right[i];*/

        for(int val : arr){
            if((val & lsb) != 0)
                firstNum^=val;
            else
                secondNum^=val;
        }



        System.out.println(String.format("First num : %s and Second num : %s", firstNum, secondNum));

    }
}
