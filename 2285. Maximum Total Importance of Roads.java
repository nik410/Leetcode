class Solution {
    class Pair{
        int node;
        int indegree;

        Pair(int node, int indegree){
            this.node = node;
            this.indegree = indegree;
        }

    }

    class MyComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return Integer.compare(p2.indegree, p1.indegree);
        }
    }
    public long maximumImportance(int n, int[][] roads) {
        Pair arr[] = new Pair[n];

        for(int i = 0; i < n; i ++){
            arr[i] = new Pair(i, 0);
        }

        for(int i = 0; i < roads.length; i ++){
            arr[roads[i][0]].indegree ++;
            arr[roads[i][1]].indegree ++;
        }

        Arrays.sort(arr, new MyComparator());

        long counter = n;
        long ans =  0;
        for(int i = 0; i < arr.length; i ++){
            ans += counter * arr[i].indegree;
            counter --;
        }


        return ans;


        


    }
}
