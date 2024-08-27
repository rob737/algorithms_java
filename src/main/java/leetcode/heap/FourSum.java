package leetcode.heap;

import java.util.HashMap;
/*
* Keys 0
Values 3: 5
Keys 1
Values 2: 5
Keys 2
Values 0: 2
Keys 5
Values 1: 5
Keys 6
Values 4: 5
Keys 7
Values 2: 4
Keys 11
Values 1: 4

* */

public class FourSum {
    static class Numbers{
        int first,  second;
        Numbers(int f, int s){
            this.first = f;
            this.second = s;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,1,0,6,0};
        int n = arr.length;
        int sum = 7;
        fourSumProblem(arr,n,sum);
    }

    private static void fourSumProblem(int[] arr, int n, int target) {
        HashMap<Integer,Numbers> map = new HashMap<>();
        for (int i =0; i<n-1;i++)
            for(int j=i+1;j<n;j++)
                map.put(arr[i]+arr[j], new Numbers(i,j));
        for(int i =0; i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int sum = arr[i]+arr[j];
                if(map.containsKey(target-sum)){
                    Numbers p = map.get(target-sum);
                    if(p.first!=i && p.second!=i && p.first!=j && p.second!=j){
                        System.out.println(arr[i]+", "+arr[j]+", "+arr[p.first]+", "+arr[p.second]);
                        break;
                    }

                }
            }
        }
    }
}
