class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int min = 1;
        int max = Integer.MIN_VALUE;

        for(int val:piles){
            min = Math.min(val,min);
            max = Math.max(val,max);
        }
        int minVal = Integer.MAX_VALUE;
        //Binary search
        while(min <= max){
            int mid = (min) + (max-min)/2;

            int minTime = minTime(mid,piles);

            if(minTime <= h){
                minVal = Math.min(minVal,mid);
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return minVal;
    }
    public int minTime(int k,int[] piles){
        int minTime = 0;

        for(int val:piles){
            // minTime += val/k;
            minTime += Math.ceil((double)val/k);
        }

        return minTime;
    }
}
