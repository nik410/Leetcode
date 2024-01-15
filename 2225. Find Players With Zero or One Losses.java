class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> hm = new HashMap();
        List<List<Integer>> ans = new ArrayList();
        TreeSet<Integer> winners = new TreeSet();
         TreeSet<Integer> losers = new TreeSet();
        for(int i = 0; i < matches.length; i++){
            int winner = matches[i][0];
            int loser = matches[i][1];
            hm.put(loser, hm.getOrDefault(loser, 0) + 1);
            if(!hm.containsKey(winner)){
                winners.add(winner);
            }
            if(winners.contains(loser)) {
                winners.remove(loser);
            }

            if(hm.get(loser) == 1){
                losers.add(loser);
            }
            else{
                int freq = hm.get(loser);
                if(freq >= 2)losers.remove(loser);
            }

        }
        List<Integer> win = new ArrayList();
         List<Integer> los = new ArrayList();
        for(int i: winners){
                win.add(i);
        }

        for(int i: losers){
                los.add(i);
        }
        ans.add(win);
        ans.add(los);

        return ans;
    }
}
