package bitmap;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 1;
        boolean result = isPowerOfTwo(n);
        System.out.println(result);
    }

    /*
    * If set bit is only 1 then it ensures that it is power of 2.
    * */
    private static boolean isPowerOfTwo(int n) {
        int count = 0;
        while(n>0){
            n =  n & n-1;
            count++;
        }
        return count == 1;
    }
}
