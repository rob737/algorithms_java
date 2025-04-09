package leetcode.graph;
import java.util.HashMap;
//Trie is storage efficient fixed dictionary (i.e. list of words) data structure.
public class TrieImplementation {
    static class TrieNode {
        boolean isEndOfword;
        HashMap<Character,TrieNode> current;
        TrieNode(){
            this.isEndOfword = false;
            this.current =new HashMap<>();
        }
    }

    private static boolean isInitialized = false;
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        boolean isExist = false;
        String word = "abcdx";
        String wordNext = "abzx";
        insert(root,word,0);
        insert(root,wordNext,0);
        isExist = seachWord("abcdx",root);
        System.out.println("Does word abcdx exist " + isExist);
        isExist = seachWord("abzx",root);
        System.out.println("Does word abzx exist " + isExist);
    }

    private static boolean seachWord(String toSearch, TrieNode root) {
        int index=0;

        while (root != null){
            char searchedChar = toSearch.charAt(index);
            if(root.isEndOfword)
                return true;
            root = root.current.get(searchedChar);
            index++;
        }
        return false;
    }

    private static void insert(TrieNode root, String word, int index) {
        if(word.length() == index+1){
            root.isEndOfword=true;
            return;
        }
        char ch = word.charAt(index);
        if(!isInitialized){
            TrieNode charNode = new TrieNode();
            root.current.put(ch,charNode);
            root.isEndOfword=false;
            root = root.current.get(ch);
            isInitialized=true;
            insert(root,word,index+1);
        }else{
            if(root.current.containsKey(ch)){
                root=root.current.get(ch);
                insert(root,word,index+1);
            }else{
                TrieNode charNode = new TrieNode();
                root.current.put(ch,charNode);
                root.isEndOfword=false;
                root=root.current.get(ch);
                insert(root,word,index+1);
            }
        }
    }
}
