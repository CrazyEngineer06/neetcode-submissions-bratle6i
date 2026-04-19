class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n+1];

        for(int i=0;i<=n;i++){
            arr[i] = cntOne(i);
        }
        return arr;
    }
    public int cntOne(int n){
        int cnt = 0;

        while(n > 0){
            if((n&1) == 1) cnt++;

            n >>= 1;
        }
        return cnt;
    }
}
