class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double ratio[][] =  new double[quality.length][2];
        
        for(int i = 0; i < quality.length; i ++){
            ratio[i][0] = (double)wage[i] / quality[i];
            ratio[i][1] = quality[i];
        }

        Arrays.sort(ratio, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Double> pq = new PriorityQueue(Collections.reverseOrder());

        double qualitySum = 0;

        for(int i = 0; i < k; i ++){                
                pq.add(ratio[i][1]);
                qualitySum += ratio[i][1];

               }          

        double mainRatio = ratio[k - 1][0];  
        double result = mainRatio * qualitySum;     

        double minAns = result;
        for(int main = k; main < quality.length; main ++){
            
            mainRatio = ratio[main][0];
            
            pq.add(ratio[main][1]);
            qualitySum += ratio[main][1];

            if(pq.size() > k){
                 qualitySum -= pq.peek();
                 pq.remove();
            }

            double ans = qualitySum * mainRatio;

            System.out.println("index: " + main + " Ans: " + ans);

            minAns = Math.min(minAns, ans);

        }


        return minAns;

    }
}
