class Solution {
    public int[] finalPrices(int[] arr) {
        int len = arr.length;

        int ans[] = new int[len];
        
        Stack<Integer> st = new Stack();

        for(int i = len - 1; i >= 0; i --){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            
            if(st.size() != 0){
                ans[i] = arr[i] - arr[st.peek()];
            }
            else{
                ans[i] = arr[i];
            }
            

            st.push(i);
        }

        return ans;
    }
}
