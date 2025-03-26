class Solution {
    public int minOperations(int[][] grid, int x) {
        int sum = 0;
        int mod = -1;

        ArrayList<Integer> al = new ArrayList();
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j ++){
                al.add(grid[i][j]);
                if(i == 0 && j == 0){
                    mod = grid[i][j] % x;
                }
                else{
                    if(grid[i][j] % x != mod){
                        return -1;
                    }
                }
            }
        }

        Collections.sort(al);

        int med = al.get(al.size() / 2);
        int ans  = 0;
        for(int i: al){
            ans += Math.abs((i - med)) / x;
        }

        return ans;

        
        
    }
}
