class Solution {

    public void genSub(int arr[], int index, ArrayList<Integer> al, ArrayList<ArrayList<Integer>> ans){
        if(index == arr.length){
            if(al.size() > 0){
                ans.add(new ArrayList(al));                
            }
            return;
        }

        al.add(arr[index]);
        genSub(arr, index + 1, al, ans);
        if(al.size() > 0)
        al.remove(al.size() - 1);

        genSub(arr, index + 1, al, ans);

    }

    public int countMaxOrSubsets(int[] nums) {
        // Generating all subsets
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        ArrayList<Integer> al = new ArrayList();
        genSub(nums, 0, al, ans);

        // System.out.println(ans);
        int maxOr = 0;
        int maxCount = 0;
        for(int i = 0; i < ans.size(); i ++){
            int orVal = 0;
            for(int j = 0; j < ans.get(i).size(); j ++){
                orVal = (orVal | ans.get(i).get(j));
            }

            if(orVal > maxOr){
                maxOr = Math.max(maxOr, orVal);
                maxCount = 1;
            }
            else if(orVal == maxOr){
                maxCount ++;
            }
        }

        return maxCount;

    }
}
