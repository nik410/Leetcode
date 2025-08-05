class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> fruitFreq = new HashMap();
        int len = fruits.length;
        int i = 0, j = 0;
        int res = 0;
        while(j < len){
            fruitFreq.put(fruits[j], fruitFreq.getOrDefault(fruits[j], 0) + 1);

            while(i <= j && fruitFreq.size() > 2){
                int type = fruits[i];

                if(fruitFreq.get(type) == 1){
                    fruitFreq.remove(type);
                }
                else{
                    fruitFreq.put(type, fruitFreq.get(type) - 1);
                }

                i ++;
            }

            res = Math.max(j - i + 1, res);
            j ++;
        }

        return res;
    }
}
