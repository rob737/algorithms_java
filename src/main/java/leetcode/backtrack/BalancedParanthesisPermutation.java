package leetcode.backtrack;

public class BalancedParanthesisPermutation {
    public static void main(String[] args) {
        int N  = 3;
        char[] arr = new char[2*N];
        findSequence(arr,0,N,0,0);
    }

    private static void findSequence(char[] arr, int index, int N, int openBracket, int closeBracket) {
        if(closeBracket == N){
            for(int i=0; i<arr.length;i++){
                System.out.printf("%s ", arr[i]);
            }
            System.out.println();
            return;
        }else {
            if(openBracket > closeBracket){
                arr[index] = '}';
                findSequence(arr,index+1,N,openBracket,closeBracket+1);
            }
            if(openBracket<N){
                arr[index]='{';
                findSequence(arr,index+1,N,openBracket+1,closeBracket);
            }
        }
    }
}
