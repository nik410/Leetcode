class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;

        int ans[] = new int[len];

        if(k == 0)return ans;

        if(k > 0){
            int sum = 0;
            
            for(int i = 1; i <= k; i ++){
                sum += code[i];
            }
            ans[0] = sum;
            int index = 1;

            while(index < len){
                int sumNew = sum - code[index] + code[(index + k) % len];
                ans[index] = sumNew;
                sum = sumNew;
                index ++;
            }

            return ans;

        }
        
        if(k < 0){
            int sum = 0;
            
            for(int i = len + k; i < len; i ++){
                sum += code[i];
            }
            ans[0] = sum;
            int index = 1;

            while(index < len){
                int sumNew = sum - code[(len + k + index - 1) % len] + code[(index - 1) % len];
                ans[index] = sumNew;
                sum = sumNew;
                index ++;
            }

            return ans;

        }

        return ans;

    }
}
