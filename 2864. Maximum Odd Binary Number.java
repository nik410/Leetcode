class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length(), count1 = 0;
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){     
                    count1++;          
            }          
        }
        for(int i = 0; i < count1 - 1; i++){
            stb.append("1");
        }
        for(int i =count1 ; i < n; i++){
            stb.append("0");
        }

        stb.append("1");

        return stb.toString();
    }
}
