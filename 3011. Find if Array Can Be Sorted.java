class Solution {

    public boolean check(int nums[], int numsSort[], int i, int j){
        ArrayList<Integer> groupS = new ArrayList<Integer>();
        ArrayList<Integer> groupO = new ArrayList<Integer>();

        for(int ind = i; ind < j; ind ++){
            groupS.add(numsSort[ind]);
            groupO.add(nums[ind]);

        }        
        
        Collections.sort(groupO);


        for(int ind = 0; ind < j - i; ind ++){
            System.out.println(ind +" :ind");
            if(!groupS.get(ind).equals(groupO.get(ind)))return false;
        }        

        return true;
    }

    public boolean canSortArray(int[] nums) {
        int numsSort[] = nums.clone();

        Arrays.sort(numsSort);

        int bitCount[] = new int[nums.length];

        for(int i = 0; i < nums.length; i ++){

            int num = nums[i];
            int count = 0;
            while(num > 0){
                if(num % 2 == 1){
                    count ++;
                }

                num /= 2;
            }

            bitCount[i] = count;
        }


        for(int i = 0; i < nums.length; i ++){
            
            int j = i + 1;           

            while(j < nums.length && bitCount[i] == bitCount[j]){
                j ++;                
            }

            if(!check(nums, numsSort, i, j)){
                return false;
            }

            i = j - 1;

        }

        return true;
    }
}
