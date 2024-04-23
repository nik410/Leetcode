class Solution
{
    public void bst(int nums[], int start, int end, int ans[], int index[]){
        if(start > end)return;
        
        int mid = start + (end - start) / 2;
        if(index[0] < nums.length)
        ans[index[0]] = nums[mid];
        index[0] ++;
        bst(nums, start, mid - 1, ans, index);
        bst(nums, mid + 1, end, ans, index);
        
    }
    
    public int[] sortedArrayToBST(int[] nums)
    {
        int ans[] = new int[nums.length];
        int index[] = new int[1];
        bst(nums, 0, nums.length - 1, ans, index);
        
        return ans;
        
    }
}
