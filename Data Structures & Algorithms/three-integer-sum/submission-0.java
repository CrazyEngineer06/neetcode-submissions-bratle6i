class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n-2; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int target = -nums[i];
            int st = i+1;
            int end = n-1;

            while(st < end){
                if(nums[st] + nums[end] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[st]);
                    list.add(nums[end]);
                    res.add(list);

                    st++;
                    end--;

                    while(st < end && nums[st] == nums[st-1]) st++;
                    while(st < end && nums[end] == nums[end+1]) end--;

                } else if(nums[st] + nums[end] > target){
                    end--;
                } else {
                    st++;
                }
            }
        }

        return res;
    }
}