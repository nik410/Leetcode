class Solution {

    public String rec(int n, StringBuilder stb, HashSet<String> hs){
        if(stb.length() == n){
            String possRes = stb.toString();
            System.out.println(possRes);
            if(!hs.contains(possRes)){
                return possRes;
            }
            return "";
        }

        for(int i = 0; i < 2; i ++){
            char c = (char)(i + '0');

            stb.append(c);

            String s = rec(n, stb, hs);
            
            if(!s.equals(""))return s;

            stb.deleteCharAt(stb.length() - 1); 
        }

        return "";
    }

    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> hs = new HashSet();

        for(String s: nums){
            hs.add(s);
        }

        StringBuilder stb = new StringBuilder();
        return rec(nums.length, stb, hs);
    }
}
