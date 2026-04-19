class Solution {
    public int reverse(int x) {
        int maxLimit = 2147483647;
        int minLimit = -2147483648;

        int ans = 0;
        int i = 0;
        while(x != 0){
            int last = x%10;

            if(ans > maxLimit/10 || (ans == maxLimit/10 && last > maxLimit%10)){
                return 0;
            }

            if(ans < minLimit/10 || (ans == minLimit/10 && last < minLimit%10)){
                return 0;
            }
            ans = ans*10 + last;

            i++;
            x /= 10;
        }
        return ans;
    }
}
