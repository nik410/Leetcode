class Solution {
    class ChairDetails{
        int arrival;
        int departure;
        int seatNumber;

        ChairDetails( int arrival, int departure, int seatNumber){
            this.arrival = arrival;
            this.departure = departure;
            this.seatNumber = seatNumber;
        }
    }

    class MyComparator implements Comparator<ChairDetails>{
        public int compare(ChairDetails c1, ChairDetails c2){
            if(c1.departure == c2 .departure)return c1.seatNumber - c2.seatNumber;
            return c1.departure - c2.departure;
        }
    }
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<ChairDetails> pq = new PriorityQueue(new MyComparator());

            

        int targetFriendArrival = times[targetFriend][0];

        Arrays.sort(times, (x, y) ->{return x[0] - y[0];});        
        
        TreeSet<Integer> pos = new TreeSet();

        for(int i = 0; i < times.length; i ++){
            int arr = times[i][0];
            int dep = times[i][1];            
            
            if(pq.size() == 0){
                pq.offer(new ChairDetails(arr, dep, 0));
                 if(arr == targetFriendArrival)return 0;
            }
            else{
                while(!pq.isEmpty() && pq.peek().departure <= arr){
                    pos.add(pq.peek().seatNumber);
                    pq.poll();
                }

                if(arr == targetFriendArrival){
                    if(pos.size() == 0){
                        return pq.size();
                    }
                    else{
                        return pos.first();
                    }
                }
                else{
                    if(pos.size() == 0)
                     pq.offer(new ChairDetails(arr, dep, pq.size()));
                     else{
                         pq.offer(new ChairDetails(arr, dep, pos.first()));
                         pos.remove(pos.first());
                     }
                }

            }
 
          
        }

        return 0;

    }
}


