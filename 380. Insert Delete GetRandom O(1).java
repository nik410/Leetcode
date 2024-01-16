class RandomizedSet {

    HashMap<Integer, Integer> hm = new HashMap();
    ArrayList<Integer> al = new ArrayList();
    Random r = new Random(); 
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val))return false;
        else{
            al.add(val);
            hm.put(val, al.size() - 1);
            
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val))return false;
        else{
            int indexVal = hm.get(val);
            int lastEle = al.get(al.size() - 1);

            al.set(indexVal, lastEle);           

            hm.put(lastEle, indexVal);

            hm.remove(val);
            al.remove(al.size() - 1);

            return true;
        }
    }
    
    public int getRandom() {
        int rand = r.nextInt(al.size());
        return al.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
