package leetcode.array;

public class LeftSmallRightLarge {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 6, 15, 9, 11, 8, 10};
        int pivotIndex = findJunction(arr);
        System.out.println("Required Index");
        System.out.print(pivotIndex);
    }

    private static int findJunction(int[] arr) {
        int n = arr.length;
        int left [] = new int[n];
        int right [] = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = n-1; i>=0; i--){
            if(arr[i]<min)
                min=arr[i];
            right[i]=min;
        }

        for(int i =0; i<n;i++){
            if(arr[i]>max)
                max=arr[i];
            left[i]=max;
        }

        for(int i=0; i<n;i++)
            if(left[i]<=arr[i] && arr[i]<=right[i])
                return i;

        return -1;
    }
}
