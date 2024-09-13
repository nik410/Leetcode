class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // Xor 
        // 1, 1^3, 1^3^4, 1^3^4^8
        // Whenever a question with ranges is given it hints a little towards prefic sum concept

        // One can store the prefix xor in the same arr array if the arr data is not needed in future
        
        int len = arr.length;
        int prefixXor[] = new int[len];
        prefixXor[0] = arr[0];
        for(int i = 1; i < len; i ++){
            prefixXor[i] = (prefixXor[i - 1] ^ arr[i]);
        }
        int ans[] = new int[queries.length];
        for(int i = 0; i < queries.length; i ++){
            int l = queries[i][0];
            int r = queries[i][1];

            if(l == 0){
                ans[i] = prefixXor[r];
            }
            else{
                ans[i] = (prefixXor[r] ^ prefixXor[l - 1]);
            }
        }

        return ans;

    }
}
