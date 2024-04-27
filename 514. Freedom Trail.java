class Solution {


    public int countSteps(int ringIndex, int i, String ring){
        int antiClockwise = Math.abs(i - ringIndex);
        int clockwise = ring.length() - antiClockwise;

        return Math.min(clockwise, antiClockwise);
    }
    
    public int solve(String ring, String key, int ringIndex, int keyIndex,  int dp[][]){
        
        if(keyIndex == key.length())return 0;
        if(dp[ringIndex][keyIndex] != 0) return dp[ringIndex][keyIndex];
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < ring.length(); i++){
            if(ring.charAt(i) == key.charAt(keyIndex)){
                int steps = 1 + countSteps(ringIndex, i, ring) + solve(ring, key, i, keyIndex + 1, dp);
                res = Math.min(res, steps);  
            }

            
        }

        return dp[ringIndex][keyIndex] = res;

    }

    public int findRotateSteps(String ring, String key) {
        int dp[][] = new int[ring.length() + 1][key.length() + 1];
        return solve(ring, key, 0, 0, dp);
    }
}
