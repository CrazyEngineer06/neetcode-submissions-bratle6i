class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;

        int[] ngl = new int[n];
        int[] ngr = new int[n];

        ngl[0] = height[0];
        ngr[n-1] = height[n-1];

        //For left to right 
        for(int i=1;i<n;i++){
            ngl[i] = Math.max(ngl[i-1],height[i]);
        }

        //for right max
        for(int i=n-2;i>=0;i--){
            ngr[i] = Math.max(ngr[i+1],height[i]);
        }

        int res = 0;
        for(int i=0;i<n;i++){
            res += Math.min(ngl[i],ngr[i]) - height[i]; // Water at the top of bar
        }
        return res;
    }
}
