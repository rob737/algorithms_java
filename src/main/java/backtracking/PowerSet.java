package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    private static final List<ArrayList<Character>> result = new ArrayList<>();
    public static void main(String[] args) {
        String str = "abc";
        char[] strArr = str.toCharArray();
        subset(strArr);
        System.out.println("Power sets are : ");
        System.out.println(result);
    }

    private static void subset(char[] strArr) {
        int n = strArr.length;
        for(int size = 1; size<= n; size++)
            generateSubsets(strArr,new ArrayList<>(),0,size,n);
    }


    private static void generateSubsets(char[] strArr, ArrayList<Character> curr_list,int start, int size, int n) {

        if(curr_list.size() == size){
            // understand why result.add(curr_list) didn't work.
            result.add(new ArrayList<>(curr_list));
            return;
        }

        for(int i = start; i<n; i++){
            curr_list.add(strArr[i]);
            generateSubsets(strArr,curr_list,i+1,size,n);
            curr_list.remove(curr_list.size()-1);
        }
    }
}
