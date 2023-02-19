package array;

import java.util.Arrays;

/*
* https://leetcode.com/problems/next-greater-element-iii/
* Figure out what happens if number overflows
* */
public class NextGreaterElement {
    public static void main(String[] args) {
        int num = 1999999999;
        System.out.println("Next Greater Element " + nextGreaterElement(num) );
    }

    private static int nextGreaterElement(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int start=len;
        int[] numArr = new int[len];

        for(int i=0; i<len; i++){
            numArr[i]=numStr.charAt(i) - '0';
        }

        start = findSwappingPair(numArr);

        try
        {
            if(start < len) {
            Arrays.sort(numArr,start+1,len);
            long numL = 0;
            for(int val : numArr)
                numL =val + numL*10;
            if(numL> Integer.MAX_VALUE)
                return -1;
            return Integer.parseInt(numL+"");
        }else{
            return -1;
        }
        }catch (ArithmeticException ex){
            return -1;
        }
    }

    private static int findSwappingPair(int[] numArr) { // Amortized constant time.
        int len = numArr.length;
        int start = len;
        for(int i = len-2; i>=0; i--){
            for(int j = len-1; j>=i; j--){
                if(numArr[i]<numArr[j]){
                    int temp = numArr[i];
                    numArr[i] = numArr[j];
                    numArr[j]=temp;
                    start = i;
                    return start;
                }
            }
        }
        return start;
    }
}
