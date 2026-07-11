// Task: You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.
// Return the number of complete connected components of the graph.
// A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
// A connected component is said to be complete if there exists an edge between every pair of its vertices.

// Constraint: 
//     1 <= n <= 50
//     0 <= edges.length <= n * (n - 1) / 2
//     edges[i].length == 2
//     0 <= ai, bi <= n - 1
//     ai != bi
//     There are no repeated edges.

// Approach: We can use BFS, DFS and Union find ( Disjoint Union Set ) with an additional array for edge count.
//   Had already solved this a year before. Looks like the Testcases were updated and the previous DSU solution was not working.
//   Looking at the DSU it was very wrong logically. Updated the DSU with additional edgeCount array.

  class Solution {

    // public boolean bfs(int src,  List<List<Integer>> adj, int visited[]){
    //     Queue<Integer> q = new LinkedList();
    //     int totalNodes = 0;
    //     int edges = 0;

    //     q.offer(src);
    //     visited[src] = 1;
    //     while(!q.isEmpty()){            
         
    //         int node = q.poll();
    //         totalNodes ++;
    //         for(int neigh: adj.get(node)){
    //             edges ++;
    //             if(visited[neigh] == 0){                    
    //                 visited[neigh] = 1;
    //                 q.offer(neigh);
    //             }
    //         }           
    //     }

    //     if(edges == 2 * (((totalNodes - 1) * (totalNodes))/ 2))return true;
    //     else return false;
    // }

    // public void dfs(int src,  List<List<Integer>> adj, int visited[], ArrayList<Integer> compo){
    //     visited[src] = 1;
    //     compo.add(src);
    //     for(int neigh: adj.get(src)){
    //         if(visited[neigh] == 0){
    //             dfs(neigh, adj, visited, compo);
    //         }
    //     }
    // }

    public int countCompleteComponents(int n, int[][] edges) {
        // List<List<Integer>> adj = new ArrayList();
        // int indegree[] = new int[n];

        // for(int i = 0; i < n; i ++){
        //     adj.add(new ArrayList());
        // }

        // for(int i = 0; i < edges.length; i ++){
        //     int x = edges[i][0];
        //     int y = edges[i][1];

        //     indegree[x] ++;
        //     indegree[y] ++;

        //     adj.get(x).add(y);
        //     adj.get(y).add(x);
        // }
        // //  System.out.println("Adj: " + adj);

        // for(int i: indegree){
        //      System.out.print(i + " ");
        // }
        //  System.out.println("------");

        // int visited[] = new int[n];
        // int ans = 0;

        // for(int i = 0; i < n; i ++){
        //     if(visited[i] == 0){
        //         // if(bfs(i, adj, visited))ans ++;
        //         ArrayList<Integer> compo = new ArrayList();
        //         dfs(i, adj, visited, compo);

        //         //Checking if all have same indegree and the edges are equal to ((compo.size - 1) * comp.size) / 2
        //         int edgeInCompleteGraph = ((compo.size() - 1) * compo.size()) / 2;
        
        //         boolean isComplete = true;
        //         for(int j: compo){
        //             if(indegree[j] != compo.size() - 1)
        //             {
        //                 isComplete = false;
        //                 break;
        //             } 
        //         }
        //         // System.out.println(compo  +" Compo" +  " Edges:" + edgeInCompleteGraph + "isCom: "+ isComplete);
        //         if(isComplete)ans ++;

        //     }
        // }
        // return ans;

        // Using Disjoint Set Union

        DSU d = new DSU(n);
        HashMap<Integer, Integer> rootEdge = new HashMap();

        for(int i = 0; i < edges.length; i ++){
            int x = edges[i][0];
            int y = edges[i][1];

            rootEdge.put(d.find(x), rootEdge.getOrDefault(d.find(x), 0) + 1);

            d.union(x, y);
        }

        int ans = 0;

        for(int i = 0; i < n; i ++){
            if(d.find(i) == i){
                int size = d.size[i];

                // System.out.println("Index: " + i + " size: " + size);

                if( ( ((size - 1) * (size)) / 2 ) == d.edgeCount[i]){
                    ans ++;
                }
            }
        }

       return ans;
    }

    public class DSU{
        int parent[];
        int size[];
        int[] edgeCount;

        DSU(int nodeCount){
            parent = new int[nodeCount];
            edgeCount = new int[nodeCount];
            for(int i = 0; i < nodeCount; i ++){
                parent[i] = i;
                edgeCount[i] = 0;
            }

            size = new int[nodeCount];
            Arrays.fill(size, 1);
        }

        public void union(int node1, int node2){
            int g1 = find(node1);
            int g2 = find(node2);

            if(g1 == g2){
                edgeCount[g1] ++;
                return;
            }

            if(size[g1] >= size[g2]){
                parent[g2] = g1;
                size[g1] += size[g2];
                edgeCount[g1] += edgeCount[g2] + 1;
            }
            else{
                parent[g1] = g2;
                size[g2] += size[g1];
                edgeCount[g2] += edgeCount[g1] + 1;
            }
        }

        public int find(int node){
            if(parent[node] == node)return node;
            
            return parent[node] = find(parent[node]);
        }
    }
}
