class CustomStack {

    int stack[];
    int incre[];
    int top = -1;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        incre = new int[maxSize];
    }
    
    public void push(int x) {
        if(top >= stack.length - 1){
            return;
        }
        else{
            stack[++ top] = x;
        }
    }
    
    public int pop() {
        if(top == -1){
            return -1;
        }
        else{
           int curr = stack[top];
           

           int ans = curr + incre[top];
           
           if(top > 0){
            incre[top - 1] += incre[top];
           }

           incre[top] = 0;

           -- top ;

           return ans;
        }
    }
    
    public void increment(int k, int val) {
        
        int ind = Math.min(k - 1, top);
        if(ind >= 0)
        incre[ind] += val;

    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
