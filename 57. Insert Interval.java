class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> al = new ArrayList();
        int index = 0;
        
        //As the merging process can be for once for as mant contagious intervals once all 
        //such operation is done flag = true
        boolean flag = false;
        //If the no overlapping new Interval at start

        if(intervals.length == 0 || flag == false && intervals[0][0] > newInterval[1]){
            al.add(new ArrayList<Integer>());
             al.get(index).add(newInterval[0]);
              al.get(index).add(newInterval[1]);
           index++;
           flag = true;
        }


        
        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];


           
            if(end < newInterval[0] || flag == true){
                al.add(new ArrayList());
                al.get(index).add(start);
                al.get(index).add(end);
                index++;
            }
            else if(start <= newInterval[1]){
                int startNew = Math.min(newInterval[0], intervals[i][0]);
                int endNew = Math.max(end, newInterval[1]);
                int j = i;
                for(j = i + 1; j < intervals.length; j++){
                     int startNext = intervals[j][0];
                     int endNext = intervals[j][1];

                     if(startNext <= endNew){
                         endNew = Math.max(endNext, newInterval[1]);
                     }
                     else{
                        break;
                        }
                }
               al.add(new ArrayList());
                al.get(index).add(startNew);
                al.get(index).add(endNew);
                index++;
                i = j - 1;
                flag = true;
            }
            else if(start > newInterval[1]){
                if(flag == false){
                 al.add(new ArrayList<Integer>());
             al.get(index).add(newInterval[0]);
              al.get(index).add(newInterval[1]);
            index++;
             flag = true;
            }

                 al.add(new ArrayList());
                al.get(index).add(start);
                al.get(index).add(end);
                index++;
            }
        }

        //If there are no overlapping
        if(flag == false){
             al.add(new ArrayList<Integer>());
             al.get(index).add(newInterval[0]);
              al.get(index).add(newInterval[1]);
            index++;
        }

        
        int ansC[][] = new int[al.size()][2];
        for(int i = 0; i < al.size(); i++){
            ansC[i][0] = al.get(i).get(0);
            ansC[i][1] = al.get(i).get(1);
        }

        
       
        return ansC;
    }
}
