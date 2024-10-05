class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap();
        int len1 = s1.length();
        for(int i = 0; i < len1; i ++){
            char c = s1.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        // System.out.println(hm +" :HM");

        HashMap<Character, Integer> hmCopy = new HashMap(hm);

        for(int i = 0; i < s2.length() - len1 + 1; i ++){          

            for(int j = i; j < s2.length(); j ++){
                char c = s2.charAt(j);
                if(hmCopy.containsKey(c)){
                    if(hmCopy.get(c) == 1){
                        hmCopy.remove(c);
                    }
                    else{
                        hmCopy.put(c, hmCopy.get(c) - 1);
                    }
                }
                else if(hmCopy.size() == 0 || !hmCopy.containsKey(c)) {                
                    break;
                }
            }

            // System.out.println(hmCopy +" :hmCopy" + " Index: " + i);

            if(hmCopy.size() == 0)return true;
            else{
                 hmCopy = new HashMap(hm);
            }
        }

        // System.out.println(hmCopy +" :hmCopy");

       
        return false;

    }
}
