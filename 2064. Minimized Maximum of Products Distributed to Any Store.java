class Solution {

    public int goodFunc(int n, int arr[], int mid){
        int count = 0;

        for(int i: arr){
            if(i % mid == 0){
                count += i  / mid;
            }
            else{
                count += i / mid + 1;
            }
        }

        if(count <= n)return 0;
        else  return -1;
        
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1, high = Integer.MIN_VALUE;

        for(int i: quantities){
            high = Math.max(high, i);
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(goodFunc(n, quantities, mid) == 0){
                high = mid - 1;  
                ans = mid;             
            }
            else if(goodFunc(n, quantities, mid) == - 1){ 
                low = mid + 1;
            }
            
        }

        return ans;
    }
}
