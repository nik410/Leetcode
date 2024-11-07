class Solution {
    public int largestCombination(int[] candidates) {
        int  arr[] = new int[32];
        int cLen = candidates.length;

        for(int i = 0; i < cLen; i ++){
            
            int num = candidates[i];
            int bitCount = 0;
            while(num > 0){
                if((num % 2) == 1){
                    arr[bitCount] += 1;
                }
                bitCount ++;
                num = (num / 2);
            }
        }

        // for(int i: arr){
        //     System.out.print(i + " ");
        // }

        int count =  Integer.MIN_VALUE;

        for(int i = 0; i < 32; i ++){

            count = Math.max(arr[i], count);
        }

        return count;
    }
}
