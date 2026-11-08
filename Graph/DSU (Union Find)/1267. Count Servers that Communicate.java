// Task: You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
//       Return the number of servers that communicate with any other server.

// Constraint: m == grid.length
//             n == grid[i].length
//             1 <= m <= 250
//             1 <= n <= 250
//             grid[i][j] == 0 or 1

// Approach: Use greedy. BFS DFS, and DSU like graph algorithms can also be used.

// Time and Space Complexity: 
//   TC: O(n * m)
//   SC: O(n * m)


class Solution {

    // class Pair{
    //     int i;
    //     int j;

    //     Pair(int i, int j){
    //         this.i = i;
    //         this.j = j;
    //     }
    // }

    // public int bfs(int grid[][], int i, int j, int visited[][]){
    //     Queue<Pair> q = new LinkedList();
    //     int direc[][] = {{1, 0},
    //     {0, -1},
    //     {-1, 0},
    //     {0, 1}};

    //     int ans = 0;

    //     q.offer(new Pair(i, j));

    //     visited[i][j] = 1;

    //     while(!q.isEmpty()){
    //         int siz = q.size();

    //         for(int in = 0; in < siz; in ++){
    //             Pair p = q.poll();

    //             for(int d[]: direc){
    //                 int newX = p.i + d[0];
    //                 int newY = p.j + d[1];

    //                 if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length 
    //                     && visited[newX][newY] == 0 && grid[newX][newY] == 1){
    //                     q.offer(new Pair(newX, newY));
    //                     visited[newX][newY] = 1;
    //                     ans ++;
    //                 }
    //             }               
    //         }
    //         }

    //         // System.out.println("i: " + i + " j: " + j + " ans: " + ans);

    //         if(ans == 0)return 0;
    //         return ans + 1;
    //     }
    

    public int countServers(int[][] grid) {

        // Read the problem statement nicely
        
        // int row = grid.length;
        // int col = grid[0].length;

        // int visited[][] = new int[row][col];

        // int ans = 0;

        // for(int i = 0; i < row; i ++){
        //     for(int j = 0; j < col; j ++){
        //         if(grid[i][j] == 1 && visited[i][j] == 0){
        //             ans += bfs(grid, i, j, visited);
        //         }
        //     }
        // }

        // return ans;

        // Greedy Approach 

    //     int row = grid.length;
    //     int col = grid[0].length;

    //     int countRow[] = new int[row];
    //     int countCol[] = new int[col];

    //     for(int i = 0 ; i < row; i ++){
    //         for(int j = 0; j < col; j ++){
    //             if(grid[i][j] == 1){
    //                 countRow[i] ++;
    //                 countCol[j] ++;
    //             }
    //         }
    //     }


    //     int ans = 0;

    //     for(int i = 0 ; i < row; i ++){
    //         for(int j = 0; j < col; j ++){
    //             if(grid[i][j] == 1){
    //                if(countRow[i] > 1 || countCol[j] > 1)ans ++;
    //             }
    //         }
    //     }
        
    //    return ans;

       // Look into Graph DSU approach

       // We can use DSU approach by taking each cordinate as node
       // or we can use the columns and rows as the node sperately

       // If coordinate as node then we have to iterate both row and col
       
       // For the columns and row just need to iterate for the specific column or row

       // Both will be similar by time and space complexity wise

        int row = grid.length;
        int col = grid[0].length;

        DSU d = new DSU(row + col);

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(grid[i][j] == 1){
                    d.union(i, row + j);
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < row; i ++){
            int rootParent = d.find(i);
            // System.out.println("index" + i + " rootParent: " + rootParent + " size[]: " + d.size[rootParent]);
            if(d.size[rootParent] > 2){
                for(int j = 0; j < col; j ++){
                    if(grid[i][j] == 1){
                        ans ++;
                    }
                }
            }
        }

        return ans;
        
    }

    class DSU{
        int parent[];
        int size[];

        DSU(int n){
            parent = new int[n + 1];
            size = new int[n + 1];

            for(int i = 0; i < n + 1; i ++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        void union(int n1, int n2){
            int parent1 = find(n1);
            int parent2 = find(n2);

            if(parent1 != parent2){
                if(size[parent1] >= size[parent2]){
                    parent[parent2] = parent1;
                    size[parent1] += size[parent2];
                }
                else{
                    parent[parent1] = parent2;
                    size[parent2] += size[parent1];
                }
            }
        }

        int find(int node){
            if(parent[node] == node)return node;

            return parent[node] = find(parent[node]);
        }
    }

}
