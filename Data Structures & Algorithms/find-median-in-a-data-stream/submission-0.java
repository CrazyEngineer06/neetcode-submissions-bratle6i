class MedianFinder {
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> higher;
    public MedianFinder() {
        smaller = new PriorityQueue<>((a,b) -> b-a);
        higher = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smaller.add(num);

        if((smaller.size() > higher.size() || !(higher.isEmpty()) &&smaller.peek() > higher.peek())){
            int val = smaller.poll();

            higher.add(val);
        }
        if(higher.size() > smaller.size()){
            smaller.add(higher.poll());
        }

    }
    
    public double findMedian() {
        if(smaller.size() == higher.size()){
            return (double)(higher.peek() + smaller.peek())/2;
        }else if(smaller.size() > higher.size()){
            return (double)smaller.peek();
        }else{
            return (double) higher.peek();
        }
    }
}
