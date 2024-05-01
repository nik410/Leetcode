class Solution {
    public String reversePrefix(String word, char ch) {
        int index = -1;

        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ch){
                index = i;
                break;
            }
        }

        if(index == -1)return word;
        else{
            String s = word.substring(0, index + 1);
            String ans = "";
            for(int i = 0; i < s.length(); i++){
                ans += s.charAt(s.length() - 1 - i) + "";
            }

            for(int i = index + 1; i < word.length(); i++){
                ans += word.charAt(i) + "";
            }

            return ans;
        }
    }
}
