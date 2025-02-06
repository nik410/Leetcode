class Solution {

    public int nCr(int n, int r){
        
        if(n < r)return 0;

        int ans = 1;

        for(int i = n; i > n - r; i --){
            ans *= i;
        }

        for(int i = 1; i <= r; i ++){
            ans /= i;
        }

        //  System.out.println("Ans: " +  ans + " Freq: " + n);

        return ans;
    }

   

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        int lenOfArray = nums.length;

        for(int i = 0; i < lenOfArray; i ++){
            for(int j = i + 1; j < lenOfArray; j ++){
                int product = nums[i] * nums[j];
                hm.put(product, hm.getOrDefault(product, 0) + 1);
            }
        }

        // System.out.println(hm);

        int ans = 0;

        for(int i: hm.keySet()){
            int freq = hm.get(i);
            if(freq > 1){
                ans += 8 * (int)nCr(freq, 2);
            }
            
        }

        return ans;
    }
}
