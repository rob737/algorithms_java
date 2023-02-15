package array;

/*
* https://leetcode.com/problems/jump-game/
* */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println("Can Jump " + canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int len = nums.length;
        int a = nums[0], b = nums[0];
        for(int i =0; i<len; i++){
            if(a == 0 && b == 0 && len!=1)
                return false;
            a--;
            b--;

            if(b<nums[i])
                b=nums[i];
            if(a==0)
                a=b;
        }
        return true;
    }
}
