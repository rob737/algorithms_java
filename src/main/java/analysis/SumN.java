package analysis;
/*
* Asymptotic analysis is basically how program's computation is growing with input size.
*
* */
public class SumN {
    public static void main(String[] args) {
        int n = 5;
        long sum = 0;
        for(int i=1; i<=n ; i++)
            sum+=i;
        System.out.println("One way ... with O(N) complexity.");
        System.out.println(sum);

        System.out.println("Other way ... with O(1) complexity.");
        sum = n*(n+1)/2;
        System.out.println(sum);
    }
}
