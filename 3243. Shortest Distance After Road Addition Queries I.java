class Solution {

    public int bfs(int n, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList();
        q.offer(0);
        Set<Integer> vis = new HashSet();
        vis.add(0);
        int dist = 0;

        while(!q.isEmpty()){
            int siz = q.size();
            for(int i = 0; i < siz; i ++){
                int node = q.poll();
                if(node == n) return dist;
                for(int neigh: adj.get(node)){
                    if(!vis.contains(neigh)){
                        q.offer(neigh);
                        vis.add(neigh);
                    }
                }
            }
            
            dist ++;
        }

        return -1;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i = 0; i < n; i ++){
            adj.add(new ArrayList());
        }

        for(int i = 0; i < n - 1; i ++){
            adj.get(i).add(i + 1);
        }

        int ans[] = new int[queries.length];
        int index = 0;

        for(int i[]: queries){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            ans[index ++] = bfs(n - 1, adj);
        }

        return ans;
    }
}
