class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i: arr){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
             }
        HashMap<Integer, Integer> hm1 = new HashMap();

        for(int i : hm.keySet()){
            hm1.put(hm.get(i), hm1.getOrDefault(hm.get(i), 0) + 1);
            if(hm1.get(hm.get(i)) >= 2)return false;
        }

        return true;

    }
}
