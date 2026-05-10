class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,temp,0,0);

        return res;
    }
    public void backtrack(int candidates[],int target,List<Integer> temp,int i,int total){
        if(total == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < total || i == candidates.length){
            return;
        }

        //yes choice
        temp.add(candidates[i]);
        backtrack(candidates,target,temp,i+1,total+candidates[i]);

        temp.remove(temp.size()-1);

        //skiping duplicates
        while(i+1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        //no choice
        backtrack(candidates,target,temp,i+1,total);
    }
}
