class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack();
        char cArr[] = num.toCharArray();

        for(int i = 0; i < cArr.length && k > 0; i++){

            while(!st.isEmpty() && cArr[st.peek()] > cArr[i] && k > 0){
                cArr[st.peek()] ='#';
                st.pop();
                k--;
            } 
          
            st.push(i);

           
       }
        //System.out.println(st +" k :" + k);

       //Condition where the k is not equal to zero   

       while(!st.isEmpty() && k -- > 0){
        cArr[st.pop()] = '#';
        if(st.isEmpty())return "0";
        
       }

       String ans = "";

       for(char c: cArr){
        if(ans.length() == 0){
            if(c == '#' || c == '0')continue;
            else{
                ans += c + "";
            }
        }
        else{
            if(c != '#')ans += c + "";
        }

       }

       if(ans.length() == 0)return "0"; 
       return ans;

    }
}
