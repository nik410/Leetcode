class Solution {

    public boolean checkPalindrome(String word){
        for(int i = 0; i < word.length() / 2; i++){
            if(word.charAt(i) != word.charAt(word.length() - 1 - i))return false;
        }

        return true;
    }
    public String firstPalindrome(String[] words) {
        
        for(String word: words){

            if(checkPalindrome(word)){
                return word;
            }
        }


        return "";
    }
}
