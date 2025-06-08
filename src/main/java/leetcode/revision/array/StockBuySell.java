package leetcode.revision.array;

public class StockBuySell {
    public static void main(String[] args) {
        //int[] arr = {98,178,250,300,40,540,690};
        int[] arr = {690,540,40,178,250,98,300};
        int maxProfit = findMaxProfit(arr);
        System.out.println("Max profit that can be generated : " + maxProfit);
    }

    private static int findMaxProfit(int[] arr) {
        int n = arr.length, profit=0, i=0, buyIndex = -1, sellIndex = -1;

        while(i<n){
            if(i+1 < n && arr[i] < arr[i+1] && buyIndex == -1)
                buyIndex = i;
            else if (i == n-1 || arr[i] > arr[i+1] && sellIndex == -1)
                sellIndex = i;

            if(buyIndex>=0 && sellIndex > 0){
                System.out.printf("Buy at %d & Sell at %d ", buyIndex, sellIndex);
                System.out.println();
                profit += (arr[sellIndex] - arr[buyIndex]);
                buyIndex = sellIndex = -1;
            }
            i++;
        }

        return profit;
    }
}
