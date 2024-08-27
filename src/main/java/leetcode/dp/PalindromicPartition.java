package leetcode.dp;

public class PalindromicPartition {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        char[] strArr = str.toCharArray();
        int res = findMinimumCuts(strArr);
        System.out.println("Minimum cuts required to have all palindromic partitions : " + res);
    }

    private static int findMinimumCuts(char[] arr) {
        int n = arr.length;
        int[] cut = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];

        for(int i=0; i<n ; i++){
            // By default, we assume that cuts required would be n-1 (assumption that all characters are different).
            int minCut = i;
            /*
            * this loop is required to find minimum cuts required to divide string from j to i into palindromic partitions.
            * logic is to assume cut at each character from j to i and calculate cuts required to have all palindromic partitions.
            *
            * */
            for (int j=0; j<=i; j++){
                if(arr[i]==arr[j] && (i-j<2 || isPalindrome[j+1][i-1])){
                    isPalindrome[j][i]=true;
                    /*
                    * if(i==j) : this signifies that if remaining characters except i & j forms a palindrome then whole string is palindrome
                    * which is calculated using matrix isPalindrome
                    * isPalindrome[j][i]=true signifies that substring from char str[j] to str[i] is a palindrome
                    *
                    * we need cut[j-1]+1 because it stores minimum cuts that were need to form palindromic partions between
                    * char at position 0 till j-1.
                    * and 1 denotes the current cut
                    * so total cut 1 + cut[j-1]
                    * */
                    minCut=Math.min(minCut, j==0?0:cut[j-1]+1);
                }
            }
            cut[i]=minCut;
        }
        return cut[n-1];
    }
}
