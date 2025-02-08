class NumberContainers {
    
    HashMap<Integer, TreeSet<Integer>> hm;
    HashMap<Integer, Integer> hm1;

    public NumberContainers() {
        hm = new HashMap();
        hm1 = new HashMap();
    }
    
    public void change(int index, int number) {
        
        if(hm.containsKey(number)){
            if(hm1.containsKey(index)){
                int prevValAtInd = hm1.get(index);

                TreeSet<Integer> ts = hm.get(prevValAtInd);
                ts.remove(index);
                hm1.remove(index);
                hm.put(prevValAtInd, ts);
                 if (ts.isEmpty()) {
                    hm.remove(prevValAtInd);
                }
            }
            
                TreeSet<Integer> ts = hm.getOrDefault(number, new TreeSet<Integer>());
                ts.add(index);
                hm.put(number, ts);
            
        }
        else{
            if(hm1.containsKey(index)){
                int prevValAtInd = hm1.get(index);

                TreeSet<Integer> ts = hm.get(prevValAtInd);
                ts.remove(index);

                
                hm1.remove(index);
                hm.put(prevValAtInd, ts);
                 if (ts.isEmpty()) {
                hm.remove(prevValAtInd);
            }
            }
          
                TreeSet<Integer> ts = hm.getOrDefault(number, new TreeSet<Integer>());
                ts.add(index);
                hm.put(number, ts);
            
        }
        hm1.put(index, number);

    }
    
    public int find(int number) {
        if(!hm.containsKey(number)){
            return -1;
        }
        else{
            TreeSet<Integer> tm = hm.get(number);
            Iterator<Integer> it = tm.iterator();

            // System.out.println(tm);
            if(it.hasNext()){
                return it.next();
            }
            else
            return -1;
        }
    }

}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
