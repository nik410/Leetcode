class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<Character, Integer> hm = new HashMap();

        for(int i = 0; i < words[0].length(); i ++){
                hm.put(words[0].charAt(i), hm.getOrDefault(words[0].charAt(i), 0) + 1);
        }

        System.out.println(hm);
       

        for(String s: words){
           HashMap<Character, Integer> hm1 = new HashMap();
            for(int i = 0; i < s.length(); i ++){

                char c = s.charAt(i);

                if(hm.containsKey(c)){
                    hm1.put(c, hm1.getOrDefault(c, 0) + 1);
                    if(hm.get(c) == 1){
                        hm.remove(c);
                    }
                    else{
                        hm.put(c, hm.get(c) - 1);
                    }
                }
            }
            System.out.println(hm1 +" HM1");
            hm = hm1;
        }

        List<String> ans = new ArrayList();

        for(char c:  hm.keySet()){
            for(int i = 0; i < hm.get(c); i++){
            String s = "" + c;
           ans.add(s);}
        }

        return ans;
    }
}
