package bitmap;

public class CountSetBit {
    public static void main(String[] args) {
        int n = 13;
        int result = countSetBits(n);
        System.out.println("Number of set bits in n : " + result);
    }

    /*
    * Auxiliary Space Complexity : theta(1)
    * Time Complexity : theta(1)
    * Algorithm problem solving is primarily overcoming your confirmation bias.
    * Best way to tackle confirmation bias is to revisit the problem after 3 days or so.
    * */

    /*
    * Commented code needs to be replaced with Brian Kerningam's Algorithm.
    * It has time complexity of theta(number of set bits).
    * Idea is to set last set bit in n as 0 using expression n & n-1 until n > 0
    * */
    private static int countSetBits(int n) {
        /*int count = 0;
        while(n !=0 ){
            if((n&1) == 1)
                count++;
            n = n>>1;
        }
        return count;*/
        int res = 0;
        while (n > 0){
            n = n & n-1; // this must make the last set bit as 0 in n.
            res++;
        }
        return res;
    }
}
