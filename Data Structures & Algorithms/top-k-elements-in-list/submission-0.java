class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // okay so what i am thing of is we use bucket sort technique in this we made an array of list
        // and at every arr[i] we store the the numbers which appears exactly ith time
        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();

        List<Integer>[] freq = new List[nums.length + 1];

        for(int i=0;i<freq.length;i++){
            freq[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i=freq.length-1 ; i>0 && index < k ;i--){
            for(int val : freq[i]){
                res[index++] = val;

                if(index == k){
                    return res;
                }
            }
        }
        return res;
    }
}
