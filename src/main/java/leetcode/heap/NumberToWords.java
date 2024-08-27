package leetcode.heap;

public class NumberToWords {
    private static String[] digit_base = {"one","two","three","four","five","six","seven","eight","nine"};
    private static String[] digit_tenth = {"one","two","three","four","five","six","seven","eight","nine",
    "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    private static String[] digit_hundreth = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

    public static void main(String[] args) {
        int number = 2345;
        int count = 1;

        String word="";
        while(number!=0){
            String temp=" ";
            int base=10;
            int digit = number%10;
            int last_two_digits = number%100;
            if(last_two_digits>=10 && last_two_digits<=19){
                temp=digit_tenth[last_two_digits-1];
                base=100;
                count=2;
            }
            else{
                if(count==1)
                    temp=digit_base[digit-1];
                if(count==2)
                    temp=digit_hundreth[digit-2];
            }
            if(count==3)
                temp=digit_base[digit-1]+" hudndred";
            if(count == 4)
                temp=digit_base[digit-1]+" thousand";

            word=temp+" "+word;
            number = number/base;
            count++;
        }

        System.out.println("Generated word");
        System.out.println(word);

    }
}
