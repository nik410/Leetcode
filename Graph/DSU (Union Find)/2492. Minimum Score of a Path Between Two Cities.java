// Task: You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.
// The score of a path between two cities is defined as the minimum distance of a road in this path.
// Return the minimum possible score of a path between cities 1 and n.
// Note:
//     A path is a sequence of roads between two cities.
//     It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
//     The test cases are generated such that there is at least one path between 1 and n.

// Constraint: 
//     2 <= n <= 10^5
//     1 <= roads.length <= 10^5
//     roads[i].length == 3
//     1 <= ai, bi <= n
//     ai != bi
//     1 <= distancei <= 10^4
//     There are no repeated edges.
//     There is at least one path between 1 and n.

// Approach: Use Disjoint set union. It can be solved using bfs and dfs also i think but implementation will be tricky. [todo]


class Solution {

    class DSU{
        int parent[];
        int size[];
        // int minScore[];

        DSU(int nodeCount){
            parent = new int[nodeCount + 1];
            size =  new int[nodeCount + 1];
            // minScore = int new[newCount + 1];

            for(int i = 1; i < nodeCount + 1; i ++){
                parent[i] = i;
                size[i] = 1;
                // minScore[i] = Integer.MAX_VALUE;
            }
        }

        void union(int n1, int n2, int score){
            int r1 = find(n1);
            int r2 = find(n2);

            if(r1 != r2){
                if(size[r1] > size[r2]){
                    parent[r2] = r1;
                    size[r1] += size[r2];
                }
                else if(size[r1] < size[r2]){
                    parent[r1] = r2;
                    size[r2] += size[r1];
                }
                else{
                    parent[r1] = r2;
                    size[r1] += size[r2];
                }
            }
        }

        int find(int node){
            if(parent[node] == node)return node;

            return parent[node] = find(parent[node]);
        }
    }

    public int minScore(int n, int[][] roads) {
        int len = roads.length;

        DSU d = new DSU(n);

        for(int i = 0; i < len; i ++){
            int u = roads[i][0];
            int v = roads[i][1];
            int score = roads[i][2];

            d.union(u, v, score);
        }

        int rootOf1 = d.find(1);
        int minScore = Integer.MAX_VALUE;

        for(int i = 0; i < len; i ++){
            int u = roads[i][0];
            int v = roads[i][1];
            int score = roads[i][2];

            if(d.find(u) == rootOf1 || d.find(v) == rootOf1){
                minScore = Math.min(minScore, score);
            }
        }

        return minScore;
    }
}
