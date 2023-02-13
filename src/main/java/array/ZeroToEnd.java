package array;

/*
* Move all 0's to end of array, only single traversal is allowed.
* https://leetcode.com/problems/move-zeroes/
* */
public class ZeroToEnd {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int val:nums)
        System.out.print(val+" ");
    }

    private static void moveZeroes(int[] nums) {
        int zeroIndex =0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]!=0){
                swap(zeroIndex,i,nums);
                zeroIndex++;
            }
        }
    }

    private static void swap(int zeroIndex, int i, int[] nums) {
        int temp = nums[zeroIndex];
        nums[zeroIndex] = nums[i];
        nums[i] = temp;
    }
}
