// Task: Alice and Bob take turns playing a game, with Alice starting first.
//       You are given a string num of even length consisting of digits and '?' characters. On each turn, a player will do the following if there is still at least one '?' in num:
//           Choose an index i where num[i] == '?'.
//           Replace num[i] with any digit between '0' and '9'.
//       The game ends when there are no more '?' characters in num.
//       For Bob to win, the sum of the digits in the first half of num must be equal to the sum of the digits in the second half. For Alice to win, the sums must not be equal.
//           For example, if the game ended with num = "243801", then Bob wins because 2+4+3 = 8+0+1. If the game ended with num = "243803", then Alice wins because 2+4+3 != 8+0+3.
//       Assuming Alice and Bob play optimally, return true if Alice will win and false if Bob will win.

// Constraint: 2 <= num.length <= 10e5
//             num.length is even.
//             num consists of only digits and '?'.

// Appraoach: Loop through the string to collect important info 
//            then check if alice can create a scenario when the difference for the bob to cover is not possible. 
//            this can be a extra move that alice has or the diff of first and sec half not being 0.

// Time and Space Complexity:
//   TC: O(n)
//   SC: O(1)

class Solution {
    public boolean sumGame(String num) {
        int len = num.length();

        int firstSum = 0;
        int firstMissing = 0;

        int secSum = 0;
        int secMissing = 0;

        for(int i = 0; i < len; i ++){
            char c = num.charAt(i);

            if(i < len / 2){
                if(c == '?'){
                    firstMissing ++;
                }
                else{
                    firstSum += (int)(c - '0');
                }
            }
            else{
                 if(c == '?'){
                    secMissing ++;
                }
                else{
                    secSum += (int)(c - '0');
                }
            }
        }

        // In alice turn shw will try to place 9 to increase the sum diff

        int newFirstSum = firstSum + 9 *(firstMissing / 2);
        int newSecSum = secSum + 9 * (secMissing / 2);

        if(newFirstSum == newSecSum && (firstMissing + secMissing) % 2 == 1)return true;

        if(newFirstSum == newSecSum)return false;
      
        return true;
    }
}
