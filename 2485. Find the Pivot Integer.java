class Solution {
    public int pivotInteger(int n) {
        int preSum = 0;
        int suffSum = 0;

        if(n == 1)return 1;

        int sumArray = (n * (n + 1)) / 2;

        for(int i = 2; i <= n - 1; i++){
            
            int prefixS = (i * (i - 1)) / 2;
            int suffixS = sumArray - (prefixS) - i;

            // System.out.println(i +" pre :" + prefixS +" suff: "+ suffixS);

            if(prefixS == suffixS)return i;

        }

        return -1;
        
    }
}
