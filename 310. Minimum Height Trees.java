class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList();

        if(n == 1){
            ans.add(0);
            return ans;
        }

        int indegree[] = new int[n];
        ArrayList<ArrayList<Integer>> al = new ArrayList();

        for(int i =0; i < n; i++){
            al.add(new ArrayList());
        }
        for(int i = 0; i < edges.length; i++){
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;

            al.get(edges[i][0]).add(edges[i][1]);
           
            al.get(edges[i][1]).add(edges[i][0]);            
        }

        Queue<Integer> q = new LinkedList();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 1)q.offer(i);
        }

        while(n > 2){
            int siz = q.size();
            n -= siz;

            for(int i =0; i < siz; i++){
                int front = q.peek();
                q.poll();

                for(int j = 0; j < al.get(front).size(); j++){
                    int secondNode = al.get(front).get(j);
                    indegree[secondNode]--;

                    if(indegree[secondNode] == 1)q.offer(secondNode);
                }
            }
        }

        while(!q.isEmpty()){
            ans.add(q.poll());
        }

        return ans;
    }
}
