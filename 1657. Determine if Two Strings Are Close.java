class Solution {
    public boolean closeStrings(String word1, String word2) {
        int charFreq1[] = new int[26];
        int charFreq2[] = new int[26];
        HashSet<Character> hs = new HashSet();
         for(int i = 0; i < word1.length() ; i++){
             hs.add(word1.charAt(i));
         }

        for(int i = 0; i < word2.length() ; i++){
            if(!hs.contains(word2.charAt(i)))return false;
        }

        for(int i = 0; i < word1.length() ; i++)charFreq1[(int)word1.charAt(i) - 'a']++;
        for(int i = 0; i < word2.length() ; i++)charFreq2[(int)word2.charAt(i) - 'a']++;

        Arrays.sort(charFreq1);
        Arrays.sort(charFreq2);
        for(int i = 0; i < 26 ; i++){
            if(charFreq1[i] != charFreq2[i] )return false;
        }

        return true;

    }
}
