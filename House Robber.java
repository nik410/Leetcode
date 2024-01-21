class Solution {

    // public int max(int arr[], int index){
    //     int maxAns = 0;
    //     if(index < 0)return 0;
    //     if(index == 0){
    //         return arr[0];
    //     }
    //     int take = 0;
        
    //      take = arr[index] + max(arr, index - 2);

    //     int notTake = 0 + max(arr, index - 1);

    //     maxAns = Math.max(take , notTake);

    //     return maxAns;
    // }

    public int rob(int[] arr) {
       int dp[] =new int[arr.length];
       if(arr.length == 1)return arr[0];
       dp[0] = arr[0];
       dp[1] = Math.max(arr[0], arr[1]);
       for(int i = 2; i < arr.length; i++){
           dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
       }

       return dp[arr.length - 1];
    }
}
