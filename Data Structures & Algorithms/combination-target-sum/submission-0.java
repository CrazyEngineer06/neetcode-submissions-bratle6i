class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums,res,temp,0,target);

        return res;
    }
    public void backtrack(int[] nums,List<List<Integer>> res,List<Integer> temp,int i,int target){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0 || i == nums.length){
            return;
        }

        //stay choice
        temp.add(nums[i]);
        backtrack(nums,res,temp,i,target-nums[i]);
        //skip choice
        temp.remove(temp.size()-1);
        backtrack(nums,res,temp,i+1,target);
    }
}
