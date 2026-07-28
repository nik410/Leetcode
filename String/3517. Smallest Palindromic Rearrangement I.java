// Task:You are given a string s.

// Return the lexographically smallest palindromic permutation of s.

// Constraint:
//   1 <= s.length <= 105
//   s consists of lowercase English letters.
//   s is guaranteed to be palindromic.

// Approach: Use a count array to see the occurance of the 26 char and then iterate over them and set them in position based on their freq count and parity

// Time and Space Complexity:
//   TC: O(n)
//   SC: O(n)

class Solution {
    public String smallestPalindrome(String s) {
        int len = s.length();
        int count[] = new int[26];

        for(int i = 0; i < len; i ++){
            char c = s.charAt(i);
            count[c - 'a'] ++;
        }

        char strArr[] = new char[len];
        int stInd = 0;
        int endInd = len - 1;

        char charOddFreq = '-';

        for(int i = 0; i < 26; i ++){
            if(count[i] > 0){
                if(count[i] % 2 == 0){
                    
                    int freq = count[i] / 2;

                    for(int j = 0; j < freq; j ++){
                        strArr[stInd] = (char)(i + 'a');
                        strArr[endInd] = (char)(i + 'a');

                        stInd ++;
                        endInd --;
                    }
                    
                }
                else{

                    int freq = count[i] / 2;

                    if(count[i] == 1){
                        charOddFreq = (char)(i + 'a');
                        continue;
                    }

                    if(freq > 0){
                        for(int j = 0; j < freq; j ++){
                            strArr[stInd] = (char)(i + 'a');
                            strArr[endInd] = (char)(i + 'a');

                            stInd ++;
                            endInd --;
                        }

                        strArr[(len)/2] = (char)(i + 'a');
                    }
                }
            }
        }

        // Handle odd freq
        if(charOddFreq >= 'a' && charOddFreq <= 'z' && count[charOddFreq - 'a'] == 1){
            strArr[stInd] = charOddFreq;
            stInd ++;
        }

        StringBuilder stb = new StringBuilder();

        for(char c: strArr){
            stb.append(c);
        }

        return stb.toString();
    }
}
    
