class Solution {

    public long nCr(int n, int r){
        long res = 1;
        for (int i = 1; i <= r; ++i){
            res = res * (n - r + i) / i;
        }            
        return res;
    }

    public long countPair(HashMap<Integer, Integer> hm){
        long ans = 0;

        for(int i: hm.keySet()){
            if(hm.get(i) >= 2){
                int freq = hm.get(i);
                ans += nCr(freq, 2);
            }
        }

        return ans;
    }

    public long countGood(int[] nums, int k) {
        int len = nums.length;
        int l = 0, r = 0;

        HashMap<Integer, Integer> hm = new HashMap();

        long ans = 0;
        long countOfPairs = 0;
        while(r < len){
            countOfPairs += hm.getOrDefault(nums[r], 0);
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);           

            // System.out.println("Count: " + countOfPairs + " l :" + l + " r: " + r);

            while(l < r && countOfPairs >= k){
                ans  += len - r;
                int valL = nums[l];

                if(hm.get(valL) == 0){
                    hm.remove(valL);
                }
                else{
                    hm.put(valL, hm.get(valL) - 1);
                }
                countOfPairs -= hm.getOrDefault(valL, 0);
                // System.out.println("Count: " + countOfPairs + " l :" + l + " r: " + r +" In");
                l ++;
            }
            
            r++;            
        }

        return ans;
    }
}

