package array;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strOne = sc.next();
        String strTwo = sc.next();
        System.out.println("Is Anagram : "+ isAnagram(strOne,strTwo));
    }

    private static boolean isAnagram(String strOne, String strTwo) {
        int len = strOne.length();
        if(strOne.length() != strTwo.length())
            return false;
        char[] sOne = strOne.toCharArray();
        char[] sTwo = strTwo.toCharArray();
        Arrays.sort(sOne);
        Arrays.sort(sTwo);
        for(int i = 0; i<len; i++){
            if(sOne[i] != sTwo[i])
                return false;
        }
        return true;
    }
}
