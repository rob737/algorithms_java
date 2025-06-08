package leetcode.revision.array;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arrival = {100,140,150,200,215,400};
        int[] departure = {110,300,220,230,315,600};

        int minPlatform = findMinPlatform(arrival,departure);
        System.out.println("Minimum platform required : " + minPlatform);
    }

     // This is a classic case of interval overlapping problem where in we need to find minimum
    // resource to satisfy demand of all participants.
    private static int findMinPlatform(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i=0,j=0,platform=0,minPlatform=0,m=arrival.length,n=departure.length;

        while(i<m && j<n-1){
            if(arrival[i]<=departure[j]){
                platform++;
                minPlatform = Math.max(platform,minPlatform);
                i++;
            }else{
                platform--;
                j++;
            }
        }

        return minPlatform;
    }
}
