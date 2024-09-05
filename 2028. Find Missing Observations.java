class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumR = 0;
        
        for(int i: rolls){
            sumR += i;
        }

        // Solving the equation  (sumR + (remaining n))/(roll.length + n) = mean

        int remS = (mean * (rolls.length + n)) - sumR;

        System.out.println("RemS: " + remS);

        int ans[] = new int[n];

        int remEle = n;

        if(remS / n > 6 || remS / n <= 0)return new int[]{};

        for(int i = 0; i < n; i ++){
            if(remS / n <= 6){
                ans[i] = remS / remEle;
                remS -= remS / remEle;
                remEle --;
            }
            else{
                ans[i] = remS / remEle + 1;
                remS -= remS / remEle + 1;
                remEle --;
            }

            if(ans[i] > 6)return new int[]{};
        }


        return ans;
    }
}
