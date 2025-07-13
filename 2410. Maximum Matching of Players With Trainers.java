class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int index = trainers.length - 1;

        int ans = 0;

        for(int i = players.length - 1; i >= 0 && index >= 0; i --){
            if(trainers[index] >= players[i]){
                ans ++;
                index --;
            }            
        }
        return ans;
    }
}
