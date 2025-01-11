class Solution {
    public boolean canConstruct(String s, int k) {
        int freq[] = new int[26];

        if(k > s.length())return false;

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);

            freq[c -'a'] ++;
        }

        int oddFreq = 0;

        for(int i: freq){
            if((i & 1) == 1)oddFreq ++;
        }


        // Observation based easy question

        if(oddFreq > k)return false;
        else{
            return true;
        }




    }
}
