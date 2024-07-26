class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int adjmat[][] = new int[n][n];

        for(int i[]: edges){
            adjmat[i[0]][i[1]] = i[2];
            adjmat[i[1]][i[0]] = i[2];
        }

         for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
               if(adjmat[i][j] == 0 && i != j)adjmat[i][j] = Integer.MAX_VALUE;
            }
        }

        // System.out.println("----------");


        // for(int i = 0; i < n; i ++){
        //     for(int j = 0; j < n; j ++){
        //         System.out.print(adjmat[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        

        for(int k = 0; k < n; k ++){
            for(int i = 0; i < n; i ++){               
                for(int j = 0; j < n; j ++){
                    if(adjmat[i][k] <  Integer.MAX_VALUE && adjmat[k][j] <  Integer.MAX_VALUE ){
                        adjmat[i][j] = Math.min(adjmat[i][j], adjmat[i][k] + adjmat[k][j]);
                    }
                }
            }
        }

        //  System.out.println("----------");

        // for(int i = 0; i < n; i ++){
        //     for(int j = 0; j < n; j ++){
        //         System.out.print(adjmat[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int countCity = n;
        int ans = -1;

        for(int i = 0; i < n; i ++){
            int count = 0;
            for(int j = 0; j < n; j ++){
                if(adjmat[i][j] <= distanceThreshold){
                    count ++;
                }
            }

            System.out.println((count) + " :count i: " + i);
            if((count) <= countCity){
                ans = i;
                countCity = count;
            }
        }


        return ans;

    }
}


