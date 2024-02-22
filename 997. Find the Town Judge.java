class Solution {

    static class Pair{
        int trustOnUs ;
        int trustByUs ;
        public Pair(int tx, int ty){
            trustOnUs = tx;
            trustByUs = ty;
        }
    }

    public int findJudge(int n, int[][] trust) {
       Pair arr[] = new Pair[n + 1];
        
        for (int i = 1; i <= n; i++) {
        arr[i] = new Pair(0, 0); 
    }

       for(int i = 0; i < trust.length; i++){
           arr[trust[i][1]].trustOnUs += 1;
           arr[trust[i][0]].trustByUs += 1;
       }

       for(int i = 1; i <= n; i++){
           if(arr[i].trustOnUs == n - 1 && arr[i].trustByUs == 0){
               return i;
           }
       }

       return -1;
    }
}
