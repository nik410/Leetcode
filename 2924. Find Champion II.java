class Solution {
    public int findChampion(int n, int[][] edges) {
        int weakArr[] = new int[n];

        for(int i[]: edges){
            int u = i[0];
            int v = i[1];

            weakArr[v] ++;
        }
        
        int totalStrong = 0;
        int candAns = -1;

        
        for(int i = 0; i < n; i ++){
            if(weakArr[i] == 0){
                totalStrong ++;
                if(totalStrong == 1){
                    candAns = i;
                }
            }
        }

        if(totalStrong > 1)return -1;
        else{
            return candAns;
        }
    }
}
