package leetcode.heap;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSorting {
    public static void main(String[] args) {
        int first[] = {5,8,9,3,5,7,1,3,4,9,3,5,1,8,4};
        int second[] = {3,5,7,2};

        customSort(first,second);
        System.out.println("After relative sorting :: " + Arrays.toString(first));
    }

    private static void customSort(int[] first, int[] second) {
        Map<Integer,Integer> freq = new TreeMap<>();
        for(int i : first)
            freq.put(i, freq.getOrDefault(i,0)+1);
        int index = 0;
        for(int i : second){
            int n = freq.getOrDefault(i,0);
            while (n-- > 0){
                first[index++] = i;
            }
            freq.remove(i);
        }
        // Tree Map stores keys in sorted format.
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            int count = entry.getValue();
            while(count -- > 0){
                first[index++]=entry.getKey();
            }
        }
    }
}
