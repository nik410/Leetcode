class Solution {

    class Ipo{
        int capital;
        int profit;
       

        Ipo(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
            
        }
    }

    class MyComparator implements Comparator<Ipo>{
        public int compare(Ipo i1, Ipo i2){
            return Double.compare(i2.profit, i1.profit);
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Ipo arr[] = new Ipo[n];

        PriorityQueue<Ipo> pq = new PriorityQueue(new MyComparator());

        for(int i = 0 ; i < n; i ++){
            int cap = capital[i];
            int pro = profits[i];
            arr[i] = new Ipo(cap, pro);
        }

        Arrays.sort(arr, (a1, a2) -> Integer.compare(a1.capital, a2.capital));

        // for(Ipo i: arr)

        // // System.out.println(i.capital  +"  pro: " + i.profit);

        int ans = w;
        int i = 0;
        while(k -- > 0 ){
            while(i < n && arr[i].capital <= w){
                pq.offer(new Ipo(arr[i].capital, arr[i].profit));
                i ++;
            }

            if(pq.size() == 0){
                break;
            }
            else{
                Ipo tem = pq.poll();

                ans += tem.profit;
                w += tem.profit;
            }
           
        }

        return ans;


    }
}
