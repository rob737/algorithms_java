package revision.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    private static final List<ArrayList<Character>> result = new ArrayList<>();

    public static void main(String[] args) {
        String str = "abcd";
        generateSubsets(str);
        System.out.println(result);
    }

    private static void generateSubsets(String str) {
        char[] input = str.toCharArray();
        int n = input.length;
        // This pattern is needed when we can have different source for iteration.
        for(int i =1 ; i<=n ; i++)
            printSubsets(i, new ArrayList<>(), input, 0, n);
    }

    private static void printSubsets(int size, ArrayList<Object> currList, char[] input, int start, int n) {
        if(currList.size() == size){
            result.add(new ArrayList(currList));
            return;
        }

        for(int i = start; i<n; i++){
            currList.add(input[i]);
            printSubsets(size,currList,input,i+1,n);
            currList.remove(currList.size()-1);
        }
    }
}
