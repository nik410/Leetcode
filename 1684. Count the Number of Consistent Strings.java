class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // int ans = 0;
        // HashSet<Character> hs = new HashSet();
        // for(int i = 0; i < allowed.length(); i ++){
        //     hs.add(allowed.charAt(i));
        // }

        // for(int i = 0; i < words.length; i ++){
        //     int j;
        //     for(j = 0; j < words[i].length(); j ++){
        //         if(!hs.contains(words[i].charAt(j)))break;
        //     }
        //     if(j == words[i].length())ans ++;
        // }

        // return ans;

        // Using Bit Manipulation in 0(1) space better than the hashing
        
        int ans = 0;
        int numInfo = 0;
        for(int i = 0; i < allowed.length(); i ++){
            int val = (int)(allowed.charAt(i) - 'a');
            int mask = 1 << val;

            numInfo = (numInfo | mask);
        }

        for(int i = 0; i < words.length; i ++){
            int j = 0;
            for(j = 0; j < words[i].length(); j ++){
                int charCVal = (int)(words[i].charAt(j) -'a');

                if(((1 << charCVal) & numInfo) != (1 << charCVal))break;

            }
            if(j == words[i].length())ans ++;
        }

        return ans;
    }
}
