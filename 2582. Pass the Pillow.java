class Solution {
    public int passThePillow(int n, int time) {
        if(time < n - 1)return time + 1;
        else{
            if((time / (n - 1)) % 2 == 1)
                return n - time % (n - 1);
            else{
                return time % (n - 1) + 1;
            }
            
        }
    }
}
