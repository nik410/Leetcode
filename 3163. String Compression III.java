class Solution {
    public String compressedString(String word) {
        String ans = "";
        int wLen = word.length();
        for(int i = 0; i < wLen; i ++){
            int count = 1;
            int j = i + 1;

            while(j < wLen && word.charAt(i) == word.charAt(j)){
                j ++;
                count ++;
            }           
            
            for(int k = 0; k < count / 9; k ++){
                ans += "9" + word.charAt(i); 
            }

            if(count % 9 != 0){
                ans += Integer.toString(count % 9) + word.charAt(i) + "";
            }

            // System.out.println("Count: " +  count + " j: " +  j + " ans: " + ans);
            i = j - 1;

        }

        return ans;
    }
}
