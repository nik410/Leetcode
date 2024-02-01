class Solution {
    public int[][] divideArray(int[] arr, int k) {
        int ans[][] = new int[arr.length/3][3];

        Arrays.sort(arr);
        int first = 0, flag = 0;
        for(int i = 0; i < arr.length; i++){

            if(i % 3 ==0){
                ans[i/3][0] = arr[i]; 
                first = ans[i/3][0];
            }
            if(i % 3 == 1){
                ans[i/3][1] = arr[i];
                if(arr[i] - first > k)
                {
                    flag = 1;
                    break;
                }
            }
            if(i % 3 == 2){
                ans[i/3][2] = arr[i]; 

                if(arr[i] - first > k)
                {
                    flag = 1;
                    break;
                }
            }
        }

        if(flag == 0)
        return ans;
        else{
            return new int[0][0];
        }
    }
}
