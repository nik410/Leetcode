class Solution {
    public boolean checkValidString(String s) {
    //     Stack<Integer> s1 = new Stack();
    //     Stack<Integer> ast = new Stack();

    //     for(int i = 0; i < s.length(); i++){

    //         char c = s.charAt(i);
    //         if(c == '('){
    //             s1.push(i);
    //         }
    //         else if(c == ')'){
    //             if(s1.isEmpty()){
    //                 if(ast.isEmpty()){
    //                     return false;
    //                 }
    //                 else{
    //                     ast.pop();
    //                 }
    //             }
    //             else{
    //                 s1.pop();
    //             }
    //         }
    //         else{
    //             ast.push(i);
    //         }
    //     }

    //    while(!s1.isEmpty() && !ast.isEmpty()){
    //         if(s1.peek() > ast.peek())return false;

    //         s1.pop();
    //         ast.pop();
    //    } 
       
    //    return s1.isEmpty();

    int openC = 0, closeC = 0;

    for(int i = 0; i < s.length(); i++){
        if(s.charAt(i) == '(' || s.charAt(i) == '*')openC++;
        else{
            openC--;
        }

        if(s.charAt(s.length() - i - 1) == ')' || s.charAt(s.length() - i - 1) == '*')closeC ++;
        else{
            closeC--;
        }

        if(openC < 0 || closeC < 0){
            return false;
        }

    }

    return true;

    }
}
