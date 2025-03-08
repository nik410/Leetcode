class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whiteCount = 0;
        int blackCount = 0;

        int ans = blocks.length();
        int pnt = 0;
        for(int i = 0; i < blocks.length(); i ++){
            if(blocks.charAt(i) == 'W')whiteCount ++;
            else {
                blackCount ++;
            }

            if(i == k - 1){
                ans = Math.min(ans, k - blackCount);
                // System.out.println("Index: " + i + "Ans: " + (k - blackCount));
            }
            else if(i >= k){
                if(blocks.charAt(pnt) == 'W')whiteCount --;
                else {
                    blackCount --;
                }

                pnt ++;
                // System.out.println("Index: " + i + "Ans: " + (k - blackCount));
                ans = Math.min(ans, k - blackCount);
            }


        }

        return ans;
    }
}
