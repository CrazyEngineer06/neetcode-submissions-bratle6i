class Solution {
    //OKay so idea is simple we made a mask let suppose mask is 0101 so it means that index 0 and 2 is already used 
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        rec(perm,nums,0);
        return res;
    }
    public void rec(List<Integer> perm,int nums[],int mask){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if((mask & (1 << i)) == 0) { //here we are checking ith bit if 0 then include
                perm.add(nums[i]);
                rec(perm,nums,mask|(1<<i)); // setting ith bit to 1
                perm.remove(perm.size()-1);
            }
        }

    }
}