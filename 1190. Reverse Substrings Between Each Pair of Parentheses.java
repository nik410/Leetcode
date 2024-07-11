class Solution {
    public String reverseParentheses(String s) {
        HashMap<Integer, Integer> hm = new HashMap();

        Stack<Integer> st = new Stack();

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else if(s.charAt(i) == ')'){
                int ind = st.pop();
                hm.put(ind, i);
                hm.put(i, ind);
            }
        }

        int dir = 1;
        String res = "";
        for(int i = 0; i < s.length(); i += dir){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                int closeIndex = hm.get(i);
                i = closeIndex;
                dir = -1 * dir;
            }
            else{
                res += s.charAt(i);
            }
        }

        return res;


      
    }
}
