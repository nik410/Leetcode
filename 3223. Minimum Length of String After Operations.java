class Solution {
    public int minimumLength(String s) {
        // HashMap<Character, Integer> hm = new HashMap();
        // for(char c: s.toCharArray()){
        //     hm.put(c, hm.getOrDefault(c, 0) + 1);
        // }

        // int res = s.length();

        // for(char c: hm.keySet()){
        //     if(hm.get(c) >= 3){
        //         if(hm.get(c) % 2 == 1){
        //             res -= hm.get(c) - 1;
                    
        //         }
        //         else{
        //             res -= hm.get(c) - 2;
        //         }
        //     }
        // }
        
        // return res;


        int len = s.length();
        int freq[] = new int[26];
        int deleted = 0;

        for(int i = 0; i < len; i ++){
            char c = s.charAt(i);

            freq[c - 'a'] ++;

            if(freq[c - 'a'] == 3){
                freq[c - 'a'] -= 2;
                deleted += 2; 
            }
        }

        return len - deleted;
    }
}
