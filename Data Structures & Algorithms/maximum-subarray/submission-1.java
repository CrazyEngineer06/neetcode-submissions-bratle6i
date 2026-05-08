class Solution {
    public int maxSubArray(int[] nums) {
        //kadane's algorithm
        int max = nums[0];
        int currSum = 0;
        for(int val:nums){
            if(currSum < 0){
                currSum = 0;
            }
            currSum += val;
            max = Math.max(max,currSum);
        }
        return max;
    }
}
