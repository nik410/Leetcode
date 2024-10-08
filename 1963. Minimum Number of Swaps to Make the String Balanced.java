  class Solution {
    public int minSwaps(String s) {
       Stack<Character> st = new Stack();

       for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);         
            if(!st.isEmpty() && st.peek() == '[' && c == ']')st.pop();
            
            else{
                st.push(c);
            }
       }  

    //    System.out.println(st);

       int ans = (st.size() / 2) / 2;

       if((st.size() / 2) % 2 != 0)ans ++; 

       return ans;
    }
}
