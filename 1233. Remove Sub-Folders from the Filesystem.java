class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        Arrays.sort(folder);

        HashSet<String> hs = new HashSet();
        List<String> ans = new ArrayList();
        ans.add(folder[0]);

        for(int i = 1; i < folder.length; i ++){
            String curr = folder[i];

            String last = ans.get(ans.size() - 1) + "/";

            boolean containsLast = false;
            int index = 0;

            for(int j = 0 ; j < curr.length() && index < last.length(); j ++){
                if(curr.charAt(j) == last.charAt(index)){
                    index ++;
                }
                else{
                    containsLast = true;
                    break;
                }
            }
            // System.out.println("curr: " + curr + " last: " + last + " ans: " + ans + " containsLAst: "  + containsLast);

            if(containsLast){
                ans.add(curr);
            }          
        }

        return ans;
    }
}
