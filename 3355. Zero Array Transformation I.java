class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int len = nums.length;

        int pref[] = new int[len + 1];

        int copyNums[] = nums.clone();

        for(int i = 0; i < queries.length; i ++){
            pref[queries[i][0]] -= 1;
            pref[queries[i][1] + 1] += 1;
        }

        for(int i = 0; i < len + 1; i ++){
            if(i == 0)pref[i] = pref[0];
            else
            pref[i] += pref[i - 1];
        }

        for(int i = 0; i < len; i ++){
            copyNums[i] += pref[i];
        }

        // System.out.println("------");

        // for(int i: copyNums){
        //     System.out.println(i +" ");
        // }

        // System.out.println("-------");
        
        for(int i: copyNums){
            if(i > 0)return false;
        }

        return true;

    }
}
