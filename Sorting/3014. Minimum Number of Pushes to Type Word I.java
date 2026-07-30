// Task: You are given a string word containing distinct lowercase English letters.
//       Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .
//       It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.
//       Return the minimum number of pushes needed to type word after remapping the keys.
//       An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map to any letters.

// Constraint: 1 <= word.length <= 26
//             word consists of lowercase English letters.
//             All letters in word are distinct.

// Approach: Use sorting to get the most frequent count of any char and then distribute each char to cost based position in ascending order.

// Time and Space Complexity: 
//     TC: O(n) + O(1) for sorting as only 26 char in english alphabets
//     SC: 0(26) ~= O(1)

class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        int count[] = new int[26];

        for(int i = 0; i < len; i ++){
            char c = word.charAt(i);

            count[c - 'a'] ++;
        }

        Arrays.sort(count);

        int firstPlaceCount = 8;
        int secPlaceCount = 8;
        int thirdPlaceCount = 8;
        int quadPlaceCount = 2;

        int cost = 0;

        for(int i = 25; i >= 0; i --){

            if(firstPlaceCount > 0){
                cost += count[i];
                firstPlaceCount --;
            }
            else if(secPlaceCount > 0){
                cost += 2 * count[i];
                secPlaceCount --;
            }
            else if(thirdPlaceCount > 0){
                cost += 3 * count[i];
                thirdPlaceCount --;
            }
            else{
                cost += 4 * count[i];
                quadPlaceCount --;
            }

        }

        return cost;
    }
}
  
