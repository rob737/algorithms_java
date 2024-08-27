package leetcode.backtrack;

import java.util.ArrayList;

public class PrintAllSubsets {

private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        subset(arr);
        // Print result
        result.add(new ArrayList());
        System.out.println(result);
    }

    private static void subset(int[] arr) {
        int n = arr.length;
        for(int size =1; size<=n; size++)
            generateSubsets(arr,new ArrayList<Integer>(), 0, size,n);
    }

    private static void generateSubsets(int[] arr, ArrayList<Integer> curr_list, int start, int size, int n) {

        if(curr_list.size() == size){
            result.add(new ArrayList<>(curr_list)); // Important otherwise result would be overridden.
            return;
        }

        for(int i=start; i<n;i++){
            curr_list.add(arr[i]);
            generateSubsets(arr,  curr_list,i+1,size,n);
            curr_list.remove(curr_list.size()-1);
        }
    }
}
