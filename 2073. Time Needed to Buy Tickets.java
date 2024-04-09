class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        //One way to solve this is using Queue bruteforce TC - O(n^2) 

        //Greedy Way of solving this

        int timeReq = 0;

        for(int i = 0; i < tickets.length; i++){
            if(i <= k){
                timeReq += Math.min(tickets[i], tickets[k]);
            }
            else{
                timeReq += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return timeReq;
    }
}
