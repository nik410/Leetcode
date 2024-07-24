class Solution {
    
    class Pair{
        int val;
        int newVal;
        Pair(int val, int newVal){
            this.val = val;
            this.newVal = newVal;
        }
    }

    class MyComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return Integer.compare(p1.newVal, p2.newVal);
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Pair arr[] = new Pair[nums.length];
        for(int i = 0; i < nums.length; i ++){
            int origVal = nums[i];
            String orig = Integer.toString(origVal);
            String newVal = "";
            int j = 0;
            while(j < orig.length()){
                char c = orig.charAt(j);
                newVal += "" +mapping[(int) (c - '0')]; 
                j ++;
            }

            arr[i] = new Pair(origVal, Integer.parseInt(newVal));
            
        }

        Arrays.sort(arr, new MyComparator());

        int ans[] = new int[nums.length];
        int index = 0;
        for(Pair p: arr){
            ans[index] = p.val;
            index ++;
        }


        return ans;

    }
}
