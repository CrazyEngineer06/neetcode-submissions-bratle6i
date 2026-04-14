class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap (based on frequency)
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );

        // Step 3: Maintain heap of size k
        for (int num : freqMap.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll(); // remove least frequent
            }
        }

        // Step 4: Extract result
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }

        return result;
        
    }
}
