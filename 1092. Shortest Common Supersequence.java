class Solution {

    public int lcs(String s1, String s2, int i, int j, int dp[][]){
        if(i >= s1.length() || j >= s2.length())return 0;

        if(dp[i][j] != 0)return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + lcs(s1, s2, i + 1, j + 1, dp);
        }
        else{
            return dp[i][j] = 0 +  Math.max(lcs(s1, s2, i + 1, j, dp), lcs(s1, s2, i, j + 1, dp));
        }
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int dp[][] = new int[len1 + 1][len2 + 1];
        int longestComm = lcs(str1, str2, 0, 0, dp);
        
        // for(int i = 0; i < len1; i ++){
        //     for(int j = 0; j < len2; j ++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println("");
        // }

        String ans = "";
        int i = 0, j = 0;

        while(i < len1 && j < len2){
            if(str1.charAt(i) == str2.charAt(j)){
                ans += str1.charAt(i) + "";
                i ++;
                j ++;
            }
            else if(dp[i + 1][j] > dp[i][j + 1]){
                ans += str1.charAt(i) + "";
                i ++;
            }
            else{
                ans += str2.charAt(j) + "";
                j ++;
            }
        }

        while(i < len1){
            ans += str1.charAt(i) + "";
            i ++;
        }

        while(j < len2){
            ans += str2.charAt(j) + "";
            j ++;
        }


        return ans;

    }
}
