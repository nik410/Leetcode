class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        
        // Good question to use your hashmap knowledge

        int len = queries.length;
        int ans[] = new int[len];

        HashMap<Integer, Integer> currColorsFreq = new HashMap();
        HashMap<Integer, Integer> currColorCombo = new HashMap();

        for(int i = 0; i < len; i ++){
            int ball = queries[i][0];
            int color = queries[i][1];
            
            if(currColorCombo.containsKey(ball)){
                int prevColor = currColorCombo.get(ball);

                if(currColorsFreq.get(prevColor) == 1){
                    currColorsFreq.remove(prevColor);
                }
                else{
                     currColorsFreq.put(prevColor, currColorsFreq.get(prevColor) - 1);
                }
                
                currColorCombo.put(ball, color);
            }
            else{
                currColorCombo.put(ball, color);
            }
            // System.out.println(currColorCombo + " Color: " + currColors);
            currColorsFreq.put(color, currColorsFreq.getOrDefault(color, 0) + 1);

            // System.out.println(currColorCombo + " Color: " + currColors + " Index: " +  i);
            
            ans[i] = currColorsFreq.size();
            
        }

        return ans;
    }
}
