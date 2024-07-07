class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // int ans = numBottles;
        // int emp = ans;
        // while(emp >= numExchange){
        //     int newBot =  emp / numExchange;
        //     int rem =  emp % numExchange;
        //     ans += newBot;
        //     emp = newBot + rem;           
        // }

        // return ans;

        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
