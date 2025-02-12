class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, TreeSet<Integer>> hm = new HashMap();
        int maxValue = 0;
        for(int i = 0; i < nums.length; i ++){
            int sumOfDigits = 0;
            int num = nums[i];
            while(num > 0){
                sumOfDigits += num % 10;
                num /= 10;
            }

            if(!hm.containsKey(sumOfDigits)){
                TreeSet<Integer> ts = new TreeSet();
                ts.add(nums[i]);
                hm.put(sumOfDigits, ts);
            }
            else{
                TreeSet<Integer> ts = hm.get(sumOfDigits);

                maxValue = Math.max(maxValue, ts.last() + nums[i]);

                ts.add(nums[i]);
                hm.put(sumOfDigits, ts);
            }
           
        }
        
        if(maxValue == 0)return -1;
        else return maxValue;
    }
}
