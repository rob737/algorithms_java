package leetcode.backtrack;

/*
* Calculate pow(x,n) in O(log N)
* */
public class CalculatePowXN {
    public static void main(String[] args) {
        int x =3,n=5;
        int result = generatePow(x,n);
        System.out.println("Result : " + result);
    }

    private static int generatePow(int x, int n) {
        int result;
        if(n==0)
            return 1;
        result = generatePow(x,n/2);
        if(n%2==0)
            return result*result;
        else
            return x*result*result;
    }
}
