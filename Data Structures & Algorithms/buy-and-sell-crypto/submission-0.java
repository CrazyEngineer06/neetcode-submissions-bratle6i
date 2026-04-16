class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int maxProfit = 0;
        int currPrice = prices[0];
        for(int i=1;i<n;i++){
            int currProfit = prices[i]-currPrice;

            if(currProfit < 0){
                currPrice = prices[i];
            }else{
                maxProfit = Math.max(maxProfit,currProfit);

            }
        }
        return maxProfit;
    }
}
