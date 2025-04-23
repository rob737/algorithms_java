package leetcode.array;

public class MaximumDifferenceWithinRange {
    public static void main(String[] args) {
        int[] arr = {35,9,12,3,2,70,31,33,1};
        // Problem : Find max of (j - i) such that A[i] <= A[j]
        findMax(arr);
    }

    private static void findMax(int[] arr) {
        int n = arr.length;
        int[] left_min = new int[n];
        int[] right_max = new int[n];
        int leftMin = 0, rightMax = n-1;
        int j=0,k=0;

        for(int i=0; i<n; i++){
            if(arr[i]<=arr[leftMin]){
                leftMin = i;
            }
            left_min[i]=leftMin;
        }

        for(int i=n-1; i>=0; i--){
            if(arr[i]>=arr[rightMax]){
                rightMax = i;
            }
            right_max[i]=rightMax;
        }

        int max=0;
        while(j<n || k>j){ // Trace this logic tomorrow.
            if(arr[right_max[j]] > arr[left_min[k]]){
                max = Math.max(max, right_max[j] - left_min[k]);
                j++;
            }else {
                k++;
            }
        }

        System.out.println(max);

    }
}
