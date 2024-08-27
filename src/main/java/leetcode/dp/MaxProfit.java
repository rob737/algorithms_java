package leetcode.dp;

import java.util.Arrays;
import java.util.Iterator;

public class MaxProfit {

    static class Jobs{
        int startTime,endTime,profit;
        Jobs(int sT, int eT, int profit){
            this.startTime=sT;
            this.endTime=eT;
            this.profit=profit;
        }
    }

    public static void main(String[] args) {
        int[] startTime = {1,2,4,6,5,7};
        int[] endTime = {4,6,7,8,9,10};
        int[] profit = {3,5,5,11,7,13};
        Jobs[] jobs = new Jobs[startTime.length];

        for (int i = 0; i<startTime.length; i++) {
            jobs[i] = new Jobs(startTime[i],endTime[i],profit[i]);
        }

        // Sort jobs by end time descending using comparator.
        Arrays.sort(jobs, new FinishTimeComparator());

        Iterator<Jobs> itr = Arrays.stream(jobs).iterator();
        while(itr.hasNext()){
            System.out.println(itr.next().endTime);
        }

        int maxProfit = calculateMaxProfit(jobs,startTime.length);

        System.out.println("Max profit generated ...");
        System.out.println(maxProfit);
    }

    private static int calculateMaxProfit(Jobs[] jobs, int n) {
        int[] _jobs = new int[n];
        for(int i=0; i<n; i++)
            _jobs[i]=jobs[i].profit;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(jobs[j].endTime <= jobs[i].startTime){
                    _jobs[i]= Math.max(jobs[i].profit, jobs[i].profit+_jobs[j]);
                }
            }
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int profit:_jobs){
            if(maxProfit < profit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}
