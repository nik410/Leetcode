class Solution {

    public static void dfs(int node, ArrayList<ArrayList<Integer>> al, boolean visited[]){
        if(visited[node] == true)return;
        visited[node] = true;

        for(int i = 0; i < al.get(node).size(); i++){
            dfs(al.get(node).get(i), al, visited);
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
     ArrayList<ArrayList<Integer>> al = new ArrayList();
     boolean visited[] = new boolean[n];

     for(int i  = 0; i < n; i++){
        al.add(new ArrayList());
     }

     for(int i = 0; i < edges.length; i++){
        al.get(edges[i][0]).add(edges[i][1]);
        al.get(edges[i][1]).add(edges[i][0]);
     }
     dfs(source, al, visited);
    return visited[destination];

    }
}
