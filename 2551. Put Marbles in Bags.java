class Solution {
    public long putMarbles(int[] weights, int k) {
        int len = weights.length;
        long adjSum[] = new long[len - 1];

        for(int i = 0; i < len - 1; i ++){
            adjSum[i] = (long)weights[i] + weights[i + 1];
        }

        Arrays.sort(adjSum);

        long ans = 0;

        long maxScore = 0;
        long minScore = 0;

        for(int i = 0; i < k - 1 ; i ++){
            maxScore += adjSum[len - 2 - i];
            minScore += adjSum[i];
        }

        ans = maxScore - minScore;

        return ans;

    }
}
