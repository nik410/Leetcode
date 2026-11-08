// Task: You are given two 0-indexed integer arrays servers and tasks of lengths n​​​​​​ and m​​​​​​ respectively. servers[i] is the weight of the i​​​​​​th​​​​ server, and tasks[j] is the time needed to process the j​​​​​​th​​​​ task in seconds.
//       Tasks are assigned to the servers using a task queue. Initially, all servers are free, and the queue is empty.
//       At second j, the jth task is inserted into the queue (starting with the 0th task being inserted at second 0). As long as there are free servers and the queue is not empty, the task in the front of the queue will be assigned to a free server with the smallest weight, and in case of a tie, it is assigned to a free server with the smallest index.
//       If there are no free servers and the queue is not empty, we wait until a server becomes free and immediately assign the next task. If multiple servers become free at the same time, then multiple tasks from the queue will be assigned in order of insertion following the weight and index priorities above.
//       A server that is assigned task j at second t will be free again at second t + tasks[j].
//       Build an array ans​​​​ of length m, where ans[j] is the index of the server the j​​​​​​th task will be assigned to.
//       Return the array ans​​​​.

// Constraint: servers.length == n
//             tasks.length == m
//             1 <= n, m <= 2 * 105
//             1 <= servers[i], tasks[j] <= 2 * 105

// Approach: Use two min heaps/ priority queue to main server ranking and active server end time

// Time and Space Complexity: 
//   TC: O(n * logn)
//   SC: O(n)

class Solution {

    class MyComparator implements Comparator<int []>{
        public int compare(int a[], int b[]){
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int serverLen = servers.length;
        int taskLen = tasks.length;

        PriorityQueue<int []> unactiveServerRanking = new PriorityQueue(new MyComparator());

        for(int i = 0; i < serverLen; i ++){
            unactiveServerRanking.offer(new int[]{servers[i], i});
        }

        // System.out.println("Top Ele: " + pq.peek()[0] + " Ind: "+  pq.peek()[1]);

        PriorityQueue<int []> activeServerEndTime = new PriorityQueue(new MyComparator());

        int ans[] = new int[taskLen];
        int currTime = 0;

        for(int i = 0; i < taskLen; i ++){
            int taskTime = tasks[i];

            currTime = Math.max(currTime, i);

            if (unactiveServerRanking.isEmpty()) {
                currTime = Math.max(currTime, activeServerEndTime.peek()[0]);
            }
           
            while(!activeServerEndTime.isEmpty() && activeServerEndTime.peek()[0] <= currTime){
                int serverDetWithSameTime[] = activeServerEndTime.poll();
                unactiveServerRanking.offer(new int[]{serverDetWithSameTime[2], serverDetWithSameTime[1]});
            }

            int serverAvail[] = unactiveServerRanking.poll();

            activeServerEndTime.offer(new int[]{currTime + taskTime, serverAvail[1], serverAvail[0]});
            ans[i] = serverAvail[1];
        
        }

        return ans;
    }
}
