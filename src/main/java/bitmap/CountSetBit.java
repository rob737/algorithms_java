package bitmap;

public class CountSetBit {
    public static void main(String[] args) {
        int n = 2;
        int result = countSetBits(n);
        System.out.println("Number of set bits in n : " + result);
    }

    /*
    * Auxiliary Space Complexity : theta(1)
    * Time Complexity : theta(1)
    * Algorithm problem solving is primarily overcoming your confirmation bias.
    * Best way to tackle confirmation bias is to revisit the problem after 3 days or so.
    * */

    private static int countSetBits(int n) {
        int count = 0;
        while(n !=0 ){
            if((n&1) == 1)
                count++;
            n = n>>1;
        }
        return count;
    }
}
