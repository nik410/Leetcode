class Solution {
    public boolean canBeValid(String s, String locked) {

        // Using Stacks
        // Space complexity: O(n) Time Complexity: O(n)

        // if(s.length() % 2 == 1)return false;
        // else{
        //     Stack<Integer> open = new Stack();
        //     Stack<Integer> changable = new Stack();

        //     for(int i = 0; i < s.length(); i ++){
        //         char c1 = s.charAt(i);
        //         char c2 = locked.charAt(i);

        //         if(c2 == '0'){
        //             changable.push(i);
        //         }
        //         else if(c1 == '('){
        //             open.push(i);
        //         }

        //         else if(c1 == ')'){

        //             if(open.size() > 0){
        //                 open.pop();
        //             }
        //             else if(changable.size() > 0 && changable.peek() < i){
        //                 changable.pop();
        //             }
        //             else{
        //                 return false;
        //             }
        //         }
        //     }

        //     // System.out.println(open + "   " + changable);

        //     while(!open.isEmpty() && !changable.isEmpty() && open.peek() < changable.peek()){
        //         changable.pop();
        //         open.pop();
        //     }

        //     if(open.size() == 0)return true;
        //     else return false;

        // }

        // Without using extra O(n) space

        if(s.length() % 2 == 1)return false;
        
        int open = 0;

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '(' || locked.charAt(i) == '0')open ++;
            else open --;

            if(open < 0)return false;
        }

        int close = 0;

        for(int i = s.length() - 1; i >= 0; i --){
            if(s.charAt(i) == ')' || locked.charAt(i) == '0')close ++;
            else close --;

            if(close < 0)return false;
        }

        return true;


    }
}
