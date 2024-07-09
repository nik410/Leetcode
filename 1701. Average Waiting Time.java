class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitTime  = customers[0][1];
        int prevDishTime = customers[0][0] + customers[0][1];
        for(int i = 1; i < customers.length; i ++){
            int dishTime = prevDishTime + customers[i][1];
            //System.out.println("index: " + i + "dishTime: " + dishTime + " Time req: " + (dishTime - customers[i][0]));
            if(customers[i][0] <= prevDishTime){
                totalWaitTime += dishTime - customers[i][0];
                prevDishTime = dishTime;
            }
            else{
                totalWaitTime += customers[i][1];
                 prevDishTime = customers[i][0] + customers[i][1];
            }
            
        }

        return totalWaitTime / customers.length;
    }
}
