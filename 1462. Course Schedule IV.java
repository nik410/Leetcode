class Solution {

    public boolean dfs(List<List<Integer>> adj, int src, int dest, boolean visited[]){
        visited[src] = true;

        if(src == dest)return true;

        boolean isReachable = false;
        for(int i: adj.get(src)){
            isReachable = isReachable || dfs(adj, i, dest, visited);
        }

        return isReachable;
    }

    // public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    //     List<List<Integer>> adj = new ArrayList();

    //     for(int i = 0; i < numCourses; i ++){
    //         adj.add(new ArrayList());
    //     }

    //     for(int i = 0; i < prerequisites.length; i ++){
    //         int pre = prerequisites[i][0];
    //         int aft = prerequisites[i][1];
    //         adj.get(pre).add(aft);
    //     }

    //     // System.out.println(adj);

    //     List<Boolean> ans = new ArrayList();

    //     for(int i = 0; i < queries.length; i ++){
    //         int src = queries[i][0];
    //         int dest = queries[i][1];
    //         boolean visited[] = new boolean[numCourses];
    //         boolean isPossible = dfs(adj, src, dest, visited);

    //         ans.add(isPossible);

    //     }

    //     return ans;
    // }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList();

        for(int i = 0; i < numCourses; i ++){
            adj.add(new ArrayList());
        }

        int indegree[] = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i ++){
            int pre = prerequisites[i][0];
            int aft = prerequisites[i][1];
            adj.get(pre).add(aft);
            indegree[aft] ++;
        }

        Queue<Integer> q = new LinkedList();

        for(int i = 0 ; i < numCourses; i ++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        HashMap<Integer, HashSet<Integer>> hm = new HashMap(); 

        for(int i = 0; i < numCourses; i ++){
            hm.put(i, new HashSet<Integer>());
        }

        while(!q.isEmpty()){
            
            for(int in = 0; in < q.size(); in ++){
                int node = q.poll();

                for(int neigh: adj.get(node)){
                    HashSet<Integer> hs = hm.get(neigh);
                    hs.add(node);
                    

                    HashSet<Integer> hs1 = hm.get(node);
                    
                    for(int n: hs1){
                        hs.add(n);
                    }

                    hm.put(neigh, hs);
                  
                  indegree[neigh] --;
                    if(indegree[neigh] == 0){
                        q.offer(neigh);
                    }
                }
            }

        }

        List<Boolean> ans = new ArrayList();

        for(int i = 0; i < queries.length; i ++){
            int u = queries[i][0];
            int v = queries[i][1];

            if(hm.get(v).contains(u))ans.add(true);
            else{
                ans.add(false);
            }
        }
       

        return ans;
    }
}
