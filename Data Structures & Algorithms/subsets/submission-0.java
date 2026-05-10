class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        rec(res,nums,0,temp);

        return res;
    }
    public void rec(List<List<Integer>> res, int nums[],int i,List<Integer> temp){
        if(i == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        //yes choice
        temp.add(nums[i]);
        rec(res,nums,i+1,temp);

        temp.remove(temp.size()-1);
        //no choice
        rec(res,nums,i+1,temp);
    }
}
