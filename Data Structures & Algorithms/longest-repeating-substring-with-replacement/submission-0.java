class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        
        HashMap<Character,Integer> mp = new HashMap<>();

        int res = 0;
        int l = 0, maxf = 0;
        for(int r=0;r<n;r++){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0) + 1);

            maxf = Math.max(maxf,mp.get(s.charAt(r)));

            while((r-l+1) - maxf > k){
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}