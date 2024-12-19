class Solution {
    public int maxChunksToSorted(int[] arr) {
        int prefSum = 0, sortedSum = 0;
        int ans = 0;

        for(int i = 0; i < arr.length; i ++){
            prefSum += arr[i];
            sortedSum += i;

            if(prefSum == sortedSum) ans ++;
        }

        return ans;
    }
}
