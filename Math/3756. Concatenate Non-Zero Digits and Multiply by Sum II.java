// Task: You are given a string s of length m consisting of digits. You are also given a 2D integer array queries, where queries[i] = [li, ri].
// For each queries[i], extract the
// s[li..ri]. Then, perform the following:
//     Form a new integer x by concatenating all the non-zero digits from the substring in their original order. If there are no non-zero digits, x = 0.
//     Let sum be the sum of digits in x. The answer is x * sum.
// Return an array of integers answer where answer[i] is the answer to the ith query.
// Since the answers may be very large, return them modulo 109 + 7.

// Constraint: 
//     1 <= m == s.length <= 105
//     s consists of digits only.
//     1 <= queries.length <= 105
//     queries[i] = [li, ri]
//     0 <= li <= ri < m

// Approach: Use of prefix array for storage of sum and concat across all the segment, matrix exponeniation for fast power calculation.[Look into matrix exp]

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int len = s.length();

        int prefSum[] = new int[len];
        int prefConcat[] = new int[len];
        int prefLen[] = new int[len];

        for(int i = 0; i < len; i ++){
            int val = Character.getNumericValue(s.charAt(i));

            prefSum[i] = (int)((prefSum[Math.max(i - 1, 0)] + val) % (int)(1e9 + 7));

            if(val != 0){
                prefConcat[i] = (int)((prefConcat[Math.max(i - 1, 0)] * 10L + val) % (int)(1e9 + 7));
                prefLen[i] = prefLen[Math.max(i - 1, 0)] + 1;
            }
            else{
                prefConcat[i] = (int)(prefConcat[Math.max(i - 1, 0)]);
                prefLen[i] = prefLen[Math.max(i - 1, 0)];
            }
        }

        // for(int i = 0; i < len; i ++){
        //     System.out.println("Index: " + i + " Sum: " + prefSum[i] + " Concat: " + prefConcat[i] + " Len: " + prefLen[i]);
        // }



        int queryLen = queries.length;
        int ans[] = new int[queryLen];

        int MOD = (int)(1e9 + 7);

        for(int i = 0; i < queryLen; i ++){
            int l = queries[i][0];
            int r = queries[i][1];

            long lenDiff = (prefLen[r] - ((l == 0) ? 0 : prefLen[l - 1]));

            long subs = (((l == 0) ? 0 : prefConcat[l - 1]) * power(10, lenDiff, MOD)) % MOD;

            long prefConcatVal = (prefConcat[r] - subs + MOD) % MOD;

            long digitSum = (prefSum[r] - ((l == 0) ? 0 : prefSum[l - 1]) + MOD) % MOD;

            ans[i] = (int) ((prefConcatVal * digitSum) % MOD);

        }

        return ans;
    }


    private long power(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
  
