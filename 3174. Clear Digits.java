class Solution {
    public String clearDigits(String s) {
        // Stack<Character> st = new Stack();

        // StringBuilder ans = new StringBuilder();

        // for(int i = 0; i < s.length(); i ++){
        //     if(s.charAt(i) >= 97){
        //         st.push(s.charAt(i));
        //     }
        //     else{
        //         if(!st.isEmpty())st.pop();
        //     }
        // }

        // while(!st.isEmpty()){
        //     ans.append(st.pop());
        // }      

        // return ans.reverse().toString();

        // Doing it in place 

        int i = 0;
        int j = 0;

        while(i < s.length()){
            if(s.charAt(i) < 97){
                j = Math.max(j - 1, 0);
                i++;
            }
            else if(s.charAt(i) >= 97){
                // Swap the characters
                // In java not possible as c ++ so one way is to convert the string as a char array and do it
                i ++;
                j ++;
            }
        }
        return s.substring(0, j);
    }
}
