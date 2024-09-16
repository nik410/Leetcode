class Solution {

    public int calculateDiff(String t1, String t2){
        String hour1 = t1.substring(0, 2);
        String min1 = t1.substring(3, 5);

        String hour2 = t2.substring(0, 2);
        String min2 = t2.substring(3, 5);       

        int hourT1 = Integer.parseInt(hour1);
        int minT1 = Integer.parseInt(min1);

        int totalMinInT1 = hourT1 * 60 + minT1;

        int hourT2 = Integer.parseInt(hour2);
        int minT2 = Integer.parseInt(min2);

        int totalMinInT2 = hourT2 * 60 + minT2;

        int ans = Math.min(((1440 + totalMinInT1) - totalMinInT2), (totalMinInT2 - totalMinInT1));

        if(ans < 0)return 1440 + ans;

        return ans;
        
    }
    
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        if(timePoints.size() > 2)
        timePoints.add(timePoints.get(0));

        int ans = 1440;

        for(int i = 0; i < timePoints.size() - 1; i ++){
            ans =  Math.min(ans, (calculateDiff(timePoints.get(i), timePoints.get(i + 1))));
        }

        return ans;
    }
}
