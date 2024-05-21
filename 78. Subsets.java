class Solution {

    public void sub(int nums[], int index, List<List<Integer>> ans, List<Integer> al){
        if(index == nums.length){
            ans.add(new ArrayList(al));
            return;
        }

        al.add(nums[index]);
        sub(nums, index + 1, ans, al);
        al.remove(al.size() - 1);

        sub(nums, index + 1, ans, al);

    }

    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList();
        ArrayList<Integer> al = new ArrayList();
        sub(nums, 0, ans, al);

        return ans;
        
    }
}
