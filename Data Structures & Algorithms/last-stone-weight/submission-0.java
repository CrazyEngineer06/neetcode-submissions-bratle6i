class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int val:stones){
            pq.add(val);
        }

        while(!pq.isEmpty()){
            if(pq.size() == 1) return pq.remove();
            int num1 = pq.remove();
            int num2 = pq.remove();

            int absDiff = Math.abs(num1-num2);

            pq.add(absDiff);
        }
        return 0;
    }
}
