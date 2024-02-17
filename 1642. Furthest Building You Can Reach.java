class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 1; i < heights.length; i++){
            int diff = heights[i] - heights[i - 1];

            if(diff > 0){
                if(pq.size() < ladders){
                    pq.offer(diff);
                }
                else{
                    int bric = diff;

                    if(pq.size() > 0 && pq.peek() < diff){
                        bric = pq.remove();
                        pq.offer(diff);
                    }

                    if(bricks - bric >= 0){
                        bricks -= bric;
                    }
                    else{
                        return i - 1;
                    }
                }
            }
        }
        return heights.length - 1;
    }
}
