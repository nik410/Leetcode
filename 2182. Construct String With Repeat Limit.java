class Solution {
    class Pair{
        char c;
        int freq;

        Pair(char c, int freq){
            this.c = c;
            this.freq = freq;
        }

        public String toString(){
            return "C: " + c + " Freq: " + freq;
        }
    }

    class MyComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return Integer.compare((int) p2.c, (int)p1.c);
        }
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Pair> pq = new PriorityQueue(new MyComparator());

        int[] arr = new int[26];
        
        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            arr[(int)(ch - 'a')] ++;
        }

        for(int i = 0; i < 26; i ++){
            if(arr[i] > 0)
            pq.offer(new Pair((char)(i + 'a'), arr[i]));
        }

        // System.out.println(pq);

        StringBuilder ans = new StringBuilder();

        int flag = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int count = Math.min(p.freq, repeatLimit);
            for(int i = 0; i < count; i ++){
                ans.append(p.c);
            }

            p.freq -= count;

            if(p.freq > 0){
                if(pq.isEmpty())break;
                Pair p1 = pq.poll();
                ans.append(p1.c);
                p1.freq -= 1;

                if(p1.freq > 0){
                    pq.offer(p1);
                }

                pq.offer(p);
            }
        }
        

        return ans.toString();
    }
}

