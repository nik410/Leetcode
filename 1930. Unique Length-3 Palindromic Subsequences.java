class Solution {

    class Pair{
        int start;
        int end;

        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        public String toString(){
            return "[" + "Start: " + start + "]" + ", " + "[" + "End: " + end + "]";
        }
    }

    public int countPalindromicSubsequence(String s) {
        HashMap<Character, Pair> hm = new HashMap(); 

        int len = s.length();

        int uniquePrefArr[] = new int[len];     

        for(int i = 0; i < len; i ++){
            char c = s.charAt(i);

            if(!hm.containsKey(c))
            hm.put((char)(c), new Pair(-1, -1));

            int startIndex = hm.get(c).start;
            int endIndex = hm.get(c).end;

            if(startIndex == -1){
                hm.get(c).start = i;
            }

            hm.get(c).end = i;

            // uniquePrefArr[i] = hm.size();
        }

        int ans = 0;

        // for(int i: uniquePrefArr)
        // System.out.print(i + " ");

        // System.out.println("");

        // Unique character count prefix array doesn't work as
        // in a range it can happen that it has already occured outside of range 
        // And is not being included in th answer for the current range
        // Wasted 40 min on it haha


        for(char c: hm.keySet()){
            
            Pair p = hm.get(c);

            int startIndex = p.start;
            int endIndex = p.end;

            HashSet<Character> hs = new HashSet();

            for(int i = startIndex + 1; i < endIndex; i ++){
                hs.add(s.charAt(i));
            }

            ans  += hs.size();

          
            // Error in core logic skip this
          
            // if(endIndex - startIndex < 2)continue;
            
            // if(startIndex == 0){
            //       System.out.println("Ans: " + (uniquePrefArr[endIndex]) + " Char: " + c);
            //     ans += uniquePrefArr[endIndex];
            //     }
            // else{
            //     System.out.println("End: "+ (uniquePrefArr[endIndex - 1]) + " Start: " + uniquePrefArr[startIndex + 1] + " Char: " + c);
            //     ans += uniquePrefArr[endIndex - 1] - uniquePrefArr[startIndex + 1] + 1;
            // } 
            
        }

        // System.out.println(ans);


        return ans;

        // TC: O(N) for the creatin of hashmap containtaing all the startIndex and endIndex data
        // + O(26 * N) for the travesal across the string character to find uniques in a range

        // TC: O(N) + O(26*N) ~ O(26*N)
        // SC: O(26) + O(N) ~ O(N)
    }
}
