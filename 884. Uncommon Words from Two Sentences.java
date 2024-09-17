class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> hm = new HashMap();

        for(int i = 0; i < s1.length(); i ++){
            int j = i; 
            String s = "";
            while(j < s1.length()){
                if(s1.charAt(j) == ' '){
                    break;
                }
                else{
                    s += s1.charAt(j);
                }
                j ++;
            }
            i = j;

            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }


        for(int i = 0; i < s2.length(); i ++){
            int j = i; 
            String s = "";
            while(j < s2.length()){
                if(s2.charAt(j) == ' '){
                    break;
                }
                else{
                    s += s2.charAt(j);
                }
                j ++;
            }
            i = j;

            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }

        ArrayList<String> al = new ArrayList();

        for(String s: hm.keySet()){
            if(hm.get(s) == 1)
            al.add(s);
        }

        String ans[] = new String[al.size()];

        for(int i = 0; i < al.size(); i ++){
            ans[i] = al.get(i);
        }

        return ans;
    }
}
