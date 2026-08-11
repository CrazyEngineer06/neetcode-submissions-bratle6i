class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        return rec(prices,1,0,dp);
    }
    public int rec(int[] prices,int canBuy,int ind,int[][] dp){
        if(ind >= prices.length){
            return 0;
        }
        if(dp[ind][canBuy] != -1){
            return dp[ind][canBuy];
        }
        int profit = 0;
        if(canBuy == 1){
            //take
            int take = -prices[ind] + rec(prices,0,ind+1,dp);
            //notTake
            int notTake = 0 + rec(prices,1,ind+1,dp);

            profit = Math.max(take,notTake);
        }else{
            //sell
            int sell = prices[ind] + rec(prices,1,ind+2,dp);
            //notSale
            int notSell = 0 + rec(prices,0,ind+1,dp);

            profit = Math.max(sell,notSell);
        }

        return dp[ind][canBuy] = profit;
    }
}
