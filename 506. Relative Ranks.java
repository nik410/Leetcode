class Solution {
    public String[] findRelativeRanks(int[] score) {
        TreeMap<Integer, Integer> tm = new TreeMap();

        for(int i = 0; i < score.length; i++){
            tm.put(score[i], i);
        }

        String ans[] = new String[score.length];
        
        int filled = 0;
        for(int i: tm.keySet()){
                if(score.length - filled > 3){
                    String s = Integer.toString(score.length - filled);
                    ans[tm.get(i)] = "" + s;
                    filled++;
                }
                else{
                    if(score.length - filled == 3)
                    ans[tm.get(i)] = "Bronze Medal";
                    if(score.length - filled == 2)
                    ans[tm.get(i)] = "Silver Medal";
                    if(score.length - filled == 1)
                    ans[tm.get(i)] = "Gold Medal";
                    filled++;

                }         
        }
        
        return ans;

    }
}
