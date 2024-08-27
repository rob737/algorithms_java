package leetcode.array;

public class NumberOccurringOnce {
    public static void main(String[] args) {
        int [] arr = {2,1,4,3,4,2,3};

        int result=0;

        for(int i : arr)
            result=result^i;

        System.out.println("Number occuring only once " + result);
    }
}
