class Solution {
    List<List<Integer>> res;
    Set<List<Integer>> s;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        s = new HashSet<>();
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        rec(list,0,nums);

        return res;
    }
    public void rec(ArrayList<Integer> list,int i,int nums[]){
        if(i == nums.length){
             if (!s.contains(list)) {
                res.add(new ArrayList<>(list));
                s.add(new ArrayList<>(list));
            }
            return;
        }

        //yes choice
        list.add(nums[i]);
        rec(list,i+1,nums);

        list.remove(list.size()-1);
        //no choice
        rec(list,i+1,nums);
    }
}
