class Solution {
    class NumFreq{
        int number;
        int freq;
        public NumFreq(int number, int freq){
            this.number = number;
            this.freq = freq;
        }
    }

    class MyComparator implements Comparator<NumFreq>{
        public int compare(NumFreq n1, NumFreq n2){
            if(n1.freq == n2.freq){
                return n2.number - n1.number;
            }

            return n1.freq - n2.freq;
        }
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i: nums){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        List<NumFreq> al = new ArrayList();

        for(int i: hm.keySet()){
            al.add(new NumFreq(i, hm.get(i)));
        }

        Collections.sort(al, new MyComparator());

        int ans[] = new int[nums.length];
        int index = 0;
        for(NumFreq n: al){
            for(int i = 0; i < n.freq; i ++){
                ans[index] = n.number;
                index ++;
            }
        }

        return ans;



    }
}
