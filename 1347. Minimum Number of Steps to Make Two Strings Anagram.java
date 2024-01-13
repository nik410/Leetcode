class Solution {


    public int minSteps(String s, String t) {
        
      
        int charArr[] = new int[26];

        for(int i = 0; i < s.length(); i++){
            charArr[(int)s.charAt(i) - 97]++;
            charArr[(int)t.charAt(i) - 97]--;
        }

       
       int ans = 0; 
       for(int i : charArr){           
           ans += Math.abs(i);           
       }
        
       return ans/2;

    }
}
