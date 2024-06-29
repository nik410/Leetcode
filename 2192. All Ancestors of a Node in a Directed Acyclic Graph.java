class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList();
        int indegree[] = new int[n];
        List<List<Integer>> adj = new ArrayList();

        for(int i = 0; i < n; i ++){
            ans.add(new ArrayList());
            adj.add(new ArrayList());
        }

       // Usage of set can bring better time complexity for duplicate node cases

        for(int i = 0; i < edges.length; i ++){
            indegree[edges[i][1]] ++;
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        Queue<Integer> q = new LinkedList();

        for(int i = 0; i < n; i ++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();


            List<Integer> ancestor = ans.get(node);
            for(int i = 0; i < adj.get(node).size(); i ++){
                indegree[adj.get(node).get(i)] --;
                if(indegree[adj.get(node).get(i)] == 0)q.add(adj.get(node).get(i));


                // Merging the child and  node list as node is one of parents

                for(int j = 0; j < ans.get(node).size(); j ++){
                    int ele = ans.get(node).get(j);
                    if(!ans.get(adj.get(node).get(i)).contains(ele))
                    ans.get(adj.get(node).get(i)).add(ele);
                }
                if(!ans.get(adj.get(node).get(i)).contains(node))
                ans.get(adj.get(node).get(i)).add(node);
            }
            }

            // System.out.println(ans + "sorted");

           

            for(int i = 0; i < ans.size(); i ++){
                List<Integer> temp = new ArrayList();
                for(int ele: ans.get(i))temp.add(ele);
                
                Collections.sort(temp);

               
                ans.get(i).clear();
                // System.out.println(ans + "sorted");
                for(int ele: temp)
                ans.get(i).add(ele);
            }

        return ans;
    }

    
}
