package leetcode.graph;

import java.util.HashMap;

public class LongestCommonPrefix {
    static class Trie {
        boolean isEnd;
        HashMap<Character,Trie> bucket;
        Character firstEle;
        Trie(){
            this.bucket = new HashMap<>();
            isEnd = false;
            firstEle = Character.MIN_VALUE;
        }
    }

    private static boolean isInitialized = false;
    public static void main(String[] args) {
        Trie root = new Trie();
        insert(root,"flu",0);
        insert(root,"flow",0);
        insert(root,"flight",0);
        String longestCommonPrefix = findLongestCommonPrefix(root);
        System.out.println("Loongest common prefix " + longestCommonPrefix);
    }

    private static String findLongestCommonPrefix(Trie root) {
        String lcp="";
        while (root.bucket.size()==1){
            lcp=lcp+root.firstEle;
            root=root.bucket.get(root.firstEle);
        }
        return lcp;
    }

    private static void insert(Trie root, String word, int index) {
        if(word.length() == index+1){
            root.isEnd=true;
            return;
        }
        Character ch = word.charAt(index);
        if(!isInitialized){
            root.bucket.put(ch,new Trie());
            if(root.firstEle == Character.MIN_VALUE)
                root.firstEle=ch;
            root = root.bucket.get(ch);
            isInitialized=true;
            insert(root,word,index+1);
        }else{
            if(root.bucket.containsKey(ch)){
                root=root.bucket.get(ch);
                insert(root,word,index+1);
            }else{
                root.bucket.put(ch, new Trie());
                if(root.firstEle == Character.MIN_VALUE)
                    root.firstEle=ch;
                root = root.bucket.get(ch);
                isInitialized=true;
                insert(root,word,index+1);
            }
        }
    }
}
