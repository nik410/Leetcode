class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, (x, y) -> {
            if(x[0] == y[0])return x[1]-y[1];
            else return x[0] - y[0];
        });

        int currMax = items[0][1];

        for(int i = 1; i < items.length; i ++){
            items[i][1] = Math.max(currMax, items[i][1]);
            currMax = Math.max(currMax, items[i][1]);
        }

       
    //    for(int i = 0; i < items.length; i ++){
    //         System.out.println(items[i][0] + " " + items[i][1]);
    //    }

       
        
      
        int ansArr[] = new int[queries.length];
        int index = 0;
        for(int i: queries){
            // Implementing binary search 
            int queryPrice = i;

            int l = 0, r = items.length - 1;
            int ans = 0;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(items[mid][0] <= queryPrice){
                    ans = Math.max(ans, items[mid][1]);
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }

            ansArr[index] = ans;
            index ++;
        }

        return ansArr;
    }
}
