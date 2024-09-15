class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        hm.put('a', 1);
        hm.put('e', 2);
        hm.put('i', 3);
        hm.put('o', 4);
        hm.put('u', 5);

        HashMap<Integer, Integer> hm1 = new HashMap();
        hm1.put(0, -1);

        int numWithData = 0; // The indivisual bits of this nuber will contain info of even/ odd counts
        int maxLength = 0;
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);

            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                numWithData = (numWithData ^ (1 << hm.get(c)));
            }

            if(hm1.containsKey(numWithData)){
                maxLength = Math.max(maxLength, i - hm1.get(numWithData));
            }
            else{
                hm1.put(numWithData, i);
            }
        }

        return maxLength;


    }
}
