class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, subset, result);
        return result;
    }

    private void dfs(int[] candidates, int target, int i, List<Integer> subset, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(subset));
            return;
        }
        //if reached the end, return
        if(i == candidates.length || target < 0){
            return;
        }

        // left side of decision tree
        subset.add(candidates[i]);
        dfs(candidates, target - candidates[i], i + 1, subset, result);

        // right side of decision tree
        subset.remove(subset.size() - 1);

        //while next nums[i] is duplicate digit, skip
        while (i + 1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        dfs(candidates, target, i + 1, subset, result);
        
    }
}
