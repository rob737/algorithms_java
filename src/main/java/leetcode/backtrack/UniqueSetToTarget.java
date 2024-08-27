package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class UniqueSetToTarget {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayList<Integer> result = new ArrayList<>();
        int sum=0,target=6,index=0;
        printUniqueSet(arr,target,sum,result,index, arr.length);
    }

    private static void printUniqueSet(int[] arr, int target, int sum, ArrayList<Integer> result, int index, int n) {

        if(sum>target || index >= n)
            return;
        if(sum == target){
            System.out.println(result);
            return;
        }

        if(sum < target){
            sum = sum + arr[index];
            result.add(arr[index]);
            printUniqueSet(arr,target,sum,result,index,n);
            int decrement = result.remove(result.size()-1);
            sum = sum - decrement;
        }
        printUniqueSet(arr,target,sum,result,index+1,n);

    }
}
