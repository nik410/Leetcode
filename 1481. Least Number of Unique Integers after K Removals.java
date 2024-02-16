class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

      //Crux of the problem is to identify answer is dependent on the frequency of elements
        
        HashMap<Integer, Integer> hm = new HashMap();
        for(int  i: arr) hm.put(i, hm.getOrDefault(i, 0) + 1);
        List<Map.Entry<Integer, Integer>> al = new ArrayList(hm.entrySet());

        Collections.sort(al, (l1, l2) -> Integer.compare(l1.getValue(), l2.getValue()));
        int ans = hm.size();
       for(Map.Entry<Integer, Integer> ent: al){
           if(ent.getValue() <= k){
               k -= ent.getValue();
               ans--;
           }
           else{break;}
       }
        return ans;

    }
}
