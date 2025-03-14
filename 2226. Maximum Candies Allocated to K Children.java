class Solution {

    public boolean maxPossible(int candies[], long k, int mid){
        long groupsWithMid = 0;

        for(int i: candies){
            groupsWithMid += (i / mid);
        }

        if(groupsWithMid  >= k)return true;
        else return false;
    }


    public int maximumCandies(int[] candies, long k) {
        int len = candies.length;
        int minPile = Integer.MAX_VALUE;
        int maxPile = Integer.MIN_VALUE;
        long sum = 0;
        for(int i = 0; i < len; i ++){
            int candy = candies[i];
            sum += candy;
            minPile = Math.min(minPile, candy);
            maxPile = Math.max(maxPile, candy); 
        }

        if(sum < k)return 0;

        int l = 1, r = maxPile + 1;
        int ans = 0;
        while(l <=r ){
            int mid = l + (r - l) / 2;
            if(maxPossible(candies, k, mid)){
                ans = mid;
                l = mid + 1;
            }
            else if(!maxPossible(candies, k, mid)){
                r = mid - 1;
            }
        } 

        return ans;
    }
}
