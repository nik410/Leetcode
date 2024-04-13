class Solution {

    public static int maxArea(int arr[]){
        Stack<Integer> st = new Stack();
        int ans = 0;

        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int index = st.peek();
                st.pop();
                if(st.isEmpty()){
                    ans = Math.max(ans, arr[index] * (i));
                }
                else{
                    ans = Math.max(ans, arr[index] * (i - st.peek() - 1));
                }

            }
            st.push(i);
        }

        while(!st.isEmpty()){
             int index = st.peek();
                st.pop();
                if(st.isEmpty()){
                    ans = Math.max(ans, arr[index] * (arr.length));
                }
                else{
                    ans = Math.max(ans, arr[index] * (arr.length - st.peek() - 1));
                }
        }

        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        // int arr[] = new int[matrix[0].length];
        // int ansArea = 0;
        // for(int i = 0; i < matrix.length; i++){
            
        //     for(int j = 0; j < matrix[0].length; j++){
        //        if(matrix[i][j] == '1')arr[j] += 1;
        //        else{
        //             arr[j] = 0;
        //        }           
        //      }
        //     ansArea = Math.max(ansArea, maxArea(arr));
        // }

        // return ansArea;





        int arr[] = new int[matrix[0].length];
        int maxAns = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    arr[j] += 1;
                }
                else{
                    arr[j] = 0;
                }
            }
            maxAns = Math.max(maxAns, maxRec(arr));
        }

        return maxAns;
    }

    public static int maxRec(int arr[]){
        int ans = 0;

        Stack<Integer> st = new Stack();

        for(int i = 0; i < arr.length; i++){
            
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int index = st.peek();
                st.pop();
                if(st.isEmpty()){
                    ans = Math.max(ans, arr[index] *(i));
                }
                else{
                    ans = Math.max(ans, arr[index] *(i - st.peek() - 1));
                }
            }

            st.push(i);
        }

         while(!st.isEmpty()){
                int index = st.peek();
                st.pop();
                if(st.isEmpty()){
                    ans = Math.max(ans, arr[index] *(arr.length));
                }
                else{
                    ans = Math.max(ans, arr[index] *(arr.length - st.peek() - 1));
                }
            }



        return ans;
    }
}
