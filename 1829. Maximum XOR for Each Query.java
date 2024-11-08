class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int len = nums.length;
        int ans[] = new int[len];
        int index = 0;

        int xorVal = 0;

        for(int i = 0; i < len; i ++){

            xorVal = (xorVal ^ nums[i]);

            ArrayList<Integer> unsetBits = new ArrayList();
            int num = xorVal;
            int bitPlace = 0;

            int maxBit = maximumBit;

            while(maxBit -- > 0){

                if(num % 2 == 0){
                    unsetBits.add(bitPlace);
                }

                bitPlace ++;
                num /= 2;
            }

            // System.out.println(unsetBits);
            int kVal = 0;
            for(int j: unsetBits){
                kVal += (int)Math.pow(2, j);
            }

            ans[len - i - 1] = kVal;

        }

        return ans;
    }
}
