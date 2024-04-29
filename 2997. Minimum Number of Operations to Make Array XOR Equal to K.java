class Solution {
    public int minOperations(int[] nums, int k) {
        int xorofall = nums[0];

        for(int i = 1; i < nums.length; i++){
            xorofall = (xorofall ^ nums[i]);
        }
        System.out.println(xorofall + "Hi");
        int c  = 0;
        while(xorofall > 0 || k > 0){
            if(xorofall % 2 != k % 2){
                c++;
            }
            xorofall /= 2;
            k /= 2;
            
        }

        return c;

    }
}
