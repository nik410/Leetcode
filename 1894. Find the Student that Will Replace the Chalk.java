class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        long pref[] = new long[len];
        pref[0] = chalk[0];

        for(int i = 1; i < len; i ++){
            pref[i] = pref[i - 1] + chalk[i];
        }

        long rounds = k / pref[len - 1] ;

        long actK = k - rounds * pref[len - 1];

        //  System.out.println(" ActualK: " + actK);
        
        // Using binary search to find the upper bound of actK on the prefix sum array

        int l = 0, r = len - 1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;

            // System.out.println("Hi: mid" + mid + " pref " + pref[mid] + " ActualK: " + actK);

            if(pref[mid] <= actK){
                l = mid + 1;
            }
            else if(pref[mid] > actK){
                ans = mid;
                r = mid - 1;
            }
        }

        return ans;
    }
}
