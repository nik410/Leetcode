// Task: You are maintaining a project that has n methods numbered from 0 to n - 1.
//       You are given two integers n and k, and a 2D integer array invocations, where invocations[i] = [ai, bi] indicates that method ai invokes method bi.
//       There is a known bug in method k. Method k, along with any method invoked by it, either directly or indirectly, are considered suspicious and we aim to remove them.
//       A group of methods can only be removed if no method outside the group invokes any methods within it.
//       Return an array containing all the remaining methods after removing all the suspicious methods. You may return the answer in any order. If it is not possible to remove all the suspicious methods, none should be removed.

// Constraint: 1 <= n <= 105
//             0 <= k <= n - 1
//             0 <= invocations.length <= 2 * 105
//             invocations[i] == [ai, bi]
//             0 <= ai, bi <= n - 1
//             ai != bi
//             invocations[i] != invocations[j]

// Approach: use of bfs and dfs with a observation. The task statement was a bit tricky. first thought of dfs but yes that logic itself was wrong.

// Time and Space Complexity : 
//   TC : O(V + E)
//   SC: O(V + E)


class Solution {

    // class DSU{
    //     int parent[];
    //     int size[]; 

    //     DSU(int nodeCount){
    //         parent = new int[nodeCount + 1];
    //         size =  new int[nodeCount + 1];

    //         for(int i = 0; i < nodeCount + 1; i ++){
    //             parent[i] = i;
    //             size[i] = 1;
    //         }
    //     }


    //     void union(int node1, int node2){
    //         int root1 = find(node1);
    //         int root2 = find(node2);

    //         if(root1 != root2){
    //             if(size[root1] > size[root2]){
    //                 parent[root2] = root1;
    //                 size[root1] += size[root2];
    //             }
    //             else if(size[root1] <= size[root2]){
    //                 parent[root1] = root2;
    //                 size[root2] += size[root1];
    //             }
    //         }
    //     }

    //     int find(int node){
    //         if(parent[node] == node)return node;
    //         return parent[node] = find(parent[node]);
    //     }
    // }

    void dfs(int node, int visited[], List<List<Integer>> adjList, HashSet<Integer> sus){
        
        if(visited[node] == 0){
            sus.add(node);
        }

        visited[node] = 1;

        for(int i: adjList.get(node)){
            if(visited[i] == 0){
                dfs(i, visited, adjList, sus);
            }
        }

        return;
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int len = invocations.length;

        List<List<Integer>> adjList = new ArrayList();

        for(int i = 0; i < n; i ++){
            adjList.add(new ArrayList());
        }


        for(int i = 0; i < len; i ++){
            int n1 = invocations[i][0];
            int n2 = invocations[i][1];

            adjList.get(n1).add(n2);
        }

        // System.out.println(adjList);

        // DFS
        int visited[] = new int[n];
        HashSet<Integer> sus = new HashSet();
        dfs(k, visited, adjList, sus);

        List<Integer> al = new ArrayList();

        for(int i = 0; i < len; i ++){
            int n1 = invocations[i][0];
            int n2 = invocations[i][1];

            // As an external safe method depends on the sus methods we cant delete the sus methods
            if(!sus.contains(n1) && sus.contains(n2)){
                for(int j = 0; j < n; j ++){
                    al.add(j);
                }

                return al;
            }
        }

        for(int i = 0; i < n; i ++){
            if(!sus.contains(i)){
                al.add(i);
            }
        }

        return al;
    }
}
