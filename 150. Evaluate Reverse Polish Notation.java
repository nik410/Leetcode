class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();

        for(int i = 0; i < tokens.length; i++){
            
            if(tokens[i].length() == 1 && (tokens[i].charAt(0) == '+' || tokens[i].charAt(0) == '-' || tokens[i].charAt(0) == '/' || tokens[i].charAt(0) == '*')){
                    int a = st.pop();
                    int b = st.pop();

                    if(tokens[i].charAt(0) == '+' ){
                        int res = a + b;
                        st.push(res);
                    }
                    if(tokens[i].charAt(0) == '-' ){
                        int res = b - a;
                        st.push(res);
                    }
                    if(tokens[i].charAt(0) == '*' ){
                        int res = a * b;
                        st.push(res);
                    }
                    if(tokens[i].charAt(0) == '/' ){
                        int res = b / a;
                        st.push(res);
                    }
                }
                else{
                    int value = Integer.parseInt(tokens[i]);
                    st.push(value);
                }
                

        }

        return st.pop();
    }
}
