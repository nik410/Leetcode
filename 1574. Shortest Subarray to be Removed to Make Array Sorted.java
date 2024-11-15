class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int r1 = 0;
        int len = arr.length;
        for(int i = 0; i < len - 1; i ++){
            if(arr[i + 1] >= arr[i]){
                r1 ++;
            }
            else{
                break;
            }
        }

        if(r1 == len - 1)return 0;

        int r2 = len - 1;

        for(int i = len - 1; i > 0; i --){
            if(arr[i] >= arr[i - 1]){
                r2 --;
            }
            else{
                break;
            }
        }

        System.out.println(r1 +" " + r2);

        int r = r2;
        
        int ans = Math.min(len - r1 - 1, r2);

        for(int i = 0; i <= r1; i ++){
                int l = i;
                while(r < len && arr[r] < arr[l]){
                    r ++;                
                }
                if(r - l == 0)return 0;
                ans = Math.min(ans, r - l - 1);

                r = r2;
        }

        return ans;
    }
}

