class Solution {
    public int leastInterval(char[] tasks, int n) {
        int size = tasks.length;
        int count[] = new int[26];
        int ans = 0;

        for(char ch : tasks){
            count[ch-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<26;i++){
            if(count[i] > 0){
                pq.add(count[i]);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(pq.isEmpty()){
                time = q.peek()[1];
            }else{
                int cnt = pq.poll()-1;
                if(cnt > 0){
                    q.add(new int[]{cnt,time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}