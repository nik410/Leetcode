// Task: You are given an integer n representing the number of nodes in a graph, labeled from 0 to n - 1.
// You are also given an integer array nums of length n sorted in non-decreasing order, and an integer maxDiff.
// An undirected edge exists between nodes i and j if the absolute difference between nums[i] and nums[j] is at most maxDiff (i.e., |nums[i] - nums[j]| <= maxDiff).
// You are also given a 2D integer array queries. For each queries[i] = [ui, vi], determine whether there exists a path between nodes ui and vi.
// Return a boolean array answer, where answer[i] is true if there exists a path between ui and vi in the ith query and false otherwise.

// Constraint:
//     1 <= n == nums.length <= 105
//     0 <= nums[i] <= 105
//     nums is sorted in non-decreasing order.
//     0 <= maxDiff <= 105
//     1 <= queries.length <= 105
//     queries[i] == [ui, vi]
//     0 <= ui, vi < n

// Approach: Use of DSU [ Union Find ] to find parent. 
// TC: O((n + q) *(log a(n)) a(n) is inverse ackerman function.
// SC: (O(n ( parent ) + n ( size ) + q( query res) ) = O(n + q)
  
// On second thought using bruteforce we can make a graph and then DFS/BFS but that will be TLE [assuming 1e8 ops/sec]. 
// TC: O(n^2) or [ O(nlogn) if using Binary Search ] just for qgraph as we would have to compare one interger to others but given in sorted order helps a little. 
// SC: O(n^2 + q) for graph storage

  class Solution {

    class DSU{
        int parent[];
        int size[];

        DSU(int nodeCount){
            parent = new int[nodeCount];
            size = new int[nodeCount];

            for(int i = 0; i < nodeCount; i ++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        void union(int n1, int n2){
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
                    size[r2] += size[r1];
                }
            }
        }

        int find(int node){
            if(parent[node] == node)return node;

            return parent[node] = find(parent[node]);
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int len = nums.length;

        DSU d = new DSU(n);

        for(int i = 0; i < len - 1; i ++){
            int n1 = nums[i];
            int n2 = nums[i + 1];

            if(n2 - n1 <= maxDiff){
                d.union(i, i + 1);
            }
        }

        int queryLen = queries.length;

        boolean result[] = new boolean[queryLen];

        for(int i = 0; i < queryLen; i ++){
            int n1 = queries[i][0];
            int n2 = queries[i][1];

            int r1 = d.find(n1);
            int r2 = d.find(n2);

            result[i] = (r1 == r2) ? true : false;
        }

        return result;
    }
}
