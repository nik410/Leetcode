class Solution {
    class MyComparator implements Comparator<Integer>{
        public int compare(Integer i1, Integer i2){
            return i2 - i1;
        }
    }
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(new MyComparator());

        long ans = 0;

        for(int i: nums){
            pq.offer(i);
        }

        while(k -- > 0 && !pq.isEmpty()){
            int top = pq.poll();

            ans += top;

            int insertNum = top % 3 == 0 ? top / 3: top / 3 + 1; 
            
            pq.offer(insertNum);
        }

        return ans;
    }
}
