package leetcode.backtrack;

/*
* permutation of different strings that can be created from a word
*
* */
public class StringPermutation {
    public static void main(String[] args) {
        String text = "ABCD";
        char [] word = text.toCharArray();
        stringPermutation(word,0,word.length);
    }

    private static void stringPermutation(char[] word, int start, int end) {
        if(start == end){
            System.out.println(word);
            return;
        }

        for(int i = start; i<end;i++){
            swap(word,start,i);
            stringPermutation(word,start+1,end);
            swap(word,start,i);
        }
    }

    private static void swap(char[] word, int start, int i) {
        char temp = word[start];
        word[start] = word[i];
        word[i] = temp;
    }
}
