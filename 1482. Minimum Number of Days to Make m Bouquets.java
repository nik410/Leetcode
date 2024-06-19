class Solution {


    public int goodFunc(int bloomDay[], int m, int k, int mid){
        int bouquet = 0;
        int currK = 0;

        for(int i = 0; i < bloomDay.length; i ++){
            if(bloomDay[i] <= mid){
                currK ++;

                if(currK == k){
                    bouquet ++;
                    currK = 0;
                }
            }
            else{
                currK = 0;
            }
        }

        if(bouquet >= m)return 0;       
        else return -1;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length)return -1;
        
        int l = 0, r = 0;

        // We cannot sort it as the ordering is important as we have to take consecutive segemnt for bouquet
        // Arrays.sort(bloomDay);

        for(int i: bloomDay)
        r = Math.max(i, r);

        int ans = -1;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(goodFunc(bloomDay, m, k, mid) >= 0){
                r = mid - 1;
                ans = mid;
            }
            else  if(goodFunc(bloomDay, m, k, mid) < 0){
                l = mid + 1;
            }
        }

        return ans;
    }
}
