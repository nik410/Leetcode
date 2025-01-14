class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        int len = A.length;

        int ans[] = new int[len];
        
        HashMap<Integer, Integer> hm = new HashMap();
        int common = 0;

        for(int i = 0; i < len; i ++){
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
            if(hm.get(A[i]) == 2){
                common ++;
            }

            hm.put(B[i], hm.getOrDefault(B[i], 0) + 1);
            if(hm.get(B[i]) == 2){
                common ++;
            }

            ans[i] = common;
            
        }

        return ans;
    }

}
