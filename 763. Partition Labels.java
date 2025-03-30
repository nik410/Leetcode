class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastOccurance[] = new int[26];

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            lastOccurance[c -'a'] = i;
        }

        List<Integer> ans = new ArrayList();
        int lastIn = 0;
        int lastCumulative = 0;
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            lastIn = Math.max(lastIn, lastOccurance[c-'a']);

            if(lastIn == i){
                if(ans.size() == 0){
                    ans.add(i + 1);   
                    lastCumulative += i + 1;                 
                }
                else{
                    // System.out.println("ans: " + ans + " index: "+  i);
                    int len = (i + 1) - lastCumulative;
                    lastCumulative += len;      
                    // System.out.println("len: " + len);
                    ans.add(len);
                }
                lastIn = 0;
            }
        }
        return ans;
    }
}
