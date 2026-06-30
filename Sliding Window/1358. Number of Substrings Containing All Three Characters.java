// Task: Given a string s consisting only of characters a, b and c. Return the number of substrings containing at least one occurrence of all these characters a, b and c.

// Approach: Simulate all the substring using two loops and count. Use of sliding window with clever counting technique. 
//           Similar question in codeforces edu section

class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int ans = 0;

        int freq[] = {0, 0, 0};

        int l = 0, r = 0;

        while(r < len){
            char c = s.charAt(r);
            int indexChar = c - 'a';
            freq[indexChar] ++;

            while(l < len && freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 1){
                ans += len - r;
                int index = s.charAt(l) - 'a';

                freq[index] --;
                l ++;
            }

            r ++;
        }

        return ans;
    }
}
