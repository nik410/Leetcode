class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap();

        for(int i = 0; i < arr.length; i ++){
            int mod = ((arr[i] % k) + k) % k;

            if(hm.containsKey(k - mod)){
                if(hm.get(k - mod) == 1){
                    hm.remove(k - mod);
                }
                else{
                    hm.put(k - mod, hm.get(k - mod) - 1);
                }
            }
            else{
                hm.put(mod, hm.getOrDefault(mod, 0) + 1);
            }

            // System.out.println("Index: " + i + " HashMap: " + hm);
        }

        if(hm.size() == 0){
            return true;
        }
        else if(hm.size() == 1){
            int ele = -1;
            for(int i: hm.keySet()){
                ele = i;
            }

            if(ele == 0 && hm.get(ele) % 2 == 0){
                return true;
            }
            else return false;
        }
        else return false;
    }
}
