class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);

        return rec(nums,0);
    }
    public int rec(int[] nums,int i){
        if(i >= nums.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }
        //consider
        int consider = rec(nums,i+2)+nums[i];
        
        //not consider
        int not_consider = rec(nums,i+1);

        dp[i] = Math.max(consider,not_consider);
        return dp[i];
    }
}
