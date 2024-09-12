class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        HashSet<Character> hs = new HashSet();
        for(int i = 0; i < allowed.length(); i ++){
            hs.add(allowed.charAt(i));
        }

        for(int i = 0; i < words.length; i ++){
            int j;
            for(j = 0; j < words[i].length(); j ++){
                if(!hs.contains(words[i].charAt(j)))break;
            }
            if(j == words[i].length())ans ++;
        }


        return ans;
    }
}
