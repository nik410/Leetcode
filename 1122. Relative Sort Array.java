class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hm = new HashMap();

        for(int i: arr1)hm.put(i, hm.getOrDefault(i, 0) + 1);

        int l = 0, in = 0;

        int ans[] = new int[arr1.length];

        while(l < arr2.length){
            if(hm.containsKey(arr2[l])){
                for(int i = 0 ; i < hm.get(arr2[l]); i ++){
                    ans[in ++] = arr2[l];
                }
            }
            l++;
        }

        Arrays.sort(arr1);
        HashSet<Integer> hs = new HashSet();

        for(int i: arr2)hs.add(i);

        for(int i : arr1){
            if(!hs.contains(i)){
                 ans[in ++] = i;
                }
        }
        

        return ans;

    }
}
