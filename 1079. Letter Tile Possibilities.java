class Solution {

    public void subs(String tiles, StringBuilder stb, HashSet<String> hs, int visited[]){
        
        hs.add(stb.toString());
       
        for(int i = 0; i < tiles.length(); i ++){
            if(visited[i] != 0)continue;

            visited[i] = 1;
            stb.append(tiles.charAt(i));

            subs(tiles, stb, hs, visited);

            visited[i] = 0;
            stb.deleteCharAt(stb.length() - 1); 
        }       
    }

    public int numTilePossibilities(String tiles) {
        // int lenTiles = tiles.length();


        // Important property in Java 

        // The primary issue with using a HashSet<StringBuilder> in Java is that the StringBuilder
        //  class does not override the equals() and hashCode() methods from the Object class. 
        // This means that two StringBuilder instances that contain the same sequence of characters will 
        // not be considered equal by the HashSet, and thus they will be treated as distinct objects.

        
        // HashSet<String> hs = new HashSet();
        // int visited[] = new int[lenTiles];

        // StringBuilder stb = new StringBuilder();

        // subs(tiles, stb, hs, visited);

        // // System.out.println(hs + " :HS");


        // return hs.size() - 1;


        // A similar but better approach would be to use a hashmap or frequency array 
        // As we dont need to output or show our possible sequences so using a global variable can help
        // Thus reducing our spcae complexity of O(n! * n)

        int freq[] = new int[26];

        for(int i = 0; i < tiles.length(); i ++){
            freq[tiles.charAt(i) - 'A'] ++;
        }

        HashSet<String> hs = new HashSet();
        int visited[] = new int[tiles.length()];

        StringBuilder stb = new StringBuilder();


        subsUsingFreq(tiles, stb, freq);

        return count - 1;

        // TC: O(n!)
        // SC: O(26) + O(n)

    }

    int count = 0;

    public void subsUsingFreq(String tiles, StringBuilder stb, int freq[]){
        
        count ++;

        for(int i = 0; i < 26; i ++){
            if(freq[i] == 0)continue;

            freq[i] -= 1;

            subsUsingFreq(tiles, stb, freq);
            
            freq[i] += 1;
        }
    }
}
