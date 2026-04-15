class Solution {
    public int longestConsecutive(int[] nums) {
        //---------------Method 1 -> O(nlogn)--------------------
        // int n = nums.length;

        // if(n == 0) return 0;

        // Arrays.sort(nums);
        // int cnt = 1;
        // int maxCnt = 0;
        // for(int i=1;i<n;i++){
        //     if(nums[i]-nums[i-1] == 1){
        //         cnt++;
        //     }else if(nums[i] == nums[i-1]){
        //         continue;
        //     }
        //     else{
        //         maxCnt = Math.max(maxCnt,cnt);
        //         cnt = 1;
        //     }
        // }
        // maxCnt = Math.max(maxCnt,cnt);
        // return maxCnt;

        //----------------Method 2 -> O(n)-------------
        Set<Integer> set = new HashSet<>();

        for(int num :nums){
            set.add(num);
        }

        int longest = 0;

        for(int i : set){
            if(!set.contains(i-1)){
                int length = 1;
                while(set.contains(i+length)){
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
