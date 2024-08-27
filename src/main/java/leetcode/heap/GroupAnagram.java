package leetcode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] arr = {"cat","dog","tac","god","act"};
        groupAnagram(arr);
    }

    private static void groupAnagram(String[] arr) {
        int n = arr.length;
        HashMap<Integer, ArrayList<char[]>> map = new HashMap<>();
        for(int i =0; i<n; i++){
            char[] word = arr[i].toCharArray();
            int ascii_sum = generateAsciiSum(word);
            if (map.get(ascii_sum%n) == null) {
                map.put(ascii_sum%n, new ArrayList(Collections.singleton(word)));
            } else {
                map.get(ascii_sum%n).add(word);
            }
        }
        System.out.println("Display grouped anagrams");
        for(int key : map.keySet()){
            ArrayList<char[]> list =map.get(key);
            list.stream().forEach(System.out::print);
            System.out.println();
        }

    }

    private static int generateAsciiSum(char[] word) {
        int sum =0;
        for(char val : word)
            sum=sum+val;
        return sum;
    }
}
