class Solution {

    static class Pair{
        Character cha;
        int freq;

        public Pair(Character cha, int freq){
            this.cha = cha;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {

        //Using treemap to maintain order and implementing a custom comparator to sort according to ascending order of occurances in the word
      
        TreeMap<Character, Integer> tm = new TreeMap();
        for(char c: s.toCharArray()){
            tm.put(c, tm.getOrDefault(c, 0) + 1);
        }
        System.out.println(tm);
        Pair arr[] = new Pair[tm.size()];
        int index = 0;
        for(char ch: tm.keySet()){
            
            arr[index] = new Pair(ch, tm.get(ch));
            index++;
        }

        Arrays.sort(arr, (p1, p2) -> Integer.compare(p2.freq, p1.freq));

        String ans = "";

        for(int i = 0; i < arr.length; i++){
            char charac = arr[i].cha;
            for(int j = 0; j < arr[i].freq; j++){
                ans += charac + "";
            }
        }
        
        return ans;


    }
}
