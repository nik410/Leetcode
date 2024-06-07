class Solution {

    public String findRoot(String s, HashSet<String> hs){
        for(int i = 0; i < s.length(); i ++){
            String sub = s.substring(0, i);
            if(hs.contains(sub)){
                return sub;
            }
        }

        return s;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> hs = new HashSet();

        for(String s: dictionary)hs.add(s);

        String res = "";

        String sent[] = sentence.split(" ");

        for(int i = 0; i < sent.length; i ++){
            if(i < sent.length - 1)
                res += findRoot(sent[i], hs) + " ";
            else{
                res += findRoot(sent[i], hs);
            }
        }


        return res;
    }
}
