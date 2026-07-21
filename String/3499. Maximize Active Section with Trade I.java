// Task:You are given a binary string s of length n, where:
//         '1' represents an active section.
//         '0' represents an inactive section.
//     You can perform at most one trade to maximize the number of active sections in s. In a trade, you:
//         Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
//         Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.
//     Return the maximum number of active sections in s after making the optimal trade.

// Constraint:
//     1 <= n == s.length <= 105
//     s[i] is either '0' or '1'

// Approach: Was trying different prefix suffix approach but very messy and complex. Simple way is to see that the max consecutive 0's pair summ will be the answer.

// Time and Space Complexity: 
//     TC: O(n)
//     SC: O(section of zero) ~ max being n/2 elements = O(n/2)

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {        
        int len = s.length();
        int oneCount = 0;

        ArrayList<Integer> zeroConsecutive = new ArrayList();
        int zeroCount = 0;
        for(int i = 0; i < len; i ++){
            char c = s.charAt(i);

            if(c == '1'){
                oneCount ++;
                if(zeroCount != 0){
                    zeroConsecutive.add(zeroCount);
                }
                zeroCount = 0;
            }
            else{
                zeroCount ++;
            }
        }
        
        if(zeroCount != 0){
            zeroConsecutive.add(zeroCount);
        }
    
        int ans = 0;

        for(int i = 0; i < zeroConsecutive.size() - 1; i ++){
            ans = Math.max(ans, zeroConsecutive.get(i) + zeroConsecutive.get(i + 1)) ;
        }

        return ans + oneCount;
    }
}                                                        
