class Solution {
    public int maxArea(int[] heights) {
        int maxWater = Integer.MIN_VALUE;

        int n = heights.length;

        int lo = 0;
        int hi = n-1;

        while(lo < hi){
            int water = Math.min(heights[lo],heights[hi])*(hi-lo);
            maxWater = Math.max(maxWater , water);

            if(heights[lo] < heights[hi]){
                lo++;
            }else if(heights[lo] > heights[hi]){
                hi--;
            }else{
                lo++;
            }
        }
        return maxWater;
    }
}
