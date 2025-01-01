class Solution {

    // public int minCost(int arr[], int index, int costs[]){

    //     if(index >= arr.length)return 0;

    //     int daily = 0, weekly = 0, monthly = 0;

    //     daily = costs[0] + minCost(arr, index + 1, costs);

    //     // Finding the next possible index which is out of the weekly range

    //     int currDay = arr[index];
    //     int newIndex = index;
    //     for(int i = index; i < arr.length; i ++){
    //         if(arr[i] - currDay >= 7)break;
    //         newIndex = i;
    //     }

    //     weekly = costs[1] + minCost(arr, newIndex + 1, costs);

    //     // Finding the next possible index which is out of the monthly range

    //     currDay = arr[index];
    //     newIndex = index;

    //     for(int i = index; i < arr.length; i ++){
    //         if(arr[i] - currDay >= 30)break;
    //         newIndex = i;
    //     }

    //     monthly = costs[2] + minCost(arr, newIndex + 1, costs);


    //     return Math.min(daily, Math.min(weekly, monthly));

    // }

    public int mincostTickets(int[] days, int[] costs) {
        // The fully recursive solution gives Time Limited Exceeded 
        // due to many overlapping and repaeating computations
        
        // return minCost(days, 0, costs);

        // Memoization of the recursive approach

        // int dp[] = new int[days.length];
        
        // // Look at contrainst of costs as if the costs can have 0 then the dp array
        // // needs to be initialised with even smaller value        

        // return minCostMemoization(days, 0, costs, dp);


        // The finding of the index in the recursive and tabulation
        // We can use binary search inplace of linear search for better results


        // Tabulation Approach 

        int lenOfDP = days[days.length - 1];

        int dp[] = new int[lenOfDP + 1];
        dp[0] = 0;
        
        int index = 0;

        for(int i = 1; i < lenOfDP + 1; i ++){

            if(days[index] != i){
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = Integer.MAX_VALUE;
            
            int daily = 0, weekly = 0, monthly = 0;

            daily = costs[0] + dp[i - 1];            
            
            weekly = costs[1] + dp[Math.max(i - 7, 0)];
            
            monthly = costs[2] +dp[Math.max(i - 30, 0)];

            dp[i] = Math.min(daily, Math.min(weekly, monthly));
            
            index ++;
        }
        

        return dp[lenOfDP];


        
    }

    // public int minCostMemoization(int arr[], int index, int costs[], int dp[]){

    //     if(index == arr.length)return 0;

    //     if(dp[index] != 0)return dp[index];

    //     int daily = 0, weekly = 0, monthly = 0;

    //     daily = costs[0] + minCostMemoization(arr, index + 1, costs, dp);

    //     int currDay = arr[index];
    //     int newIndex = index;

    //     for(int i = index; i < arr.length; i ++){
    //         if(arr[i] - currDay >= 7)break;
    //         newIndex = i;
    //     }

    //     weekly = costs[1] + minCostMemoization(arr, newIndex + 1, costs, dp);


    //     currDay = arr[index];
    //     newIndex = index;

    //     for(int i = index; i < arr.length; i ++){
    //         if(arr[i] - currDay >= 30)break;
    //         newIndex = i;
    //     }

    //     monthly = costs[2] + minCostMemoization(arr, newIndex + 1, costs, dp);

    //     return dp[index] = Math.min(daily, Math.min(weekly, monthly));
    // }
}
