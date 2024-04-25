class Solution {
    public int longestIdealString(String s, int k) {
        // int dp[] = new int[s.length()];
        // Arrays.fill(dp, 1);
        // int res = 1;
        // for(int i = 0; i < s.length(); i ++){
        //     for(int j = i - 1; j >= 0; j --){
        //         if(Math.abs((int)(s.charAt(i)) - (int)(s.charAt(j))) <= k){
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //         res = Math.max(dp[i], res);
        //     }
        // }

        // return res;


        int arr[] = new int[26];

        int res = 0;

        for(int i = 0; i < s.length(); i++){

            int charN = (int)(s.charAt(i) - 'a');
            int left = Math.max(0, charN - k);
            int right = Math.min(25, charN + k);
            int longest = 0;
            for(int j = left; j <= right; j++){
                longest = Math.max(longest, arr[j]);
            }
            arr[charN] = Math.max(arr[charN], longest + 1);
            res = Math.max(arr[charN], res);
        }

        return res;
    }
}
