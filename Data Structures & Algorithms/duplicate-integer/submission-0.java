class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n  = nums.length;

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int val:nums){
            mp.put(val,mp.getOrDefault(val,0)+1);
        }

        Set<Integer> keys = mp.keySet();

        for(int k : keys){
            if(mp.get(k) > 1) return true;
        }
        return false;
    }
}