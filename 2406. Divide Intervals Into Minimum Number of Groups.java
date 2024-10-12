class Solution {
    public int minGroups(int[][] intervals) {

        Arrays.sort(intervals, (x, y) ->{return x[0] - y[0];});
        
        PriorityQueue<Integer> depTimesEachGroup = new PriorityQueue();

        for(int i = 0; i < intervals.length; i ++){
            int arr = intervals[i][0];
            int dep = intervals[i][1];

            if(depTimesEachGroup.size() == 0){
                depTimesEachGroup.offer(dep);
            }
            else{
                if(depTimesEachGroup.peek() >= arr){
                    depTimesEachGroup.offer(dep);
                }
                else{
                    depTimesEachGroup.poll();
                    depTimesEachGroup.offer(dep);
                }
            }

        }

        return depTimesEachGroup.size();
    }
}
