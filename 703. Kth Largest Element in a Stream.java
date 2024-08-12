class KthLargest {

    PriorityQueue<Integer> pq;
    int siz;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue();
        siz = k;
        for(int i: nums){
            if(pq.size() < siz){
                pq.offer(i);
            }
            else if(pq.peek() < i){
                pq.poll();
                pq.offer(i);
            }
        }
    }
    
    public int add(int val) {
          if(pq.size() < siz){
                pq.offer(val);
            }
            else if(pq.peek() < val){
                pq.poll();
                pq.offer(val);
            }
            return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
