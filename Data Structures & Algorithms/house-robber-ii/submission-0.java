class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        dp = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return Math.max(dfs(nums,0,1),dfs(nums,1,0));
    }
    public int dfs(int[] nums,int i,int flag){
        if(i >= nums.length || (flag == 1 && i == nums.length-1)){
            return 0;
        }
        if(dp[i][flag] != -1){
            return dp[i][flag];
        }

        int not_included = dfs(nums,i+1,flag);
        int included = nums[i] + dfs(nums,i+2,flag|(i == 0 ? 1:0));
        
        dp[i][flag] = Math.max(included,not_included);
        return dp[i][flag];
    }
}
