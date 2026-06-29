// Task: Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.

// Approach: Use inbuilt contains function as constrainst is small or better approach to use KMP algo

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        
        int ans = 0;

        for(int i = 0; i < patterns.length; i ++){
            String s = patterns[i];
            
            if(word.contains(s)){
                ans ++;
            }
        }

        return ans;
    }
}
