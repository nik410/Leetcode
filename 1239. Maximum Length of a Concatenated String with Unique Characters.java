class Solution {

    public void subs(List<String> arr, ArrayList<String> sub, int index, ArrayList<ArrayList<String>> ans){
        if(index == arr.size()){
            if(sub.size() > 0){
                ans.add(new ArrayList(sub));
            }
            return;}
        else{
        subs(arr, sub, index + 1, ans);
        sub.add(arr.get(index));
        subs(arr, sub, index + 1, ans);        
        sub.remove(sub.size() - 1);
        }
        return;
           }
    public int maxLength(List<String> arr) {
        ArrayList<String> sub = new ArrayList();
        ArrayList<ArrayList<String>> ans = new ArrayList();
        subs(arr, sub, 0, ans);
        int res = 0;
        for(int i = 0; i < ans.size(); i++){
            HashSet<Character> hs = new HashSet();
            int len = 0;
            for(int j = 0; j < ans.get(i).size(); j++){
                String s = ans.get(i).get(j);
                len += s.length();
                for(char c: s.toCharArray())hs.add(c);
            }

            if(len == hs.size())res = Math.max(len, res);
            hs.clear();
        }

        return res;
    }
}
