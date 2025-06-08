package leetcode.revision.array;

public class TwoNonRepeatingNumbers {
    public static void main(String[] args) {
        int[] arr = {2,4,7,9,2,4};
        int result=0;
        for(int val : arr)
            result = result ^ val;
        int rightMostBitSet = result & ~(result-1);
        int a=0, b=0;
        for(int val : arr){
            if((val & rightMostBitSet) == 0)
                a=a^val;
            else
                b=b^val;
        }
        System.out.println("Two non repeating number " + a + "," + b);
    }
}
