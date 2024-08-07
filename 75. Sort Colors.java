class Solution {
    public void sortColors(int[] nums) {
        int index = 0, low = 0, mid = 0, high = nums.length - 1;

       while(mid <= high){
        if(nums[mid] == 2){
            nums[mid] = nums[high];
            nums[high] = 2;
            high --;
        }
        else if(nums[mid] == 0){
            nums[mid] = nums[low];
            nums[low] = 0;
            low ++;
            mid ++;
        }
        else{
            mid ++;
        }    
       }
    }
}
