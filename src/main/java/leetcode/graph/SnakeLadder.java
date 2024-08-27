package leetcode.graph;

import java.util.*;

public class SnakeLadder {

    static class Steps {
        int point;
        int diceRoll;

        Steps(int x, int y){
            this.point=x;
            this.diceRoll=y;
        }
    }

    private static HashMap<Integer,Integer> map = new HashMap<>();
    private static Set<Integer> isVisited = new HashSet<>();

    public static void main(String[] args) {
        markLadder(2,21);
        markLadder(4,7);
        markLadder(10,25);
        markLadder(19,28);
        markLadder(18,-1);
        markLadder(20,-1);
        markLadder(16,-1);
        markLadder(26,-1);
        int res = findMinimumDiceRoll(0);
        System.out.println("Minimum dice rolls needed to reach goal post : " + res);
    }

    private static int findMinimumDiceRoll(int src) {
        Queue<Steps> queue = new LinkedList<>();
        queue.add(new Steps(src,0));
        int diceThrowCount = 0;
        while (!queue.isEmpty()){
            Steps ref = queue.remove();
            diceThrowCount = ref.diceRoll;
            int currStep = ref.point;
            System.out.println("point : " + currStep + " : " + diceThrowCount);
            for(int i=0;i<6;i++){
                currStep++;
                if(currStep<30){
                    if(map.get(currStep) != null && map.get(currStep) != -1 && !isVisited.contains(map.get(currStep))){
                        queue.add(new Steps(map.get(currStep), diceThrowCount+1 ));
                        isVisited.add(map.get(currStep));
                    }
                    else if(map.get(currStep) == null && !isVisited.contains(currStep)){
                        queue.add(new Steps(currStep,diceThrowCount+1));
                        isVisited.add(currStep);
                    }
                }
            }
        }
        return diceThrowCount;
    }

    private static void markLadder(int src, int dest) {
        map.put(src,dest);
    }
}
