class Solution {
    public int findMinArrowShots(int[][] points) {
       Arrays.sort(points, (a, b) -> {
    if (a[1] == b[1]) {
        return Integer.compare(a[0], b[0]);
    } else {
        return Integer.compare(a[1], b[1]);
    }
        });
        int minCount = 0;
        // for(int i = 0; i < points.length; i++){
        //     int start = points[i][0];
        //     int end = points[i][1];

        //     System.out.println(start + " " + end);
        //     }
        

        for(int i = 0; i < points.length; i++){
            int start = points[i][0];
            int end = points[i][1];
            int j = i;
            while(j < points.length && end >= points[j][0]){
                j++;
            }

            i = j - 1;
            minCount++;
        }

        return minCount;

       

    }
}
