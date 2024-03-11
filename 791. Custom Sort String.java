class Solution {
    public String customSortString(String order, String s) {
         HashMap<Character, Integer> hm = new HashMap();
        
        char arr[] = s.toCharArray();
        char brr[] = order.toCharArray();
        
        for(char c: arr){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            }
        
        String ans ="";
        

        for(char c: brr){
             if(hm.containsKey(c)){
                 int count = hm.get(c);
               while(count --  > 0){
                   ans += c + "";
               }
               hm.remove(c);
            }
                                         
        }

         for(char c: hm.keySet()){
             if(hm.containsKey(c)){
                 int count = hm.get(c);
               while(count --  > 0){
                   ans += c + "";
               }             
            }
                                         
        }   

        return ans;
    }
}
