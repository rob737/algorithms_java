package leetcode.array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] towerHeight = {0,1,0,2,1,0,1,3,2,1,2,1};
        int maxUnitOfTrappedWater = findUnitOfTrappedWater(towerHeight);
        System.out.println("Max unit of water that can be contained : " + maxUnitOfTrappedWater);
    }

    private static int findUnitOfTrappedWater(int[] towerHeight) {
        int towerLength = towerHeight.length;
        int maxLeft = towerHeight[0], maxRight = towerHeight[towerLength-1];
        int[] max_left = new int[towerLength];
        int[] max_right = new int[towerLength];
        int maxUnitOfWater = 0;

        for(int i=0; i<towerLength; i++){
            if(towerHeight[i] >= maxLeft){
                maxLeft = towerHeight[i];
            }
            max_left[i] = maxLeft;
        }

        for(int i=towerLength-1; i>=0; i--){
            if(towerHeight[i]>=maxRight){
                maxRight = towerHeight[i];
            }
            max_right[i] = maxRight;
        }

        for(int i=1; i<towerLength-2; i++){
            int minHeight = Math.min(max_left[i],max_right[i]);
            int feasibleWaterHeight = Math.abs(towerHeight[i] - minHeight);
            maxUnitOfWater += feasibleWaterHeight > 0 ? feasibleWaterHeight : 0;
        }

        return maxUnitOfWater;
    }
}
