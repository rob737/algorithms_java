package leetcode.stack;

public class ReverseSentence {
    public static void main(String[] args) {
        String sentence = "Cracking The Coding Interview";
        // Expected output : interview coding the Cracking
        char[] charArray = sentence.toCharArray();
        int start = 0, end = charArray.length-1;
        reverseSentence(start,end,charArray);
        int space_index=0,begin_index=0;

        while (start<end){
            if(charArray[start] == ' '){
                space_index=start;
                reverseSentence(begin_index,space_index-1,charArray);
                begin_index=start+1;
            }
            start++;
        }

        // Reverse final word
        reverseSentence(space_index+1,end,charArray);
        System.out.println("printing reversed string word by word");
        for (char ch: charArray
             ) {
            System.out.printf("%s",ch);
        }
    }

    private static void reverseSentence(int start, int end, char[] sentence) {
        while(start < end) {
            swap(start, end, sentence);
            start++;
            end--;
        }
    }

    private static void swap(int start, int end, char[] sentence) {
        char temp = sentence[start];
        sentence[start] = sentence[end];
        sentence[end]=temp;
    }

}
