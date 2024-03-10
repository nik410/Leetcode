lass Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet();
        ArrayList<Integer> al = new ArrayList();
        for(int i: nums1){
            hs.add(i);
        }

        for(int i: nums2){
            if(hs.contains(i)){
                al.add(i);
                hs.remove(i);
            }
        }

        int ans[] = new int[al.size()];
        for(int i = 0; i < al.size(); i++){
            ans[i] = al.get(i);
        }

        return ans;
    }
}
