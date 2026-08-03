// Task: Alice and Bob continue their games with piles of stones. There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array stoneValue.
//       Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take 1, 2, or 3 stones from the first remaining stones in the row.
//       The score of each player is the sum of the values of the stones taken. The score of each player is 0 initially.
//       The objective of the game is to end with the highest score, and the winner is the player with the highest score and there could be a tie. The game continues until all the stones have been taken.
//       Assume Alice and Bob play optimally.
//       Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end the game with the same score.

// Constraint: 1 <= stoneValue.length <= 5 * 104
//             -1000 <= stoneValue[i] <= 1000

// Approach: Use pick not pick dp and the mini max approach for turn based games.

// Time and Space Complexity: 
//   TC: O(n)
//   SC: O(n*2)

class Solution {
    
    int scoreAlice(int stoneValue[], int i, int chanceA, int dp[][]){
        if(i >= stoneValue.length){
            return 0;
        }

        if(dp[i][chanceA] != Integer.MIN_VALUE)return dp[i][chanceA];

        int score = 0;

        if(chanceA == 1){
            
            int take2 = (int)(-1e9);
            int take3 = (int)(-1e9);
            int take1 = stoneValue[i] + scoreAlice(stoneValue, i + 1, 0, dp);
            if(i + 1 < stoneValue.length){
                take2 = stoneValue[i] + stoneValue[i + 1] + scoreAlice(stoneValue, i + 2, 0, dp);
            }
            if(i + 2 < stoneValue.length){
                take3 = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] + scoreAlice(stoneValue, i + 3, 0, dp);
            }
            score = Math.max(take1, Math.max(take2, take3));
        }
        else{
            int take2 = (int)(1e9);
            int take3 = (int)(1e9);
            int take1 = scoreAlice(stoneValue, i + 1, 1, dp);
            if(i + 1 < stoneValue.length){
                take2 = scoreAlice(stoneValue, i + 2, 1, dp);
            }
            if(i + 2 < stoneValue.length){
                take3 = scoreAlice(stoneValue, i + 3, 1, dp);
            }
            score = Math.min(take1, Math.min(take2, take3));
        }

        return dp[i][chanceA] = score;
    }
    
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;

        int sumStone = 0;

        for(int i: stoneValue){
            sumStone += i;
        }
        
        int dp[][] = new int[len][2];

        for(int i = 0; i < dp.length; i ++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        int aliceScore = scoreAlice(stoneValue, 0, 1, dp);
        int bobScore = sumStone - aliceScore;

        // System.out.println("Alice: " + aliceScore + " Bob: " + bobScore);

        if(aliceScore == bobScore)return "Tie";
        return (aliceScore > bobScore) ? "Alice" : "Bob";
    }
}
