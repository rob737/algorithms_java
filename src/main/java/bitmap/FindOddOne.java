package bitmap;

public class FindOddOne {
    public static void main(String[] args) {
        int[] arr = {8,7,7,8,8};
        int result = oddOneOut(arr);
        System.out.println("Result " + result);
    }

    private static int oddOneOut(int[] arr) {
        int result = 0;
        for(int x : arr)
            result = result ^ x;
        return result;
    }
}
