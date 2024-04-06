class Solution {
    public String minRemoveToMakeValid(String s) {
        char c[] = s.toCharArray();

        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(c[i] == '('){
                count++;
            }
            else if(c[i] == ')'){
                if(count > 0){
                    count--;
                }
                else{
                    c[i] = '0';
                }
            }
        }

        count = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            if(c[i] == ')'){
                count++;
            }
            else if(c[i] =='('){
                if(count > 0){
                    count--;
                }
                else{
                    c[i] = '0';
                }
            }
        }

        String ans = "";

        for(char ch: c){
            if(ch != '0'){
                ans += ch +"";
            }
        }

        return ans;
    }
}
