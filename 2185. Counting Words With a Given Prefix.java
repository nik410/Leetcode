class Solution {

    public static class TrieNode{
        TrieNode[] children;
        boolean endOfWord;
        int wordCount;

        public TrieNode(){
            children = new TrieNode[26];
            endOfWord = false;
            wordCount = 0;
        }

        public void insert(TrieNode root, String s){
            TrieNode currNode = root;

            for(int i = 0; i < s.length(); i ++){
                int index = s.charAt(i) - 'a';

                if(currNode.children[index] == null){
                    currNode.children[index] = new TrieNode();
                  
                }

                currNode = currNode.children[index];
                currNode.wordCount += 1;
            }
            currNode.endOfWord = true;
        }

        public  int wordsWithPrefix(TrieNode root, String s){
            TrieNode currNode = root;
            int wordsWithPrefixS = 0;
            for(int i = 0; i < s.length(); i ++){
                int index = s.charAt(i) - 'a';

                 if(currNode.children[index] == null){
                    return 0;
                }

                if(currNode.children[index] != null){
                    currNode = currNode.children[index];
                }
            }

            wordsWithPrefixS = currNode.wordCount;

            return wordsWithPrefixS;
        }


    }
    
    public int prefixCount(String[] words, String pref) {

        // Using TRIE data structure

        TrieNode t = new TrieNode();

        for(int i = 0;  i < words.length; i ++){
            t.insert(t, words[i]);
        }


        return t.wordsWithPrefix(t, pref);

        // Bruteforce
        
        // int ans = 0;

        // for(int i = 0; i < words.length; i ++){

        //     String s = words[i];
        //     int j = 0;

        //     for(j = 0; j < s.length() && j < pref.length(); j ++){
        //         if(pref.charAt(j) != s.charAt(j))break;
        //     }

        //     if(j == pref.length())ans ++;            
        // }

        // return ans;
    }
}
