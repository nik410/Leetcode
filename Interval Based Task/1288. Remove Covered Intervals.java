// Task: Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.
// The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
// Return the number of remaining intervals.

//   Constraint: 
//     1 <= intervals.length <= 1000
//     intervals[i].length == 2
//     0 <= li < ri <= 105
//     All the given intervals are unique.

// Approach: Use double for loop iterate each interval to every other O(n^2). Better way sort the array based on start time.


class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        int len = intervals.length;
        
        Arrays.sort(intervals, (x, y) ->{
            if(x[0] == y[0]){
                return Integer.compare(y[1], x[1]);
            }

            return Integer.compare(x[0], y[0]);
        });

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        int removed = 0;

        for(int i = 1; i < len; i ++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            // System.out.println("Index: " + " Start: "+ start + " End: "+ end);

            if(start >= prevStart && end <= prevEnd){
                removed ++;
                continue;
            }

            prevStart = start;
            prevEnd = end;
        }
        return len - removed;
    }
}
