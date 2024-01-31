class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack();
        int n = temperatures.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            int currValue = temperatures[i];
            
            while(!st.isEmpty() && temperatures[st.peek()] < currValue){               
               ans[st.peek()] = i - st.pop();
            }
            st.push(i);
        }

        return ans;
    }
}
