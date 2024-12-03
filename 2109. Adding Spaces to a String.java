class Solution {
    public String addSpaces(String s, int[] spaces) {

        // Usage of String gives TLE that is beacause for everynew String we create a new String which
        // is inefficient while StringBuilder is made for better efficient String Manipulation

        StringBuilder ans = new StringBuilder();
        int index = 0;

        if(spaces[index] == 0){
            ans.append(" ");
            index ++;
        }


        for(int i = 0; i < s.length(); i ++){
            if(index < spaces.length && i +
             1 == spaces[index]){
                ans.append(s.charAt(i) + " ");
                index ++;
            }
            else{                
                 ans.append(s.charAt(i) + "");          
            }

        }

        return ans.toString();
    }
}
