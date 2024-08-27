package leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private static Map<String,String> map = new HashMap<>(){
        {
         put("2","abc");
         put("3","def");
         put("4","ghi");
         put("5","jkl");
         put("6","mno");
         put("7","pqrs");
         put("8","tuv");
         put("9","wxyz");
        }
    };

    private static List<String> output = new ArrayList<>();


    public static void main(String[] args) {
       String currList = "";
       String digits="345";
       findSequence(currList,digits);
        System.out.println("Results");
        System.out.println(output);
    }

    private static void findSequence(String currList, String digits) {
        if(digits.length() == 0){
            output.add(currList);
            return;
        }else{
            String digit = digits.substring(0,1);
            String letters = map.get(digit);
            for(int i =0; i< letters.length(); i++){
                String letter = letters.substring(i,i+1);
                findSequence(currList+letter,digits.substring(1));
            }
        }

    }
}
