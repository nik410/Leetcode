class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack();
        StringBuilder ans = new StringBuilder();

        loop: for(char c: s.toCharArray()){

            if(st.isEmpty()){
                st.push(c);                
            }
            else{
                while(!st.isEmpty()){
                    if(st.peek() != c &&st.peek() == Character.toLowerCase(c)){
                        st.pop();
                        continue loop;
                    }
                    else if(st.peek() != c && st.peek() == Character.toUpperCase(c)){
                        st.pop();
                        continue loop;
                    }
                    else{
                        break;
                    }
                }

                st.push(c);
            }
        }

        System.out.println(st);

        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        ans = ans.reverse();

        return ans.toString();
    }
}
