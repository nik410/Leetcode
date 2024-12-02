class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        int curr = 1;

        int lenSW = searchWord.length();
        for(int i = 0; i < sentence.length(); i ++){
            
            int j = i;
            int k = 0;

            while(j < sentence.length() &&  k < lenSW &&sentence.charAt(j) == searchWord.charAt(k)){
                j ++;
                k ++;
            }
            
            if(k == lenSW)return curr;

            while(j < sentence.length() && sentence.charAt(j) != ' '){
                j ++;
            }

            i = j;

            curr ++;
        }

        return -1;
    }
}
