class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int len1 = words1.length;
        int len2 = words2.length;

        List<String> ans = new ArrayList();

        int maxFreq[] = new int[26];

        for(int i = 0; i < len2; i ++){
            String s = words2[i];

            int freq[] = new int[26];

            for(int j = 0; j < s.length(); j ++){
                freq[s.charAt(j) - 'a'] ++;
            }


            for(int j = 0; j < 26; j ++){
                maxFreq[j] = Math.max(maxFreq[j], freq[j]);
            }
        }


        for(int i = 0; i < len1; i ++){
            int freq[] = new int[26];
            String s = words1[i];
            for(int j = 0; j < s.length(); j ++){
                freq[s.charAt(j) - 'a'] ++;
            }

            int j = 0;
            for(j = 0; j < 26; j ++){
                if(maxFreq[j] > freq[j])break;
            }

            if(j == 26)ans.add(s);
        }
 



        //Misread the question the order doesn't matter

        // for(int i = 0; i < len1; i ++){
        //     String s1 = words1[i];
        //     int count = 0;
        //     for(int j = 0; j < len2; j ++){
        //         String s2 = words2[j];

        //         int k = 0;
        //         int in = 0;
        //         while(k < s2.length() && in < s1.length()){
        //             if(s1.charAt(in) == s2.charAt(k)){
        //                 k ++;
        //                 in ++;
        //             }
        //             else{
        //                 in ++;
        //             }
        //         }

        //         if(k == s2.length())count ++;
        //     }

        //     if(count == len2)ans.add(s1);
        // }
        // return ans;

        // HashMap<String, HashMap<Character, Integer>> hm = new HashMap();

        // for(int i = 0; i < len1; i ++){
        //     HashMap<Character, Integer> charFreq = new HashMap();

        //     String s = words1[i];

        //     for(int j = 0; j < s.length(); j ++){
        //         charFreq.put(s.charAt(j), charFreq.getOrDefault(s.charAt(j), 0) + 1);
        //     }

        //     hm.put(s, charFreq);
        // }

        
        // // Look out for how you are referencing the hashmap with character frequency data
        // // As wrong input can cause data change in the orignal data which might be useful in future
        // // So make a copy of original data always

        // for(String s: hm.keySet()){
        //     HashMap<Character, Integer> orig = hm.get(s);
        //     HashMap<Character, Integer> charFreq = new HashMap(orig);

        //     // System.out.println(charFreq);

        //     int count = 0;
        //     outer: for(int i = 0; i < len2; i ++){
        //                 String str = words2[i];

        //                 for(int k = 0; k < str.length(); k ++){
        //                     char c = str.charAt(k);

        //                     if(!charFreq.containsKey(c))break outer;

        //                     if(charFreq.get(c) == 0) break outer;

        //                     charFreq.put(c, charFreq.get(c) - 1);
        //                 }

        //                 charFreq = new HashMap(orig);
        //                 // System.out.println(charFreq +" charFreq");
        //                 count ++;
        //     }

        //     if(count == len2)ans.add(s);
        // }

        // // System.out.println(hm);

        return ans;
    }
}
