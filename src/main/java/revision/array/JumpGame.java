package revision.array;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {1,3,5,8,9,2,6,7,6,8,9};
        int minimumJump = minJumpRequired(arr);
        System.out.println("Minimum number os jumps required to reach last index : " + minimumJump);
    }

    private static int minJumpRequired(int[] arr) {
        int len = arr.length, jump=0, a = arr[0], b = arr[0];

        for(int i=0; i<len; i++){

            // It means we have reached at the end of the arr which is our destination.
            if(i==len-1)
                return jump;

            // a and b denotes the step and jump is basically when a becomes 0 i.e. maximum value of a.
            a--;
            // decrementing b is necessary to cover for the steps (a - b) i.e. it doesn't matter whether you are jumping from a
            // or jumping from b as (a - b) covers that distance. Hence, giving the illusion of backtracking.
            b--;

            /*
            * This is the most critical condition as it assigns b with maximum value till now.
            * Since, we need to calculate minimum jump, if we fallback to maximum possible value
            * when a gets 0 then it ensures minimum jump to reach the last index.
            * */
            if(b < arr[i])
                b = arr[i];

            if(a == 0){
                jump++;
                a=b;
            }
        }

        return -1;
    }
}
