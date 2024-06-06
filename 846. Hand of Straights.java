class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // TreeMap<Integer, Integer> tm = new TreeMap();

        // for(int i: hand){
        //     tm.put(i, tm.getOrDefault(i, 0) + 1);
        // }

        // while(!tm.isEmpty()){
        //     int first = tm.firstKey();           
            
        //     for(int i = first; i < first + groupSize; i++){
        //         if(!tm.containsKey(i))return false;
        //         else{
        //             int freq = tm.get(i);
        //             if(freq == 1)tm.remove(i);
        //             else{
        //                 tm.put(i, freq - 1);
        //             }
        //         }
        //     }
        // }

        // return true;

        // PriorityQueue<Pair> pq = new PriorityQueue(new MyComparator());

        // HashMap<Integer, Integer> tm = new HashMap();

        // for(int i: hand){
        //     tm.put(i, tm.getOrDefault(i, 0) + 1);
        // }

        // for(int i: tm.keySet()){
        //     pq.add(new Pair(i, tm.get(i)));
        // }

        // while(pq.size() > 0){
        //     Pair min = pq.poll();
        //     int prev = min.data;
        //     Queue<Pair> q = new LinkedList();
        //     min.freq --;
        //     for(int i = 1; i < groupSize; i++){
        //         if(pq.isEmpty())return false;
        //         if(pq.peek().data != prev + 1)return false;
        //         else{
        //             Pair minEl = pq.remove();
        //             minEl.freq --;
        //             prev = minEl.data;
        //             if(minEl.freq > 0){
        //                 q.add(minEl);
        //             }
        //         }
        //     }

        //     while(!q.isEmpty()){
        //         pq.add(q.poll());
        //     }
        //     if(min.freq > 0)pq.add(min);
        // }


        // return true;


        PriorityQueue<Pair> pq = new PriorityQueue(new MyComparator());

        HashMap<Integer, Integer> hm = new HashMap();

        for(int i: hand){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        for(int i: hm.keySet()){
            pq.offer(new Pair(i, hm.get(i)));
        }

        while(!pq.isEmpty()){
            Pair tem = pq.poll();
            int numCurr = tem.data;
            tem.freq --;

            Queue<Pair> q = new LinkedList();

            for(int i = 1; i < groupSize; i ++){
                if(pq.isEmpty())return false;
                if(pq.peek().data != numCurr + 1 ){
                    return false;
                }
                else{
                    Pair newCurr = pq.poll();
                    newCurr.freq --;
                    numCurr = newCurr.data; 
                    if(newCurr.freq > 0){
                        q.offer(newCurr);
                    }       
                              
                }
            }

            if(tem.freq > 0){
                q.offer(tem);
            }

            while(!q.isEmpty()){
                System.out.println(q.peek().data + " freq: " + q.peek().freq);
                pq.offer(q.poll());
            }
        }


        return true;


    }

    class Pair{
        int data;
        int freq;

        Pair(int data, int freq){
            this.data = data;
            this.freq = freq;
        }
    }

    class MyComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return Integer.compare(p1.data, p2.data);
        }
    }
}
