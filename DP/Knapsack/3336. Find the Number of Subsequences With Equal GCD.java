// Task: You are given an integer array nums.
// Your task is to find the number of pairs of non-empty
// (seq1, seq2) of nums that satisfy the following conditions:
//     The subsequences seq1 and seq2 are disjoint, meaning no index of nums is common between them.
//     The GCD of the elements of seq1 is equal to the GCD of the elements of seq2.
// Return the total number of such pairs.
// Since the answer may be very large, return it modulo 109 + 7.

// Constraint: 
    // 1 <= nums.length <= 200
    // 1 <= nums[i] <= 200

// Approach: Use DP with take not Take scenarios. 

class Solution {

    public int MOD = (int)(1e9 + 7);

    int count(int nums[], int index, int s1, int s2, int dp[][][]){
        if(index == nums.length){
            if(s1 > 0 && s1 == s2){
                return 1;
            }

            return 0;
        }

        if(dp[index][s1][s2] != 0)return dp[index][s1][s2];

        int skip = (count(nums, index + 1, s1, s2, dp) % MOD);

        int takeS1 = count(nums, index + 1, gcd(s1, nums[index]), s2, dp)  % MOD;

        int takeS2 = count(nums, index + 1, s1, gcd(s2, nums[index]), dp)  % MOD;

        return dp[index][s1][s2] = (int)(((skip + (long)takeS1) % MOD + takeS2) % MOD);
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int subsequencePairCount(int[] nums) {
        int dp[][][] = new int[nums.length + 1][201][201];
        return count(nums, 0, 0, 0, dp);
    }
}
