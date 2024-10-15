class Solution {


    public long minimumSteps(String s) {
        // long ans = 0;
        // int len = s.length();

        // int suffArr[] = new int[len];

        // suffArr[len - 1] = s.charAt(len - 1) == '0' ? 1: 0;

        // for(int i = s.length() - 2; i >= 0; i --){
        //     if(s.charAt(i) == '0'){
        //         suffArr[i] = suffArr[i + 1] + 1;
        //     }
        //     else{
        //         suffArr[i] = suffArr[i + 1];
        //     }
        // }

        // for(int i = 0; i < s.length(); i ++){
        //     if(s.charAt(i) == '0')continue;
        //     else{
        //         ans += suffArr[i];
        //     }
        // }

        // return ans;

        // Better approach

        long ans = 0;

        int black = 0;

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '0'){
                ans += black;
            }
            else{
                black ++;
            }
        }


        return ans;

    }
}
