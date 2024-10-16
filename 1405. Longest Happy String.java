class Solution {
    class Pair{
        int occ;
        char c;

        Pair(int occ, char c){
            this.occ = occ;
            this.c = c;
        }
    }

    class MyComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return p2.occ - p1.occ;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue(new MyComparator());
        if(a > 0)
        pq.offer(new Pair(a,'a'));
        if(b > 0)
        pq.offer(new Pair(b, 'b'));
        if(c > 0)
        pq.offer(new Pair(c, 'c'));

        String ans = "";

        while(!pq.isEmpty()){
            if(ans.length() <= 1){
                Pair temp = pq.poll();
                
                    ans += temp.c + "";
                    if(temp.occ - 1 > 0){
                        pq.offer(new Pair(temp.occ - 1, temp.c));
                    }
                
            }
            else{
                Pair temp = pq.poll();

                if(ans.charAt(ans.length() - 1) == temp.c && ans.charAt(ans.length() - 2) == temp.c){
                    if(pq.size() == 0)break;
                    else{
                        Pair temp1 = pq.poll();
                       
                            ans += temp1.c + "";
                            if(temp1.occ - 1 > 0){
                                pq.offer(new Pair(temp1.occ - 1, temp1.c));
                            }
                        
                        pq.offer(temp);
                    }

                }
                else{
                  
                    ans += temp.c + "";
                    if(temp.occ - 1 > 0){
                        pq.offer(new Pair(temp.occ - 1, temp.c));
                    }
                
            }
                
            }
        }



       

        return ans;


    }
}
