class Solution {

    List<Integer> topoSort(int arr[][], int k){
        List<Integer> ans = new ArrayList();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList();

        for(int i = 0; i < k + 2; i ++){
            adj.add(new ArrayList());
        }

        int indegree[] = new int[k + 1];
        

        for(int i[]: arr){
            adj.get(i[0]).add(i[1]);
            indegree[i[1]] ++;
           
        }

        // System.out.println("Adjacency Matrix: " + adj);
        int count = 0;

        Queue<Integer> q = new LinkedList();

        for(int i = 1; i <= k; i ++){
            if(indegree[i] == 0){
                q.offer(i);
                 count ++;    
            }
        }

        while(!q.isEmpty()){
            int temp = q.poll();

            ans.add(temp);

            for(int i: adj.get(temp)){
                indegree[i] --;
                if(indegree[i] == 0){
                    q.offer(i);
                    count ++;
                }
            }
        }

        if(count != k){
            return new ArrayList();
        }

         return ans;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> topoRow = topoSort(rowConditions, k);
        List<Integer> topoCol = topoSort(colConditions, k);

        if(topoRow.size() == 0 || topoCol.size() == 0)return new int[][]{};

          int[][] matrix = new int[k][k];
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            positionMap.put(topoCol.get(i), i);
        }

        for (int i = 0; i < k; i++) {
            int element = topoRow.get(i);
            if (positionMap.containsKey(element)) {
                matrix[i][positionMap.get(element)] = element;
            }
        }
        return matrix;
    }
}
