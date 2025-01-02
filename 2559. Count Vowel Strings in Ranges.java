class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = words.length;
        int prefArr[] = new int[len];
       
        HashSet<Character> vowels = new HashSet();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int count = 0;
       
        for(int i = 0; i < len; i ++){
            String currWord = words[i];
            if(currWord.length() == 1){
               if(vowels.contains(currWord.charAt(0))){
                count ++;
               }
            }
            else{
                 if(vowels.contains(currWord.charAt(0)) && vowels.contains(currWord.charAt(currWord.length() - 1))){
                    count ++;
               }
            }

            prefArr[i] = count;
        }

        int ans[] = new int[queries.length];

        for(int i = 0; i < queries.length; i ++){
            int l = queries[i][0];
            int r = queries[i][1];

            if(l == 0)
                ans[i] = prefArr[r];
            else{
                ans[i] = prefArr[r] - prefArr[l - 1];
            }
        }

        return ans;
    }
}
