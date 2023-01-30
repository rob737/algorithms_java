package array;

/**
* https://leetcode.com/problems/search-in-rotated-sorted-array/
*
*
* */
public class ElementInRotatedArray {
    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target = 6;
        int rotationPoint = findRotationPoint(0,6,nums);
        int index = search(nums,target,rotationPoint);
        System.out.printf("Index : %d ", index);
    }

    private static int findRotationPoint(int begin, int end, int[] nums) {
        if(begin>=end)
            return end;
        int mid = (begin+end)/2;
        if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
            return mid;
        }else if(nums[mid]<nums[mid+1] && nums[mid]>nums[mid-1]){
            return findRotationPoint(mid+1,end,nums);
        }else {
            return findRotationPoint(begin,mid-1,nums);
        }
    }

    private static int search(int[] nums, int target, int rotationPoint) {
        int end = nums.length-1;
        int begin = 0;

        if(target>nums[begin])
            end=rotationPoint;
        else
            begin=rotationPoint+1;
        return binarySearchRotated(begin,end,nums,target);
    }

    private static int binarySearchRotated(int begin, int end, int[] nums, int target) {
        if(begin>end)
            return -1;
        int mid = (begin+end)/2;
        if(nums[mid]>target){
            return binarySearchRotated(begin,mid,nums,target);
        }else if(nums[mid]<target){
            return binarySearchRotated(mid+1,end,nums,target);
        }else{
            return mid;
        }
    }
}
