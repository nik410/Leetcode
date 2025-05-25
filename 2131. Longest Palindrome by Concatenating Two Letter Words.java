class Solution {
    public int longestPalindrome(String[] words) {
        int len = words.length;
        HashMap<String, Integer> hm = new HashMap();

        int ans = 0;

        // Took way to much time first give time for logic than trying first thought process 

        for(int i = 0; i < len; i ++){
            StringBuilder stb = new StringBuilder();
            stb.append(words[i]);

            String reverse = stb.reverse().toString();

            if(hm.containsKey(reverse)){
                ans += 4;
                if(hm.get(reverse) > 1){
                     hm.put(reverse, hm.get(reverse) - 1);
                     continue;
                }
                else{
                    hm.remove(reverse);
                    continue;
                }               
            }
            hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);
            
        }

        for(String s: hm.keySet()){
            if(s.charAt(0) == s.charAt(1)){
                ans +=2;
                break;
            }
        }

        return ans;
    }
}
