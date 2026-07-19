// Task : Given a string s, return the lexographically smallest subsequence of s that contains all the distinct characters of s exactly once.

// Constraint : 
//     1 <= s.length <= 1000
//     s consists of lowercase English letters.

// Approach : Use a indexLast to store the last occurance of the char then on that we can use stack or string operation.
//   Main thing being if encountering a smaller char asking the already included char if thery occur in afterward to that the smaller char can take the place. 

// Time and Space Complexity : 
//     TC : O(N)
//     SC : O(N)


class Solution {
    public String smallestSubsequence(String s) {
        int len = s.length();
        int count[] = new int[26];
        int indexLast[] = new int[26];
        int distinct = 0;

        for(int i = 0; i < len; i ++){
            char c = s.charAt(i);

            count[c - 'a'] ++;
            indexLast[c - 'a'] = i;

        }

        StringBuilder stb = new StringBuilder();

        int mask = 0;

        for(int i = 0; i < len; i ++){
            char c = s.charAt(i);

            if(((mask >> (c - 'a')) & 1) != 0){
                continue;
            }

            while(stb.length() > 0){
                char top = stb.charAt(stb.length() - 1);
                if(top > c && indexLast[top - 'a']  > i){
                    mask &= ~(1 << (top - 'a'));
                    stb.deleteCharAt(stb.length() - 1);
                }
                else{
                    break;
                }
            }

            if( ((mask >> (c - 'a')) & 1) == 0 ) {
                stb.append(c);

                mask = mask | (1 << ( c- 'a' ));
            }
        }

        return stb.toString();
    }
}
