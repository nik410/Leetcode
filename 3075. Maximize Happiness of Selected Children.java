class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int c = 0;
        long ans = 0;
        Arrays.sort(happiness);

        for(int i= happiness.length - 1; i >= 0 && k > 0; i --){
            if(happiness[i] - c >= 0)
            ans += happiness[i] - c;
            c++;
            k--;
        }

        return ans;
    }
}
