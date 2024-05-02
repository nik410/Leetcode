class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        int largest = -1;
        for(int i: nums){
            hs.add(i);
            if(hs.contains(-1 * i)){
                largest = Math.max(largest, Math.abs(i));
            }
        }

        return largest;
    }
}
