class Solution {
    public int trap(int[] arr) {
        int l = 0, r = arr.length - 1;
        int maxLeft = 0, maxRight = 0;
        
        int ans = 0;
        while(l < r){
            if(arr[l] <= arr[r]){
                if(maxLeft <= arr[l]){
                    maxLeft = arr[l];
                }
                else{
                    ans += maxLeft - arr[l];
                }
                l++;
            }
            else if(arr[r] < arr[l]){
                if(maxRight <= arr[r]){
                    maxRight = arr[r];
                }
                else{
                    ans += maxRight - arr[r];
                }
                r--;
            }
        }

        return ans;
    }
}
