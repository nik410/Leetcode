class Solution {

    // static class Pair{
    //     int one;
    //     int zero;

    //     public Pair(int one, int zero){
    //         this.one = one;
    //         this.zero = zero;
    //     }        
    // }

    public int minChanges(String s) {
        
        // int sLen = s.length();

        // Pair suff[] = new Pair[sLen];
        // Pair pref[] = new Pair[sLen];

        // // Filling the prefix Sum Array Containing count of zero and one at each index

        // for(int i = 0; i < sLen; i ++){
        //     if(s.charAt(i) == '0'){
        //         if(i == 0) pref[i] = new Pair(0, 1);
        //         else{
        //             pref[i] = new Pair(pref[i - 1].one, pref[i - 1].zero + 1);
        //         }
        //     }

        //     if(s.charAt(i) == '1'){
        //         if(i == 0) pref[i] = new Pair(1, 0);
        //         else{
        //             pref[i] = new Pair(pref[i - 1].one + 1, pref[i - 1].zero);
        //         }
        //     }
        // }

        // // Making th suffix sum Array

        // for(int i = sLen - 1; i >= 0; i --){
        //     if(s.charAt(i) == '0'){
        //         if(i == sLen - 1) suff[i] = new Pair(0, 1);
        //         else{
        //             suff[i] = new Pair(suff[i  + 1].one, suff[i + 1].zero + 1);
        //         }
        //     }

        //     if(s.charAt(i) == '1'){
        //         if(i == sLen - 1) suff[i] = new Pair(1, 0);
        //         else{
        //             suff[i] = new Pair(suff[i + 1].one + 1, suff[i + 1].zero);
        //         }
        //     }
        // }

        // int ans = Integer.MAX_VALUE;

        // if(pref[sLen - 1].one == 0 || pref[sLen - 1].zero == 0)return 0;

        // for(int i = 1; i < sLen; i += 2){
        //     if( i == sLen - 1){
        //         ans = Math.min(ans, Math.min(pref[i].zero, pref[i].one));
        //     }
        //     else{
        //         //Changing zero to one 

        //         int freqZ = pref[i].zero;
                
        //         int freqSZ = suff[i + 1].zero;

        //         int change1 = freqZ + freqSZ;

        //         //Changing one to zero

        //         int freqZ1 = pref[i].one;
                
        //         int freqSZ1 = suff[i + 1].one;

        //         int change2 = freqZ1 + freqSZ1;

        //         ans = Math.min(ans, Math.min(change1, change2));

        //     }
        // }

        // return ans;


        // Misread the question

        int sLen = s.length();

        int changes = 0;

        for(int i = 0; i < sLen; i ++){
            int count = 1;
            int j = i + 1;

            while(j < sLen && s.charAt(i) == s.charAt(j)){
                j ++;
                count ++;
            }

            if((count & 1) == 1){
                changes ++;
                i = j;
            }
            else{
                i = j - 1;
            }
            

        }

        return changes;

    }
}
