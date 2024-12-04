class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int l = 0, r = 0;

        while(l < str1.length() && r < str2.length()){
            char ch1 = str1.charAt(l);
            char ch2 = str2.charAt(r);

            // The use of modulo can be done to find the cyclic term
            // One can use if condition also see previous submission for reference
            // But the modulo looks better                      

            if(ch1 == ch2 || ch2 == (char)('a' + ((int)(ch1) + 1  - 'a')% 26)){               
                l ++;
                r ++;                
            }
            else{
                l ++;
            }
        }

        // System.out.println(r +" r");

        if(r == str2.length())return true;
        else{
            return false;
        }
    }
}
