class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int ans = 0;

        for(int i = 0; i < customers.length; i ++){
            if(grumpy[i] == 0)ans += customers[i];
        }

        int maxGrumScore = 0;
        for(int i = 0; i < customers.length - minutes + 1; i ++){
            
            int sc = 0;
            for(int j = i; j < i + minutes; j ++){
                if(grumpy[j] == 1)sc += customers[j];
            }

            // System.out.println(sc +"Score" +" index: " + i);
            maxGrumScore = Math.max(maxGrumScore, sc);
        }

        return ans + maxGrumScore;

    }
}
