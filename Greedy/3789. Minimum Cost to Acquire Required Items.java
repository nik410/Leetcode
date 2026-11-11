// Task: You are given five integers cost1, cost2, costBoth, need1, and need2.
//     There are three types of items available:
//         An item of type 1 costs cost1 and contributes 1 unit to the type 1 requirement only.
//         An item of type 2 costs cost2 and contributes 1 unit to the type 2 requirement only.
//         An item of type 3 costs costBoth and contributes 1 unit to both type 1 and type 2 requirements.
//     You must collect enough items so that the total contribution toward type 1 is at least need1 and the total contribution toward type 2 is at least need2.
//     Return an integer representing the minimum possible total cost to achieve these requirements.

// Constraint: 1 <= cost1, cost2, costBoth <= 106
//             0 <= need1, need2 <= 109

// Approach: Only two ways to optimise results one to buy max of needs and other to buy min of needs and remaning need by cost

// Time and Space Complexity:
  // TC: O(n)
  // SC: O(1)

// Code:

class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(need1 == 0 && need2 == 0)return 0;

        int costIfBuySeperateT1T2 = cost1 + cost2;

        // Buying extra 
        int maxNeed = Math.max(need1, need2);

        long costWhenBuyExtra = 0l;

        if(maxNeed > 0){
            if(costIfBuySeperateT1T2 <= costBoth){
                costWhenBuyExtra += (long)maxNeed * costIfBuySeperateT1T2;
            }
            else{
                costWhenBuyExtra += (long)maxNeed * costBoth;
            }
        }

        // Buying exact
        int minNeed = Math.min(need1, need2);

        long costWhenMinNeed = 0l;

        if(minNeed > 0){
            if(costIfBuySeperateT1T2 <= costBoth){
                costWhenMinNeed += (long)minNeed * costIfBuySeperateT1T2;
            }
            else{
                costWhenMinNeed += (long)minNeed * costBoth;
            }

            need1 -= minNeed;
            need2 -= minNeed;
        }

        costWhenMinNeed += (long)need1 * cost1;
        costWhenMinNeed += (long)need2 * cost2;

        return Math.min(costWhenMinNeed, costWhenBuyExtra);
    }
}

