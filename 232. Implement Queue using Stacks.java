class MyQueue {
    
    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        while(stack1.size() > 1){
            stack2.push(stack1.pop());

        }

        int popped = stack1.pop();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return popped;
    }
    
    public int peek() {
        while(stack1.size() > 1){
            stack2.push(stack1.pop());

        }

        int peeked = stack1.pop();
        stack1.push(peeked);

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return peeked;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
